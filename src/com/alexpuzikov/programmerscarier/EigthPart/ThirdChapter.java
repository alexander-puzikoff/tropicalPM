package com.alexpuzikov.programmerscarier.EigthPart;

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

	public static void main(String[] args) {
		ThirdChapter tc = new ThirdChapter();
		tc.task3dot3();
	}
}
