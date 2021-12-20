package huffman;

import java.util.HashMap;
import java.util.Map;

import huffmanPriok.PriorityQueueMain;


public class Huffman <T extends Comparable<? super T>>{
	private Node root;
	private String text;
	private Map<Character, Integer> charFrequencies;
	private Map<Character, String> huffmanCode;
	
 	public Huffman(String text)  {
 		this.text = text;
 		fillCharFrequencies();
 		huffmanCode = new HashMap<>(); 
 	}
 	
 	private void fillCharFrequencies() {
 		charFrequencies = new HashMap<>();
 		for(char character : text.toCharArray()) {
 			Integer integer = charFrequencies.get(character);
 			charFrequencies.put(character, integer != null ? integer+1 : 1);
 		}
 	}
 	
 	public String encode() {
 		PriorityQueueMain<Node> queue = new PriorityQueueMain<>(); 
 		charFrequencies.forEach((character, frequency) -> queue.enqueue(new Leaf(character, frequency)));
 		
 		while (queue.size() > 1) {
 			queue.enqueue(new InternalNode(queue.dequeue(), queue.dequeue()));
 		}
 		generateHuffmanCode(root = queue.dequeue(), "");
 		return getEncodedText();
 	}
 	
 	private String getEncodedText() {
 		StringBuilder sb = new StringBuilder();
 		for (char character : text.toCharArray()) {
 			sb.append(huffmanCode.get(character));
 		}
 		return sb.toString();
 	}
 	
 	private void generateHuffmanCode(Node node, String code) {
 		if(node instanceof Leaf) {
 			huffmanCode.put(((Leaf) node).getChar(), code);
 			return;
 		}
 		generateHuffmanCode(((InternalNode) node).getLeftChild(), code.concat("0"));
 		generateHuffmanCode(((InternalNode) node).getRightChild(), code.concat("1"));
 	}
 	
 	public String decode(String encodedText) {
 		StringBuilder sb = new StringBuilder();
 		Node current = root;
 		for(char character : encodedText.toCharArray()) {
 			current = character == '0' ? ((InternalNode) current).getLeftChild() : ((InternalNode) current).getRightChild();
 			if (current instanceof Leaf) {
 				sb.append(((Leaf) current).getChar());
 				current = root;
 			}
 		}
 		return sb.toString();
 	}
 	
 	public void printHuffmanCode() {
 		huffmanCode.forEach((character, code) -> System.out.print(character + " - " + code));
 	}
}
