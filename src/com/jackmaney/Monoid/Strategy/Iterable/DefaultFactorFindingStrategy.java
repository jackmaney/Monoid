package com.jackmaney.Monoid.Strategy.Iterable;

import java.util.ArrayList;
import java.util.Iterator;

import com.jackmaney.Monoid.IterableMonoid;
import com.jackmaney.Monoid.Monoid;
import com.jackmaney.Monoid.Element.ComparableMonoidElement;
import com.jackmaney.Monoid.Strategy.Iterable.IterableFindAllFactorsStrategy;

public class DefaultFactorFindingStrategy<T extends ComparableMonoidElement<T>> 
	implements IterableFindAllFactorsStrategy<T>{

	@Override
	public ArrayList<T> find(T element, IterableMonoid<T> m) {
		
		ArrayList<T> result = new ArrayList<>();
		
		Iterator<T> it = m.intervalIterator(m.identity(), element);
		
		while(it.hasNext()){
			
			T potentialDivisor = it.next();
			
			if(potentialDivisor.divides(element) != null){
				result.add(potentialDivisor);
			}
			
		}
		
		
		return result;
	}

	/**
	 * No-op for non-iterative monoids.
	 */
	@Override
	public ArrayList<T> find(T element, Monoid<T> m) {
		//No-op for non-iterative monoids
		return null;
	}

}
