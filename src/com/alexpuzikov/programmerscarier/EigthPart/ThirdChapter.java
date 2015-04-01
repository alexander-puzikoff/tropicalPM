package com.alexpuzikov.programmerscarier.EigthPart;

import common.MStack;

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

	public static void main(String[] args) {
		ThirdChapter tc = new ThirdChapter();
		tc.task3dot2();
	}
}
