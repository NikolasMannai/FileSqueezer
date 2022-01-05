package huffmanPriok;

public interface PriorityQueue<T extends Comparable<? super T>> {
	/**
	 * retunear falskt true om den är full och denna funktion tittar om den ör full.
	 * 
	 * @return true om den är full.
	 */
	public boolean isFull();

	/**
	 * tömmer kön.
	 */
	public void clear();

	/**
	 * titar om kön är tom.
	 * 
	 * @return true om den är tom.
	 */
	public boolean isEmpty();

	/**
	 * retunerar dess storlek.
	 * 
	 * @return storlek.
	 */
	public int size();

	/**
	 * läger till ett element i kön.
	 * 
	 * @param t
	 */
	public void enqueue(T t);

	/**
	 * tar bort ett element i kön.
	 * 
	 * @throws exeption om den är tom.
	 * @return ger det första elementet.
	 */
	public T dequeue();

	/**
	 * retunerar det översta elementet.
	 * 
	 * @throws exeption om den är tom.
	 * @return
	 */
	public T getFront();
}
