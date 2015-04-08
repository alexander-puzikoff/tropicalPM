package com.alexpuzikov.programmerscarier.EigthPart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

import common.MStack;
import common.StackOfMStacks;

public class ThirdChapter {

	void task3dot2() {
		MStack<Integer> mStack = new MStack<Integer>();
		mStack.push(1);
		mStack.push(-1);
		mStack.push(1);
		mStack.push(-10);
		mStack.push(12);
		mStack.push(-112);
		mStack.push(13);
		System.out.println(mStack.size());
		System.out.println(mStack.min());

	}

	void task3dot3() {
		StackOfMStacks<Integer> st = new StackOfMStacks<Integer>(3);
		st.push(15);
		st.push(-61);
		st.push(18);
		st.push(-100);
		st.push(102);
		st.push(-4112);
		st.push(103);
		st.push(19);
		st.push(-16);
		st.push(1);
		st.push(-120);
		st.push(124);
		st.push(-1412);
		st.push(13);
		System.out.println(st.size());
		System.out.println(st);
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		st.push(1103);
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
	}

	int getAccurateSizeTower(Stack<Integer> st) {
		int as = 1;
		for (int i = st.size() - 1; i > 0; i--) {
			if (st.elementAt(i) <= st.elementAt(i - 1)) {
				as++;
			} else {
				break;
			}
		}
		return as;
	}

	int getMinLength(Stack[] st) {
		int minVal = Integer.MAX_VALUE;
		int pos = -1;
		for (int i = 0; i < st.length; i++) {

			if (minVal > st[i].size()) {
				minVal = st[i].size();
				pos = i;
			}
		}
		return pos;
	}

