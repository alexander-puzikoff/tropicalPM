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

	/**
	 * hanoi tower
	 * 
	 * @param n
	 *            - number of disks
	 */
	void task3dot4(int n) {
		Stack[] sticks = { new Stack<Integer>(), new Stack<Integer>(),
				new Stack<Integer>() };
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			sticks[r.nextInt(3)].push(r.nextInt(100));
		}
		System.out.println(Arrays.toString(sticks));
		while (true) {
			Integer a = null, b = null, c = null;
			int aS = 0, bS, cS = 0;
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
			boolean stop = true;

			if (a < b && b < c) {
				sticks[2].push(sticks[1].pop());
				stop = false;
				System.out.println(Arrays.toString(sticks));
				sticks[2].push(sticks[0].pop());
			} else if (a < c && c < b) {
				sticks[1].push(sticks[2].pop());
				stop = false;
				System.out.println(Arrays.toString(sticks));
				sticks[1].push(sticks[0].pop());
			} else if (b < a && a < c) {
				sticks[2].push(sticks[0].pop());
				stop = false;
				System.out.println(Arrays.toString(sticks));
				sticks[2].push(sticks[1].pop());
			} else if (b < c && c < a) {
				sticks[0].push(sticks[2].pop());
				stop = false;
				System.out.println(Arrays.toString(sticks));
				sticks[0].push(sticks[1].pop());
			} else if (c < b && b < a) {
				sticks[0].push(sticks[1].pop());
				stop = false;
				System.out.println(Arrays.toString(sticks));
				sticks[0].push(sticks[2].pop());
			} else if (c < a && a < b) {
				sticks[1].push(sticks[0].pop());
				stop = false;
				System.out.println(Arrays.toString(sticks));
				sticks[1].push(sticks[2].pop());
			}
			System.out.println(Arrays.toString(sticks));
			System.out.println("-");
			if (stop) {
				break;
			}
		}
		System.out.println(Arrays.toString(sticks));
	}

	public static void main(String[] args) {
		ThirdChapter tc = new ThirdChapter();
		tc.task3dot4(9);
	}
}
