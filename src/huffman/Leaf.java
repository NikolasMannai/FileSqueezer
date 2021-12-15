package huffman;
/**
 * A leaf node in a tree, meaning it has no children. 
 *
 */
public class Leaf extends Node{
	public final Character character;
	private final Integer frequency;
	
	public Leaf(Character ch, Integer freq) {
		this.character = ch;
		this.frequency = freq;
	}
}
