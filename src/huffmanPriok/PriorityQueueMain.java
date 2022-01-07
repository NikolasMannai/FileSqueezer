package huffmanPriok;

/**
 * @author Nikolas Mannai, Oliver Jonsson
 * @param <T>
 */
public class PriorityQueueMain<T extends Comparable<? super T>> implements PriorityQueue<T> {
	/**
	 * detta är den mittersta gränsen.
	 */
	private static final int EQUAL = 0;
	/**
	 * detta är den största gränsen.
	 */
	private static final int GRATER = 1;
	/**
	 * detta är den mista gränsen.
	 */
	private static final int MINOR = -1;

	/**
	 * inre klass som är noderna i trädet.
	 * 
	 * @author oliver
	 * @param <T>
	 */
	public class TreeNode<T extends Comparable<? super T>> {
		/**
		 * detta är den vänstra noden.
		 */
		private TreeNode<T> leftChildeNode;
		/**
		 * detta är den högra noden.
		 */
		private TreeNode<T> rightChildNode;
		/**
		 * datat sparas i denna.
		 */
		private T data;

		/**
		 * trädnodens konstruktor.
		 * 
		 * @param leftChild
		 * @param data
		 * @param rightChild
		 */
		public TreeNode(final TreeNode<T> leftChild, final T data, final TreeNode<T> rightChild) {
			this.leftChildeNode = leftChild;
			this.rightChildNode = rightChild;
			this.data = data;
		}

		/**
		 * 
		 * @param data
		 */
		public TreeNode(final T data) {
			this.leftChildeNode = null;
			this.data = data;
			this.rightChildNode = null;
		}

		/**
		 * denna metod sätter vänsta noden.
		 * 
		 * @param leftChild
		 */
		public void setLeftChild(final TreeNode<T> leftChild) {
			this.leftChildeNode = leftChild;
		}

		/**
		 * denna metod sätter den högra noden.
		 * 
		 * @param rightChild
		 */
		public void setRightChild(final TreeNode<T> rightChild) {
			this.rightChildNode = rightChild;
		}

		/**
		 * denna metod hämtar vänstra noden.
		 * 
		 * @return vänstra noden.
		 */
		public TreeNode<T> getLeftChild() {
			return this.leftChildeNode;
		}

		/**
		 * denna metod hämtar den högra noden.
		 * 
		 * @return högra noden.
		 */
		public TreeNode<T> getRightCild() {
			return this.rightChildNode;
		}

		/**
		 * hämtar all data.
		 * 
		 * @return ger all data.
		 */
		public T getData() {
			return this.data;
		}

		/**
		 * tittar om den har den vänstra noden.
		 * 
		 * @return true
		 */
		public boolean hasLeftChild() {
			return leftChildeNode != null;
		}
	}

	/**
	 * tittar om värdet är störe eller mindre än de satta konstanterna.
	 * 
	 * @param element
	 * @param tree
	 * @return tree
	 */
	private TreeNode<T> inversR(final T element, final TreeNode<T> tree) {
		if (tree == null) {
			return new TreeNode<T>(null, element, null);
		} else {
			if (tree.data.compareTo(element) == GRATER || element.compareTo(tree.data) == EQUAL) {
				tree.setLeftChild(inversR(element, tree.getLeftChild()));
			} else if (tree.data.compareTo(element) == MINOR) {
				tree.setRightChild(inversR(element, tree.getRightCild()));
			}
		}
		return tree;
	}

	/**
	 * skappar en rootNode med ett generiskt värde.
	 */
	private TreeNode<T> rootNode;

	/**
	 * titta om den är kön är full.
	 * 
	 * @return false om den inte är full.
	 */
	public boolean isFull() {
		return !(rootNode == null);
	}

	/**
	 * tömmer rootNode på alla element.
	 */
	@Override
	public void clear() {
		rootNode = null;
	}

	/**
	 * tittar om den är tom.
	 * 
	 * @return true om tom.
	 */
	@Override
	public boolean isEmpty() {
		return (rootNode == null);
	}

	/**
	 * ger storleken.
	 * 
	 * @return strolek.
	 */
	@Override
	public int size() {
		return size(rootNode);
	}

	/**
	 * privat hjälp metod för att få fram storleken.
	 * 
	 * @param root
	 * @return storlek.
	 */
	private int size(final TreeNode<T> root) {
		if (root == null) {
			return 0;
		}
		return 1 + size(root.getLeftChild()) + size(root.getRightCild());
	}

	/**
	 * lägger till ett element i kön.
	 */
	@Override
	public void enqueue(final T t) {
		rootNode = inversR(t, rootNode);
	}

	/**
	 * tar bort ett ett element från kön.
	 */
	@Override
	public T dequeue() {
		if (rootNode == null) {
			throw new EmptyQueueExeption("den är tom");
		} else if (rootNode.leftChildeNode != null) {
			return removeFirst(rootNode);
		} else {
			TreeNode<T> minNode = rootNode;
			rootNode = rootNode.rightChildNode;
			minNode.rightChildNode = null;
			return minNode.data;
		}
	}

	/**
	 * privat hjälpmetod för att ta bort element.
	 * 
	 * @param node
	 * @return
	 */
	private T removeFirst(final TreeNode<T> node) {
		if (node.leftChildeNode.leftChildeNode == null) {
			TreeNode<T> minNode = node.leftChildeNode;
			node.leftChildeNode = node.leftChildeNode.rightChildNode;
			minNode.rightChildNode = null;
			return minNode.data;
		} else {
			return removeFirst(node.leftChildeNode);
		}
	}

	/**
	 * ger det första värdet i kön.
	 */
	@Override
	public T getFront() {
		if (rootNode == null) {
			throw new EmptyQueueExeption("den är tom");
		} else {
			return findPValue();
		}
	}

	/**
	 * privat hjälp metod för att hitta värdet.
	 * 
	 * @return första värdet i kön.
	 */
	private T findPValue() {
		TreeNode<T> current = rootNode;
		while (current.hasLeftChild()) {
			current = current.getLeftChild();
		}
		return current.getData();
	}

	/**
	 * skriver ut värdena i ordning.
	 * 
	 * @param node
	 */
	private void printInOrder(final TreeNode<T> node) {
		if (node != null) {
			printInOrder(node.leftChildeNode);
			System.out.print(node.data + " ");
			printInOrder(node.rightChildNode);
		}
	}


	/**
	 * kallar på printInorder() och skriver ut värderna.
	 */
	public void printInorder() {
		printInOrder(rootNode);
	}
}