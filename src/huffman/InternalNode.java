package huffman;
	/**
	 * Internal Node in the tree. Has only two children. 
	 * @author Nikolas Mannai, Oliver Jonsson
	 */
public class InternalNode extends Node {
	private final Node leftChild;
	private final Node rightChild;
	private final int frequency;
	/**
	 * constructor for an internal node. It takes in two Nodes.
	 * @param Node left child
	 * @param Node right child
	 */
	public InternalNode(Node left, Node right) {
		this.leftChild = left;
		this.rightChild = right;
		this.frequency = leftChild.getFrequency() + rightChild.getFrequency();
	}
	/**
	 * returns frequency.
	 * @return Integer
	 */
	public int getFrequency() {
		return this.frequency;
	}
	/**
	 * returns leftChild.
	 * @return Node left child
	 */
	public Node getLeftChild() {
		return this.leftChild;
	}
	/**
	 * returns rightChild.
	 * @return Node right child
	 */
	public Node getRightChild() {
		return this.rightChild;
	}
	/**
	 * Compares frequency to another node. Takes Node argument.
	 * @param Node to compare to
	 * @return Int bigger frequency of two nodes
	 */
	@Override
	public int compareTo(Node node) {
		return Integer.compare(frequency, node.getFrequency());
	}
}
