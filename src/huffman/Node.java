package huffman;
/**
 * A node in a tree. Two classes extend this class: InternalNode and Leaf. 
 * 
 */
public abstract class Node implements Comparable<Node>{
	Node() {	
	}
	protected abstract int getFrequency();	
}
