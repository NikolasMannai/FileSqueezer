package huffman;

public interface PriorityQueueInterface<T> {
	/*
	 * Counts all symbols in priorityQueue
	 */
	public void countSymbols(T t);
	/*
	 * Removes a node
	 */
	public void removeNode();
	/*
	 * Adds a node
	 */
	public void addNode();
	/*
	 * Sets next Node
	 */
	public void setNode(T t);
	/*
	 * Gets next Node
	 */
	public T getNext();
	/*
	 * Counts all the nodes
	 */
	public T countNodes();
}
 