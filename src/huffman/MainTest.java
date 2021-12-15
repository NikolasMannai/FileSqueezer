package huffman;

public class MainTest {
	public static void main(String[] args) {		
		String originalText = "aaaaabbbbcccccdddd";
		System.out.println("The original text is: " + originalText);
		Huffman huffman = new Huffman(originalText);
		
		String encodedText = huffman.encode();
		System.out.println("Encoded text is: " + encodedText);
		System.out.print("Generated Huffman Codes are: ");
		huffman.printHuffmanCode();
		
		String decodedText = huffman.decode(encodedText);
		System.out.println("\n" + decodedText);
		
		boolean compared = originalText.compareTo(decodedText) == 0;
		
		System.out.println("Is original text and decoded one the same? " + compared);
	}
}
