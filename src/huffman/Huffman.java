package huffman;

import java.util.HashMap;
import java.util.Map;

import huffmanPriok.PriorityQueueMain;

/**
 * Creates a class for huffman coding. Class takes in a String of text as an
 * argument. It uses priority Queue to store node elements.
 * 
 * @author Nikolas Mannai, Oliver Johnsson
 */
public class Huffman<T extends Comparable<? super T>> {
	private Node root;
	private String text;
	private Map<Character, Integer> charFrequencies;
	private Map<Character, String> huffmanCode;
	private PriorityQueueMain<Node> queue;

	/**
	 * Constructor for Huffman. Creates a hashmap for frequency of each character
	 * and one for huffman code.
	 * 
	 * @param text String to encode using Huffman
	 */
	public Huffman(String text) {
		this.text = text;
		fillCharFrequencies();
		huffmanCode = new HashMap<>();
	}

	/**
	 * Fills hashmap of character frequencies. For each character ethier creates a
	 * new entry in the hashmap, or increase the value of frequency stored if
	 * already in the map
	 */
	private void fillCharFrequencies() {
		charFrequencies = new HashMap<>();
		for (char character : text.toCharArray()) {
			Integer integer = charFrequencies.get(character);
			charFrequencies.put(character, integer != null ? integer + 1 : 1);
		}
	}

	/**
	 * Encodes a text using huffman Adds all Leafs into the priority Queue. Then
	 * dequeues lowest frequency elements and use them to generete new nodes until only the root node is left. 
	 * @return String encoded text
	 */
	public String encode() {
		queue = new PriorityQueueMain<>();
		charFrequencies.forEach((character, frequency) -> queue.enqueue(new Leaf(character, frequency)));
		while (queue.size() > 1) {
			queue.enqueue(new InternalNode(queue.dequeue(), queue.dequeue()));
		}
		generateHuffmanCode(root = queue.dequeue(), "");
		return getEncodedText();
	}

	/**
	 * returns encoded text.
	 * 
	 * @return String encoded text
	 */
	private String getEncodedText() {
		StringBuilder sb = new StringBuilder();
		for (char character : text.toCharArray()) {
			sb.append(huffmanCode.get(character));
		}
		return sb.toString();
	}

	/**
	 * Generates huffman code for each character. Starts with a root and keeps going
	 * until leaf node is reached. For every step to the left, adds 0 to the string. For every step to the right, adds 1 to the string
	 * @param node that is root
	 * @param code String coded representation of a character
	 */
	private void generateHuffmanCode(Node node, String code) {
		if (node instanceof Leaf) {
			huffmanCode.put(((Leaf) node).getChar(), code);
			return;
		}
		generateHuffmanCode(((InternalNode) node).getLeftChild(), code.concat("0"));
		generateHuffmanCode(((InternalNode) node).getRightChild(), code.concat("1"));
	}

	/**
	 * Decodes an encoded text. Traverses the tree for every digit for left if it is a zero, or one if it is right until a leaf node is reached. 
	 * After every leaf match goes back to root in order to decode the next digit.  
	 * @param encodedText String encoded text
	 * @return String decoded text
	 */
	public String decode(String encodedText) {
		StringBuilder sb = new StringBuilder();
		Node current = root;
		for (char character : encodedText.toCharArray()) {
			current = character == '0' ? ((InternalNode) current).getLeftChild() 
					: ((InternalNode) current).getRightChild();
			if (current instanceof Leaf) {
				sb.append(((Leaf) current).getChar());
				current = root;
			}
		}
		return sb.toString();
	}

	/**
	 * Prints generated huffman codes
	 */
	public void printHuffmanCode() {
		huffmanCode.forEach((character, code) -> System.out.print(character.toString() + " - " + code + " "));
	}

	/**
	 * Prints size of a charFrequencies. Value should be 256.
	 */
	public void printHashTable() {
		System.out.print(charFrequencies.size());
	}
}
