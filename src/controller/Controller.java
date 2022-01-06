package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import gui.Graphics;
import huffman.BitReader;
import huffman.BitWriter;
import huffman.Huffman;

public class Controller {
	Controller controller;

	public static void main(String[] args) {
		Controller controller = new Controller();
	}

	Controller() {
		this.controller = this;
		Graphics mainFrame = new Graphics(this);
		mainFrame.setVisible(true);
	}

	public void encode(String filePath)
			throws IOException {
		int a = 0;
		BitReader bR = new BitReader(new FileInputStream(filePath));
		StringBuilder sb = new StringBuilder();
		while (a != -1) {
			a = bR.read();
			sb.append(a);
		}
		char nextChar;
		sb.delete(sb.length()-2, sb.length());
		StringBuilder sb2 = new StringBuilder();
		for(int i = 0; i <= sb.length()-8; i += 8) {
			nextChar = (char)Integer.parseInt(sb.substring(i, i+8), 2);
			sb2.append(nextChar);
		}
		System.out.println("BitStreamInput is: " + sb.toString());
		String originalText = sb2.toString();
		System.out.println("The original text is: " + originalText);
		Huffman huffman = new Huffman(originalText);
		String encodedText = huffman.encode();
		System.out.println("First Encoded text is: " + encodedText);
		System.out.print("First Generated Huffman Code is: ");
		huffman.printHuffmanCode();
		String decodedText = huffman.decode(encodedText);
		System.out.println("\n" + decodedText);
		boolean compared = originalText.compareTo(decodedText) == 0;
		String isSame = "Is first original text and decoded one the same?";
		System.out.println((compared) ? isSame + " yes" : isSame + " no");
		BitWriter bW = new BitWriter(new FileOutputStream("huffman.txt"));
		for(int i = 0; i < encodedText.length(); i++) {
			nextChar = encodedText.charAt(i);
			bW.write(Integer.parseInt(Integer.toBinaryString(nextChar)));
		}
		System.out.print("bits written: " + bW.bitsWritten());
		bW.close();
	}

	public void decode(String filePath) {
		System.out.print(filePath);

	}
}
