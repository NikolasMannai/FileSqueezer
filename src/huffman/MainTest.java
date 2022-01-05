package huffman;

import javax.swing.JFileChooser;

public class MainTest {
	public static void main(String[] args) {
		JFileChooser jfc = new JFileChooser();
		String originalText = "ABCDE";
		if (originalText.length() > 1) {
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
		}
	}
}
