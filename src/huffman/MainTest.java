package huffman;

import javax.swing.JFileChooser;

public class MainTest {
	public static void main(String[] args) {
		JFileChooser jfc = new JFileChooser();
		String originalText = "Lorem Ipsum";
		if (originalText.length() > 1) {
			System.out.println("The original text is: " + originalText);
			Huffman huffman = new Huffman(originalText);

			String encodedText = huffman.encode();
			System.out.println("First Encoded text is: " + encodedText);
			System.out.print("First Generated Huffman Code is: ");
			huffman.printHuffmanCode();
/*
			String originalText2 = "asdf aserawvoi";
			Huffman huffman2 = new Huffman(originalText2);
			String encodedText2 = huffman2.encode();
			System.out.println("\nSecond Encoded text is: " + encodedText2);
			System.out.print("Second Generated Huffman Code is: ");
			huffman2.printHuffmanCode();*/

			String decodedText = huffman.decode(encodedText);
			System.out.println("\n" + decodedText);

			boolean compared = originalText.compareTo(decodedText) == 0;
			String isSame = "Is first original text and decoded one the same?";
			System.out.println((compared) ? isSame + " yes" : isSame + " no");
/*
			String decodedText2 = huffman2.decode(encodedText2);
			System.out.println("\n" + decodedText2);

			boolean compared2 = originalText.compareTo(decodedText) == 0;
			String isSame2 = "Is second original text and decoded one the same?";
			System.out.println((compared2) ? isSame2 + " yes" : isSame2 + " no");*/

		}
	}
}
