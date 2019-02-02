package com.faall1n.survival.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class getServer {
	private InetSocketAddress host;
	public JSONObject json;
	private int timeoutInt;
	public String motd;
	public int JogadoresMaximo;
	public int JogadoresOnline;

	public getServer(final String ip, final int porta) {
		this.timeoutInt = 5;
		this.motd = null;
		this.JogadoresMaximo = 0;
		this.JogadoresOnline = 0;
		this.host = new InetSocketAddress(ip, porta);
		this.timeoutInt = 1000;
		try {
			this.fetchData();
		} catch (IOException ex) {
		} catch (ParseException ex2) {
		}
	}

	@SuppressWarnings("resource")
	public void fetchData() throws IOException, ParseException {
		final Socket socket = new Socket();
		socket.setSoTimeout(this.timeoutInt);
		socket.connect(this.host, this.timeoutInt);
		final OutputStream outputStream = socket.getOutputStream();
		final DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		final InputStream inputStream = socket.getInputStream();
		final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		final ByteArrayOutputStream b = new ByteArrayOutputStream();
		final DataOutputStream handshake = new DataOutputStream(b);
		handshake.writeByte(0);
		this.writeVarInt(handshake, 47);
		this.writeVarInt(handshake, this.host.getHostString().length());
		handshake.writeBytes(this.host.getHostString());
		handshake.writeShort(this.host.getPort());
		this.writeVarInt(handshake, 1);
		this.writeVarInt(dataOutputStream, b.size());
		dataOutputStream.write(b.toByteArray());
		dataOutputStream.writeByte(1);
		dataOutputStream.writeByte(0);
		final DataInputStream dataInputStream = new DataInputStream(inputStream);
		this.readVarInt(dataInputStream);
		int id = this.readVarInt(dataInputStream);
		if (id == -1) {
			throw new IOException("ERRO");
		}
		final int length = this.readVarInt(dataInputStream);
		if (length == -1) {
			throw new IOException("ERRO");
		}
		final byte[] in = new byte[length];
		dataInputStream.readFully(in);
		final String json = new String(in);
		final long now = System.currentTimeMillis();
		dataOutputStream.writeByte(9);
		dataOutputStream.writeByte(1);
		dataOutputStream.writeLong(now);
		this.readVarInt(dataInputStream);
		id = this.readVarInt(dataInputStream);
		if (id == -1) {
			throw new IOException("ERRO");
		}
		this.json = (JSONObject) new JSONParser().parse(json);
		dataOutputStream.close();
		outputStream.close();
		inputStreamReader.close();
		inputStream.close();
		socket.close();
		this.processarTudo();
	}

	private JSONObject getJson() {
		if (this.json == null) {
			return null;
		}
		return this.json;
	}

	public int pegarJogadoresOnline() {
		return this.JogadoresOnline;
	}

	public int pegarJogadoresMaximo() {
		return this.JogadoresMaximo;
	}

	public String pegarMotd() {
		return this.motd;
	}

	public boolean estaFechado() {
		return this.json == null;
	}

	@SuppressWarnings("unchecked")
	public void processarTudo() {
		this.motd = String.valueOf(this.getJson().get((Object) "description")).replace("\u00c2", "");
		final JSONArray array = new JSONArray();
		JSONObject site = null;
		array.add(this.getJson().get((Object) "players"));
		for (int i = 0; i < array.size(); ++i) {
			site = (JSONObject) array.get(i);
		}
		this.JogadoresMaximo = (int) (long) site.get((Object) "max");
		this.JogadoresOnline = (int) (long) site.get((Object) "online");
	}

	private int readVarInt(final DataInputStream in) throws IOException {
		int i = 0;
		int j = 0;
		int k;
		do {
			k = in.readByte();
			i |= (k & 0x7F) << j++ * 7;
			if (j > 5) {
				throw new RuntimeException("VarInt muito grande");
			}
		} while ((k & 0x80) == 0x80);
		return i;
	}

	private void writeVarInt(final DataOutputStream out, int paramInt) throws IOException {
		while ((paramInt & 0xFFFFFF80) != 0x0) {
			out.writeByte((paramInt & 0x7F) | 0x80);
			paramInt >>>= 7;
		}
		out.writeByte(paramInt);
	}
}
