package com.jackmaney.Monoid.Strategy;

import java.util.ArrayList;

import com.jackmaney.Monoid.Monoid;
import com.jackmaney.Monoid.Element.MonoidElement;

public interface FindIrreducibleFactorsStrategy<T extends MonoidElement<T>> {
	
	public ArrayList<T> find(T element,Monoid<T> m);
}
