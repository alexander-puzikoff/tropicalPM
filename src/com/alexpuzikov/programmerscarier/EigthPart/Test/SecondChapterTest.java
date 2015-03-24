package com.alexpuzikov.programmerscarier.EigthPart.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import common.*;

import com.alexpuzikov.programmerscarier.EigthPart.SecondChapter;

public class SecondChapterTest {

	@Test
	public void testSummOfTwoArrays() {
		SecondChapter tester = new SecondChapter();
		Node expected = new Node<Integer>(2);
		expected.setNextNode(new Node<Integer>(1)).setNextNode(
				new Node<Integer>(9));
		Node<Integer> firstHead = new Node<Integer>(7);
		firstHead.setNextNode(new Node<Integer>(1)).setNextNode(
				new Node<Integer>(6));
		Node<Integer> secondHead = new Node<Integer>(5);
		secondHead.setNextNode(new Node<Integer>(9)).setNextNode(
				new Node<Integer>(2));

		assertEquals("617 + 295 = 912", expected.toString(), tester
				.taskTwoDotFive(firstHead, secondHead).toString());

	}

	@Test
	public void testInvertion() {
		SecondChapter tester = new SecondChapter();
		Node<Integer> expected = new Node<Integer>(2);
		expected.setNextNode(new Node<Integer>(1))
				.setNextNode(new Node<Integer>(9))
				.setNextNode(new Node<Integer>(9));
		Node<Integer> firstHead = new Node<Integer>(9);
		firstHead.setNextNode(new Node<Integer>(9))
				.setNextNode(new Node<Integer>(1))
				.setNextNode(new Node<Integer>(2));

		Node<Integer> firstHeadTwo = new Node<Integer>(9);
		firstHeadTwo.setNextNode(new Node<Integer>(4));

		Node<Integer> expectedTwo = new Node<Integer>(4);
		expectedTwo.setNextNode(new Node<Integer>(9));

		assertEquals("912 = 219", expected.toString(),
				tester.invertNodeArray(firstHead).toString());
		assertEquals("94 = 49", expectedTwo.toString(),
				tester.invertNodeArray(firstHeadTwo).toString());

	}

	@Test
	public void invertionSummOfTwoArrays() {
		SecondChapter tester = new SecondChapter();
		Node expected = new Node<Integer>(9);
		expected.setNextNode(new Node<Integer>(1)).setNextNode(
				new Node<Integer>(2));
		Node<Integer> firstHead = new Node<Integer>(6);
		firstHead.setNextNode(new Node<Integer>(1)).setNextNode(
				new Node<Integer>(7));
		Node<Integer> secondHead = new Node<Integer>(2);
		secondHead.setNextNode(new Node<Integer>(9)).setNextNode(
				new Node<Integer>(5));

		assertEquals("617 + 295 = 912", expected.toString(), tester
				.invertTaskTwoDotFive(firstHead, secondHead).toString());

	}

	@Test
	public void testTask2dot7() {
		SecondChapter tester = new SecondChapter();
		Node expected = new Node("C");
		Node expectedtwo = null;
		Node startNode = new Node("A");
		startNode.setNextNode(new Node("B")).setNextNode(new Node("C"))
				.setNextNode(new Node("D")).setNextNode(new Node("E"))
				.setNextNode(new Node("C"));
		Node startNodetwo = new Node("A");
		startNodetwo.setNextNode(new Node("B")).setNextNode(new Node("A"));
		Node startNodethree = new Node("A");
		startNodethree.setNextNode(new Node("B")).setNextNode(new Node("B"))
				.setNextNode(new Node("A"));
		assertEquals("C true", true, tester.task2dot7(expected));
		assertEquals("null true", true, tester.task2dot7(expectedtwo));
		assertEquals("false a->b->c->d->e->c", false,
				tester.task2dot7(startNode));
		assertEquals("true a->b->a", true, tester.task2dot7(startNodetwo));
		assertEquals("true a->b->b->a", true, tester.task2dot7(startNodethree));

	}

	@Test
	public void testTask2dot6() {
		SecondChapter tester = new SecondChapter();
		Node expected = new Node("C");

		Node startNode = new Node("A");
		startNode.setNextNode(new Node("B")).setNextNode(new Node("C"))
				.setNextNode(new Node("D")).setNextNode(new Node("E"))
				.setNextNode(new Node("C"));
		Node startNodeTWO = new Node("A");
		startNodeTWO.setNextNode(new Node("B")).setNextNode(new Node("C"))
				.setNextNode(new Node("D")).setNextNode(new Node("E"))
				.setNextNode(new Node("C")).setNextNode(new Node("F"));
		assertEquals("", expected.toString(), tester.task2dot6(startNode)
				.toString());
		Node result2 = tester.task2dot6(startNodeTWO);

		assertEquals("", true, expected.compareTo(result2) == 0);

	}
}
