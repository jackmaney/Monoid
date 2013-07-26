package com.jackmaney.Monoid;

import java.util.Iterator;

import com.jackmaney.Monoid.Element.ComparableMonoidElement;
import com.jackmaney.Monoid.Strategy.Iterable.IterableFindAllFactorsStrategy;

public interface IterableMonoid<T extends ComparableMonoidElement<T>> extends Monoid<T> {

	public Iterator<T> intervalIterator(T min,T max);
	
	public IterableFindAllFactorsStrategy<T> getIterableFindAllFactorsStrategy();
}
