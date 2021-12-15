package huffman;
	/**
	 * Internal Node in the tree. Has only two children. 
	 *
	 */
public class InternalNode extends Node {
	private final Node leftChild;
	private final Node rightChild;
	private final int frequency;
	public InternalNode(Node left, Node right) {
		this.leftChild = left;
		this.rightChild = right;
		this.frequency = leftChild.getFrequency() + rightChild.getFrequency();
	}
	
	public int getFrequency() {
		return this.frequency;
	}
	
	public Node getLeftChild() {
		return this.leftChild;
	}
	
	public Node getRightChild() {
		return this.rightChild;
	}

	@Override
	public int compareTo(Node node) {
		return Integer.compare(frequency, node.getFrequency());
	}
}
