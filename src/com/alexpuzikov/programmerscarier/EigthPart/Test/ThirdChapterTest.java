package com.alexpuzikov.programmerscarier.EigthPart.Test;

import org.junit.Test;

import common.MStack;

import static org.junit.Assert.*;

public class ThirdChapterTest {

	@Test
	public void testMStack() {
		MStack<Integer> ms = new MStack<Integer>();
		ms.push(1);
		ms.push(7);
		ms.push(2);
		ms.push(3);
		assertEquals(1.0, ms.min().doubleValue(), 0.02);

	}
}
