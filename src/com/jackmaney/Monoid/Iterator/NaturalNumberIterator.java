package com.jackmaney.Monoid.Iterator;

import java.util.Iterator;

import com.jackmaney.Monoid.Element.NaturalNumber;

public class NaturalNumberIterator implements Iterator<NaturalNumber>{
	
	private NaturalNumber min;
	private NaturalNumber max;
	private NaturalNumber current;
	
	private boolean pastMax = false;
	private boolean first = true;
	
	public NaturalNumberIterator(NaturalNumber min,NaturalNumber max){
		
		if(max.compareTo(min) < 0){
			throw new IllegalArgumentException();
		}
		
		this.min = min;
		this.max = max;
		
		this.current = new NaturalNumber(min.intValue());
		
	}
	
	public NaturalNumberIterator(int min,int max){
		this(new NaturalNumber(min),new NaturalNumber(max));
	}

	@Override
	public boolean hasNext() {
		return !pastMax;
	}

	@Override
	public NaturalNumber next() {
		
		if(first){
			first = false;
		}
		else{
			current = new NaturalNumber(current.intValue() + 1);
		}
		
		if(current.compareTo(max) > 0){
			pastMax = true;
		}
		
		return current;
	}

	@Override
	public void remove() {
		//No-op
	}
	
}
