package com.jackmaney.Monoid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ExponentListIterator implements Iterator<ExponentList>{

	private ExponentList max = null;
	private ExponentList current = null;
	private ExponentList zero = null;
	private boolean reachedMax = false;
	
	public ExponentListIterator(ExponentList e){
		
		this.max = e;
		
		ArrayList<Integer> z1 = new ArrayList<>();
		ArrayList<Integer> z2 = new ArrayList<>();
		
		for(int i = 0; i < e.size(); i++){
			z1.add(0);
			z2.add(0);
		}
		
		this.zero = new ExponentList(z1);
		this.current = new ExponentList(z2);
		
		if(max.equals(zero)){
			reachedMax = true;
		}
		
	}

	@Override
	public boolean hasNext() {
		return !reachedMax;
	}

	@Override
	public ExponentList next() {
		
		int index = current.firstNonZeroIndex();
		
		
		if(index == -1){
			current.incrementAt(current.size() - 1);
			
			//Very silly edge case...
			if(current.size() == 1 && max.get(0) == 1){
				reachedMax = true;
			}
		}
		else if(current.size() == 1){
			
			current.incrementAt(0);
			
			if(current.get(0) == max.get(0)){
				reachedMax = true;
			}
		}
		else{
			
			/*
			 * We traverse current from the right, trying to find
			 * the first place before index that has a non-maximal value
			 * (if such a place exists).
			 *
			 * Note that if index is all the way to the right, then 
			 * we still have rightIndex == -1
			 */
			
			int rightIndex = -1;
			
			for(int i = current.size() - 1; i > index; i--){
				if(current.get(i) < max.get(i)){
					rightIndex = i;
					break;
				}
			}
			
			/*
			 * If we found such a place after index to increment, then do so
			 * and zero out everything to the right of rightIndex.
			 */
			
			if(rightIndex > -1){
				
				current.incrementAt(rightIndex);
				current.zeroOutToTheRightOf(rightIndex);
				
			}
			else{
				
				/*
				 * Otherwise, everything to the right of index is maxed out.
				 * Can we increment at index? If so, do so and zero out
				 * everything to the right.
				 */
				
				if(current.get(index) < max.get(index)){
					
					current.incrementAt(index);
					current.zeroOutToTheRightOf(index);
					
				}
				else{
					
					/*
					 * If we can't increment at index, then can we move to the left?
					 * If so, put a 1 to the left and zero out to the right of
					 * index - 1.
					 */
					
					if(index > 0){
						current.set(index - 1,1);
						current.zeroOutToTheRightOf(index - 1);
					}
					else{
						/*
						 * At this point, if index == 0 and we can't 
						 * increment at index, then current.equals(max)
						 * and something very bad has happened...
						 */
						
						throw new NoSuchElementException();
					}
				}
			}
		}
		
		if(current.equals(max)){
			reachedMax = true;
		}
		
		return current;
	}

	@Override
	public void remove() {}
	
}

