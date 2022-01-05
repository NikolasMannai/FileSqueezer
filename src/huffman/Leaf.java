package huffman;
/**
 * A leaf node in a tree, meaning it has no children. 
 *
 */
public class Leaf extends Node {
	public final Character character;
	private final Integer frequency;
	/*
	 * constructor for class Leaf. Takes in arguments character and frequency.
	 */
	public Leaf(Character ch, Integer freq) {
		this.character = ch;
		this.frequency = freq;
	}
	/*
	 * returns frequency.
	 */
	public int getFrequency() {
		return this.frequency;
	}
	/*
	 * returns character
	 */
	public Character getChar() {
		return this.character;
	}
	/*
	 * Compares frequency to another node. Takes argument Node.
	 */
	public int compareTo(Node node) {
		return Integer.compare(frequency, node.getFrequency());
	}
}
