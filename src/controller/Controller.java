package controller;

import java.io.FileInputStream; 
import java.io.FileOutputStream;
import java.io.IOException;

import gui.Graphics;
import huffman.BitReader;
import huffman.BitWriter;
import huffman.Huffman;
/**
 * Simple program for huffman Coding. 
 * @author Nikolas Mannai, Oliver Jonsson
 */
public class Controller {
	Controller controller;

	public static void main(String[] args) {
		Controller controller = new Controller();
	}
	/**
	 * Creates a controller and a mainframe. Makes graphics visible.
	 */
	Controller() {
		this.controller = this;
		Graphics mainFrame = new Graphics(this);
		mainFrame.setVisible(true);
	}
	/**
	 * Encodes a file using by streaming bits.
	 * @param String file path
	 * @throws IOException
	 */
	public void run(String filePath) throws IOException {
		int a = 0;
		BitReader bR = new BitReader(new FileInputStream(filePath));
		StringBuilder sb = new StringBuilder();
		while (a != -1) {
			a = bR.read();
			sb.append(a);
		}
		char nextChar;
		sb.delete(sb.length() - 2, sb.length());
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i <= sb.length() - 8; i += 8) {
			nextChar = (char) Integer.parseInt(sb.substring(i, i + 8), 2);
			sb2.append(nextChar);
		}
		System.out.println("*--------------------*\nBitStreamInput done");
		String originalText = sb2.toString();
		System.out.println("*--------------------*\nEncoding Text");
		Huffman huffman = new Huffman(originalText);
		String encodedText = huffman.encode();
		System.out.println("*--------------------*\nEncoding Done");
		System.out.print("*--------------------*\nDone generating codes");
		huffman.printHuffmanCode();
		String decodedText = huffman.decode(encodedText);
		System.out.println("\n*--------------------*\nDone Decoding Text");
		boolean compared = originalText.compareTo(decodedText) == 0;
		String isSame = "*--------------------*\nIs generated Code the same?\n*--------------------*\n";
		System.out.println((compared) ? isSame + "yes" : isSame + "no");
		BitWriter bW = new BitWriter(new FileOutputStream("huffman"));
		for (int i = 0; i < encodedText.length(); i++) {
			nextChar = encodedText.charAt(i);
			bW.write(Integer.parseInt(Integer.toBinaryString(nextChar)));
		}
		System.out.print("*--------------------*\nbits written: " + bW.bitsWritten());
		bW.close();
		BitWriter bW2 = new BitWriter(new FileOutputStream("HuffmanDecoded"));
		for (int j = 0; j < decodedText.length(); j++) {
			nextChar = decodedText.charAt(j);
			String characterInBinary = String.format("%8s", Integer.toBinaryString(nextChar)).replace(' ', '0');
			for(int k = 0; k < characterInBinary.length(); k++) {
				bW2.write(Integer.parseInt(characterInBinary.substring(k,k+1)));
			}
		}
		bW2.close();
	}
}
