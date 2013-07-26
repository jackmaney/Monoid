package com.jackmaney.Monoid.Strategy;

import com.jackmaney.Monoid.Monoid;
import com.jackmaney.Monoid.Element.MonoidElement;

public interface ElasticityStrategy<T extends MonoidElement<T>> {
	public double find(T element,Monoid<T> m);
}
