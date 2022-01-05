package huffman;

public interface HuffmanInterface <T>{
	/**
	 * Encodes Huffman Code.
	 */
	public T encode();
	/**
	 * Deodes Huffman Code.
	 */
	public T decode(T t);
	/**
	 * Prints generated Huffman Code.
	 */
	public void printHuffmanCode();
}