	int[] getMaxPos(Stack[] st) {
		int pos[] = { -1, -1 };
		int maxVal = Integer.MIN_VALUE;
		for (int i = 0; i < st.length; i++) {
			for (int j = 0; j < st[i].size(); j++) {
				if (maxVal < (Integer) st[i].elementAt(j)) {
					maxVal = (Integer) st[i].elementAt(j);
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		return pos;
	}

	void task3dot4(int n) {
		Stack[] sticks = { new Stack<Integer>(), new Stack<Integer>(),
				new Stack<Integer>() };
		// filling values
		for (int i = 0; i < n; i++) {
			sticks[0].add(n * n - i * n / 2);
		}
		System.out.println(Arrays.toString(sticks));

		int toppos = 0;
		boolean forward = true, doTop = true;
		while (!sticks[0].isEmpty() || !sticks[1].isEmpty()) {

			Integer a = null, b = null, c = null; // current value
			int[] peek = { 0, 0, 0 }; //

			if (sticks[0].isEmpty()) {
				peek[0] = Integer.MAX_VALUE;
			} else {
				peek[0] = (Integer) sticks[0].peek();
			}
			if (sticks[1].isEmpty()) {
				peek[1] = Integer.MAX_VALUE;
			} else {
				peek[1] = (Integer) sticks[1].peek();
			}

			if (sticks[2].isEmpty()) {
				peek[2] = Integer.MAX_VALUE;
			} else {
				peek[2] = (Integer) sticks[2].peek();
			}
			if (forward) {
				if (doTop) {
					doTop = false;
					sticks[(toppos + 1) % 3].push(sticks[toppos % 3].pop());
					toppos++;
					if (toppos % 3 == 0) {
						forward = false;
					}
				} else {
					doTop = true;
					if (peek[(toppos + 1) % 3] < peek[(toppos + 2) % 3]) {
						sticks[(toppos + 2) % 3].push(sticks[(toppos + 1) % 3]
								.pop());
					} else {
						if (!sticks[(toppos + 2) % 3].isEmpty())
							sticks[(toppos + 1) % 3]
									.push(sticks[(toppos + 2) % 3].pop());
					}
				}
			} else {
				if (doTop) {
					doTop = false;
					sticks[(toppos - 1) % 3].push(sticks[toppos % 3].pop());
					toppos--;
					if (toppos % 3 == 0) {
						forward = true;
					}
				} else {
					doTop = true;
					if (peek[(toppos + 1) % 3] < peek[(toppos + 2) % 3]) {
						sticks[(toppos + 2) % 3].push(sticks[(toppos + 1) % 3]
								.pop());
					} else {
						if (!sticks[(toppos + 2) % 3].isEmpty())
							sticks[(toppos + 1) % 3]
									.push(sticks[(toppos + 2) % 3].pop());
					}
				}

			}
			System.out.println(Arrays.toString(sticks));

		}
		System.out.println(Arrays.toString(sticks));
	}

	/**
	 * hanoi tower for random disk position
	 * 
	 * @param n
	 *            - number of disks
	 */
	void task3dot4Beta(int n) {
		Stack[] sticks = { new Stack<Integer>(), new Stack<Integer>(),
				new Stack<Integer>() };
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			sticks[r.nextInt(3)].push(r.nextInt(100));
		}
		System.out.println(Arrays.toString(sticks));
		int[] maxValPos = getMaxPos(sticks);
		int minsizest = getMinLength(sticks);
		boolean stop = true;
		Integer a = null, b = null, c = null; // current value
		int aS = 0, bS = 0, cS = 0; //
		if (sticks[0].isEmpty()) {
			a = Integer.MAX_VALUE;
		} else {
			a = (Integer) sticks[0].peek();
			aS = getAccurateSizeTower(sticks[0]);
		}
		if (sticks[1].isEmpty()) {
			b = Integer.MAX_VALUE;
		} else {
			b = (Integer) sticks[1].peek();
			bS = getAccurateSizeTower(sticks[1]);
		}
		if (sticks[2].isEmpty()) {
			c = Integer.MAX_VALUE;
		} else {
			c = (Integer) sticks[2].peek();
			cS = getAccurateSizeTower(sticks[2]);
		}
		System.out.println(Arrays.toString(maxValPos));
		System.out.print(aS);
		System.out.print(" ");
		System.out.print(bS);
		System.out.print(" ");
		System.out.print(cS);
		System.out.print(" ");
		while (true) {
			if (maxValPos[1] == 0) {

			} else {

			}

			if (stop) {
				break;
			}
		}
		// while ( 1 == 0) {
		//
		// if (a < b && b < c) {
		// sticks[2].push(sticks[1].pop());
		// stop = false;
		// System.out.println(Arrays.toString(sticks));
		//
		// } else if (a < c && c < b) {
		// sticks[1].push(sticks[2].pop());
		// stop = false;
		// System.out.println(Arrays.toString(sticks));
		// sticks[1].push(sticks[0].pop());
		// } else if (b < a && a < c) {
		// sticks[2].push(sticks[0].pop());
		// stop = false;
		// System.out.println(Arrays.toString(sticks));
		// sticks[2].push(sticks[1].pop());
		// } else if (b < c && c < a) {
		// sticks[0].push(sticks[2].pop());
		// stop = false;
		// System.out.println(Arrays.toString(sticks));
		// sticks[0].push(sticks[1].pop());
		// } else if (c < b && b < a) {
		// sticks[0].push(sticks[1].pop());
		// stop = false;
		// System.out.println(Arrays.toString(sticks));
		// sticks[0].push(sticks[2].pop());
		// } else if (c < a && a < b) {
		// sticks[1].push(sticks[0].pop());
		// stop = false;
		// System.out.println(Arrays.toString(sticks));
		// sticks[1].push(sticks[2].pop());
		// }
		// System.out.println(Arrays.toString(sticks));
		// System.out.println("-");
		// if (stop) {
		// break;
		// }
		// }
		System.out.println(Arrays.toString(sticks));
	}

	/**
	 * create class MyQueue using two stacks
	 */
	void task3dot5() {
	}

	public static void main(String[] args) {
		ThirdChapter tc = new ThirdChapter();
		tc.task3dot4(6);
	}
}
