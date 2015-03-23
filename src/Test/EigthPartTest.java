package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import common.*;

import com.alexpuzikov.programmerscarier.EigthPart;

public class EigthPartTest {

	@Test
	public void testSummOfTwoArrays() {
		EigthPart tester = new EigthPart();
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
		EigthPart tester = new EigthPart();
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
		EigthPart tester = new EigthPart();
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
	public void testTask2dot6() {
		EigthPart tester = new EigthPart();
		Node expected = new Node("C");

		Node startNode = new Node("A");
		startNode.setNextNode(new Node("B")).setNextNode(new Node("C"))
				.setNextNode(new Node("D")).setNextNode(new Node("E"))
				.setNextNode(new Node("C"));
		assertEquals("", expected.toString(), tester.task2dot6(startNode)
				.toString());

	}
}
