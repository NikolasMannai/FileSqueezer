package huffmanPriok;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOfQueue {
	/**
	 * test variabler.
	 */
	private final int testValue = 0;
	/**
	 * skappar en priority queue.
	 */
	private PriorityQueueMain<Integer> test;
	/**
	 * test variabler.
	 */
	private final int testValue1 = 2;
	/**
	 * test variabler.
	 */
	private final int testValue2 = 1;
	/**
	 * skapar en teststorlek som används i testet.
	 */
	private final int testSize =2;
	/**
	 * slappar objekt av klassen PriorityQueueMain.
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		test = new PriorityQueueMain<Integer>();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	/**
	 * testar att den är tom.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(test.isEmpty());
	}
	/**
	 * testar om den är full.
	 */
	@Test
	void testIsFull() {
		assertFalse(test.isFull());
	}
	/**
	 * testar att ta bort ett elemet på en tom kö.
	 */
	@Test
	void testDequeueOnEmpty() {
		assertThrows(EmptyQueueExeption.class,() -> test.dequeue(), "den är tom");
	}
	/**
	 * testar att töma en tom kö.
	 */
	@Test
	void testOfClearOnEmptyQueue() {
		test.clear();
		assertTrue(test.isEmpty());
	}
	/**
	 * testar att ta bort från listan som är populerad.
	 */
	@Test
	void testOfDeQueueOnPopulatedQueue() {
		test.enqueue(testValue1);
		test.dequeue();
		assertTrue(test.isEmpty());
	}
	/**
	 * testar att lägga till saker i listan.
	 */
	@Test
	void testOfEnqueue() {
		test.enqueue(testValue2);
		test.enqueue(testValue1);
		assertEquals(testValue2, test.getFront());
	}
	/**
	 * testar om man kan se det första på listan.
	 */
	@Test
	void testOfGetFist() {
		test.enqueue(testValue1);
		assertEquals(testValue1, test.getFront());
	}
	/**
	 * testar att titta på det första elementet på listan som är tom.
	 */
	@Test
	void testOfgetFrontOnEmptyQueue() {
		assertThrows(EmptyQueueExeption.class, () -> test.getFront(),"den är tom");
	}
	/**
	 * testar att skriva ut listan.
	 */
	@Test
	void testOFPrint() {
		test.enqueue(testValue1);
		test.enqueue(testValue2);
		test.printInorder();
	}
	/**
	 * testar om man kan få storleken.
	 */
	@Test
	void testSize() {
		test.enqueue(testValue1);
		test.enqueue(testValue2);
		assertEquals(testSize,test.size());
	}
	/**
	 * testar att den är tom och har storlek 0.
	 */
	@Test
	void testSizeIfEmpty() {
		assertEquals(0, test.size());
	}
}