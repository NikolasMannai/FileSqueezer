package huffman;
/**
 * A leaf node in a tree, meaning it has no children. 
 * @author Nikolas Mannai, Oliver Jonson
 */
public class Leaf extends Node {
	private final Character character;
	private final Integer frequency;
	/**
	 * constructor for class Leaf. Takes in arguments character and frequency.
	 * 
	 * @param Character
	 * @param Integer
	 */
	public Leaf(Character ch, Integer freq) {
		this.character = ch;
		this.frequency = freq;
	}
	/**
	 * returns frequency.
	 * @return Integer
	 */
	public int getFrequency() {
		return this.frequency;
	}
	/**
	 * returns character
	 * @return Character
	 */
	public Character getChar() {
		return this.character;
	}
	/**
	 * Compares frequency to another node. Takes argument Node.
	 * @param Node
	 * @return int 
	 */
	public int compareTo(Node node) {
		return Integer.compare(frequency, node.getFrequency());
	}
}
