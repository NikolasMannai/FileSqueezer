package huffman;
	/**
	 * Internal Node in the tree. Has only two children. 
	 *
	 */
public class InternalNode extends Node {
	public final Node leftChild;
	public final Node rightChild;
	
	public InternalNode(Node left, Node right) {
		this.leftChild = left;
		this.rightChild = right;
	}
}
