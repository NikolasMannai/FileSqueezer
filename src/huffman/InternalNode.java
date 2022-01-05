package huffman;
	/**
	 * Internal Node in the tree. Has only two children. 
	 *
	 */
public class InternalNode extends Node {
	private final Node leftChild;
	private final Node rightChild;
	private final int frequency;
	/*
	 * constructor for an internal node. It takes in two Nodes.
	 */
	public InternalNode(Node left, Node right) {
		this.leftChild = left;
		this.rightChild = right;
		this.frequency = leftChild.getFrequency() + rightChild.getFrequency();
	}
	/*
	 * returns frequency.
	 */
	public int getFrequency() {
		return this.frequency;
	}
	/*
	 * returns leftChild.
	 */
	public Node getLeftChild() {
		return this.leftChild;
	}
	/*
	 * returns rightChild.
	 */
	public Node getRightChild() {
		return this.rightChild;
	}
	/*
	 * Compares frequency to another node. Takes Node argument.
	 */
	@Override
	public int compareTo(Node node) {
		return Integer.compare(frequency, node.getFrequency());
	}
}
