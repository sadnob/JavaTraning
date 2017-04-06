package jpl.ch20.ex02;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class TranslateByte extends FilterReader {

	byte from;
	byte to;
	protected TranslateByte(Reader read, byte from, byte to) {
		super(read);
		this.from = from;
		this.to = to;
	}

	@Override
	public int read() throws IOException {
		int check;
		check = super.read();
		return (check == -1 ? check : (check == from ? to : check));

	}

	public static void main(String[] args) throws IOException {
		StringReader str = new StringReader("Hello world");
		FilterReader filterR = new TranslateByte(str, (byte)'l', (byte)'f');

		int check;
		while((check = filterR.read()) != -1){
			System.out.print((char)check);
		}
	}

}