package com.alexpuzikov.programmerscarier.EigthPart;

import java.util.LinkedList;
import java.util.List;

import common.Node;

public class SecondChapter{

	/**
	 * (7 -> 1-> 6) + (5 -> 9 -> 2) = (2 -> 1 -> 9)
	 * 
	 * @param firstHead
	 * @param secondHead
	 * @return
	 */

	public static Node<Integer> taskTwoDotFive(Node<Integer> firstHead,
			Node<Integer> secondHead) {
		if (firstHead == null) {
			return secondHead;
		}
		if (secondHead == null) {
			return firstHead;
		}
		Node<Integer> checksF = firstHead;
		Node<Integer> checksS = secondHead;
		Node<Integer> result = new Node<Integer>(0);
		boolean stop = false;
		int remains = 0;
		Node<Integer> next = result;
		while (!stop) {
			int a = 0, b = 0;
			boolean ab = false, bb = false;
			if (checksF != null) {
				a = checksF.getValue();
				checksF = checksF.getNextNode();
				ab = true;
			}
			if (checksS != null) {
				b = checksS.getValue();
				checksS = checksS.getNextNode();
				bb = true;
			}
			if (!ab && !bb) {
				next.getPreviousNode().setNextNode(null);
				next = null;

				break;
			}

			int sum = a + b;
			if (sum >= 10) {
				sum = sum - 10;
				next.setValue(remains + sum);
				remains = 1;
			} else {
				next.setValue(remains + sum);
				remains = 0;
			}
			Node<Integer> nextnode = new Node<Integer>(0);
			next.setNextNode(nextnode);
			nextnode.setPreviousNode(next);
			next = nextnode;
		}
		return result;
	}

	/**
	 * (6 -> 1-> 7) + (2 -> 9 -> 5) = (9 -> 1 -> 2)
	 * 
	 * @param firstHead
	 * @param secondHead
	 * @return
	 */

	public Node<Integer> invertTaskTwoDotFive(Node<Integer> firstHead,
			Node<Integer> secondHead) {
		return invertNodeArray(taskTwoDotFive(invertNodeArray(firstHead),
				invertNodeArray(secondHead)));
	}

	/**
	 * (6 -> 1-> 7) = (7 -> 1 -> 6)
	 * 
	 * @param head
	 * @return
	 */

	public Node invertNodeArray(Node head) {
		Node next = head;
		Node prev = null;
		while (next.getNextNode() != null) {
			Node thisNode = next.getNextNode();
			next.setNextNode(prev);
			prev = next;
			next = thisNode;
		}
		next.setNextNode(prev);
		return next;
	}

	/**
	 * Example A->B->C->D->E->C
	 * 
	 * @param startNode
	 *            A
	 * @return C
	 */
	public Node task2dot6(Node startNode) {
		List<Node> l = new LinkedList<Node>();
		Node next = startNode;
		Node returnNode = null;
		while (next.getNextNode() != null) {
			if (l.contains(next)) {
				returnNode = next;
				break;
			} else {
				l.add(next);
			}
			next = next.getNextNode();
		}
		if (l.contains(next)) { // last node
			returnNode = next;
		} else {
			l.add(next);
		}
		return returnNode;
	}

	/**
	 * find polindrom
	 * 
	 * @param head
	 * @return
	 */
	public boolean task2dot7(Node head) {
		List<Node> l = new LinkedList<Node>();
		Node next = head;
		if(next == null){
			return true;
		}
		while (next.getNextNode() != null) {
			l.add(next);

			next = next.getNextNode();
		}
		l.add(next);
		if (l.size() <= 1) {
			return true;
		}
		boolean even = true;
		if (l.size() % 2 == 0) { // even
			for (int i = 0; i <= l.size() / 2; i++) {
				if (!l.get(i).equals(l.get(l.size() - i-1))) {
					even = false;
				}
			}
		} else { // not even
			for (int i = 0; i < l.size() / 2; i++) {
				if (!l.get(i).equals(l.get(l.size() - i-1))) {
					even = false;
				}
			}
		}
		return even;
	}

	public static void main(String[] args) {
		System.out.println(9 / 2);
	}
}
