package huffman;
/**
 * A leaf node in a tree, meaning it has no children. 
 *
 */
public class Leaf extends Node {
	public final Character character;
	private final Integer frequency;
	
	public Leaf(Character ch, Integer freq) {
		this.character = ch;
		this.frequency = freq;
	}
	
	public int getFrequency() {
		return this.frequency;
	}
	
	public Character getChar() {
		return this.character;
	}
	
	public int compareTo(Node node) {
		return Integer.compare(frequency, node.getFrequency());
	}
}
