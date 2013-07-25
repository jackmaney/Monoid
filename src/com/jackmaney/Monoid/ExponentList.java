package com.jackmaney.Monoid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ExponentList extends ArrayList<Integer>
	implements Comparable<ExponentList>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9137642269083277064L;

	public ExponentList(){
		super();
		validate();
	}
	
	public ExponentList(Collection<? extends Integer> c){
		super(c);
		validate();
	}
	
	public ExponentList(int initialCapacity){
		super(initialCapacity);
		validate();
	}
	
	
	private void validate(){
		for (Integer integer : this) {
			if(integer < 0){
				throw new IllegalArgumentException();
			}
		}
	}
	
	public int firstNonZeroIndex(){
		int result = -1;
		
		for(int i = 0; i < size(); i++){
			if(get(i) > 0){
				result = i;
				break;
			}
		}
		
		return result;
	}
	
	public void incrementAt(int index){
		if(index < 0 || index >= size()){
			throw new IllegalArgumentException();
		}
		
		set(index,get(index) + 1);
	}
	
	public void zeroOutToTheRightOf(int index){
		
		if(index < -1){
			throw new IllegalArgumentException();
		}
		
		for(int i = index + 1; i < size(); i++){
			set(i,0);
		}
	}
	
	@Override
	public Object clone() {
		
		ExponentList result = new ExponentList();
		
		for(int i = 0; i < size(); i++){
			result.add(get(i));
		}
		
		return result;
	}
	
	/*
	 * I can't give this method the usual name of iterator(), 
	 * since that creates compile-time conflicts with the fact
	 * that ExponentList extends ArrayList<Integer>, and
	 * ArrayList has its own iterator...
	 * 
	 * So, this is a bit of a hack.
	 */
	public Iterator<ExponentList> getIterator() {
		return new ExponentListIterator(this);
	}
	
	@Override
	public int compareTo(ExponentList o) {
		if(size() != o.size()){
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < size(); i++){
			int comp = get(i).compareTo(o.get(i));
			if(comp != 0){
				return comp;
			}
		}
		
		return 0;
	}

	
}
