package common;

public class Node<T> implements Comparable {
	private Node next = null;
	private Node previous = null;
	private T value;

	public T getValue() {
		return value;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getValue());
		Node next = this;
		while (next.getNextNode() != null) {
			sb.append("->");
			next = next.getNextNode();
			sb.append(next.getValue());
		}
		return sb.toString();
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node(T value) {
		this.value = value;
	}

	public boolean hasNext() {
		if (next == null)
			return false;
		return true;
	}

	public Node setNextNode(Node next) {
		this.next = next;
		if (next != null)
			next.setPreviousNode(this);
		return next;
	}

	public Node getNextNode() {
		return this.next;

	}

	public void setPreviousNode(Node previous) {
		this.previous = previous;
	}

	public Node getPreviousNode() {
		return this.previous;

	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node)) {
			return false;
		}
		Node comp = (Node) obj;
		if (comp.getValue() == null) {
			return false;
		}
		if (comp.getValue().equals(this.getValue())) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Object obj) {
		if (!(obj instanceof Node)) {
			throw new IllegalArgumentException();
		}
		Node comp = (Node) obj;
		if (comp.getValue() == null) {
			return Short.MIN_VALUE;
		}
		if (comp.getValue().equals(this.getValue())) {
			return 0;
		}

		return -10;
	}
}
