package huffman;
/**
 * A node in a tree. Two classes extend this class: InternalNode and Leaf.
 * @author Nikolas Mannai, Oliver Jonson
 */
public abstract class Node implements Comparable<Node>{
	Node() {	
	}
	/**
	 * returns frequency of a node object.
	 */
	protected abstract int getFrequency();	
}
