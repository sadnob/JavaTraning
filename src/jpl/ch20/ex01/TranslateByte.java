package jpl.ch20.ex01;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte {

	public static void main(String[] args) throws IOException {
		byte from = (byte) 'l';
		byte to = (byte) 'f';

		ByteArrayInputStream in = new ByteArrayInputStream(
				"Hello world".getBytes("utf-8"));
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		translateByte_stream(in, out, from, to);

		int a = 0;
	}

	public static void translateByte_stream(InputStream in, OutputStream out,
			byte from, byte to) throws IOException {

		int check;

		while ((check = in.read()) != -1) {
			out.write(check == from ? to : check);
		}

		out.flush();

	}

}