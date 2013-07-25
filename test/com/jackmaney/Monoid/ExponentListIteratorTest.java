package com.jackmaney.Monoid;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

public class ExponentListIteratorTest {

	@Test
	public void test() {
		ArrayList<Integer> maxArr = new ArrayList<>(Arrays.asList(2,1,3));
		
		ExponentList max = new ExponentList(maxArr);
		
		ArrayList<ArrayList<Integer>> expected = new ArrayList<>();

		expected.add(new ArrayList<Integer>(Arrays.asList(0,0,1)));
		expected.add(new ArrayList<Integer>(Arrays.asList(0,0,2)));
		expected.add(new ArrayList<Integer>(Arrays.asList(0,0,3)));
		expected.add(new ArrayList<Integer>(Arrays.asList(0,1,0)));
		expected.add(new ArrayList<Integer>(Arrays.asList(0,1,1)));
		expected.add(new ArrayList<Integer>(Arrays.asList(0,1,2)));
		expected.add(new ArrayList<Integer>(Arrays.asList(0,1,3)));
		expected.add(new ArrayList<Integer>(Arrays.asList(1,0,0)));
		expected.add(new ArrayList<Integer>(Arrays.asList(1,0,1)));
		expected.add(new ArrayList<Integer>(Arrays.asList(1,0,2)));
		expected.add(new ArrayList<Integer>(Arrays.asList(1,0,3)));
		expected.add(new ArrayList<Integer>(Arrays.asList(1,1,0)));
		expected.add(new ArrayList<Integer>(Arrays.asList(1,1,1)));
		expected.add(new ArrayList<Integer>(Arrays.asList(1,1,2)));
		expected.add(new ArrayList<Integer>(Arrays.asList(1,1,3)));
		expected.add(new ArrayList<Integer>(Arrays.asList(2,0,0)));
		expected.add(new ArrayList<Integer>(Arrays.asList(2,0,1)));
		expected.add(new ArrayList<Integer>(Arrays.asList(2,0,2)));
		expected.add(new ArrayList<Integer>(Arrays.asList(2,0,3)));
		expected.add(new ArrayList<Integer>(Arrays.asList(2,1,0)));
		expected.add(new ArrayList<Integer>(Arrays.asList(2,1,1)));
		expected.add(new ArrayList<Integer>(Arrays.asList(2,1,2)));
		expected.add(new ArrayList<Integer>(Arrays.asList(2,1,3)));
		
		int counter = 0;
		
		Iterator<ExponentList> it = max.getIterator();
		
		while(it.hasNext()){
			
			ArrayList<Integer> a = expected.get(counter);
			ArrayList<Integer> b = it.next();
			
			assertTrue(a.equals(b));
			
			counter++;
		}
		
		assertTrue(counter == 23);
		
	}

}
