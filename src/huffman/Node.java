package huffman;

public class Node {
	/*
	 Istället för att kontrollera om en nod är en leaf, skapa en objekt leaf som extendar nod och slippa kontrollen?
	 */
	private Character character = null;
	private int frequency;
	private Node leftNode = null, rightNode = null;
	
	public Node(Character ch, Integer freq) {
		this.character = ch;
		this.frequency = freq;
	}
}
