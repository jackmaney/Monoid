package com.jackmaney.Monoid.Strategy;

import java.util.ArrayList;

import com.jackmaney.Monoid.Monoid;
import com.jackmaney.Monoid.Element.MonoidElement;
import com.jackmaney.Monoid.Factorization.Factorization;

public interface FindFactorizationsStrategy<T extends MonoidElement<T>> {
	
	public ArrayList<Factorization<T>> find(T element,Monoid<T> m);
	
}
