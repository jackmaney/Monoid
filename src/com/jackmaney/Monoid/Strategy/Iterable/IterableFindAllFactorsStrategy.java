package com.jackmaney.Monoid.Strategy.Iterable;

import java.util.ArrayList;

import com.jackmaney.Monoid.IterableMonoid;
import com.jackmaney.Monoid.Element.ComparableMonoidElement;
import com.jackmaney.Monoid.Strategy.FindAllFactorsStrategy;

public interface IterableFindAllFactorsStrategy<T extends ComparableMonoidElement<T>> 
	extends FindAllFactorsStrategy<T>{
	
	public ArrayList<T> find(T element,IterableMonoid<T> m);
}
