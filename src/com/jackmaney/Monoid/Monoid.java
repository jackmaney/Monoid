package com.jackmaney.Monoid;

import com.jackmaney.Monoid.Element.MonoidElement;
import com.jackmaney.Monoid.Strategy.ElasticityStrategy;
import com.jackmaney.Monoid.Strategy.FindAllFactorsStrategy;
import com.jackmaney.Monoid.Strategy.FindFactorizationsStrategy;
import com.jackmaney.Monoid.Strategy.FindIrreducibleFactorsStrategy;

public interface Monoid<T extends MonoidElement<T>> {
	public T identity();
	
	
	public FindAllFactorsStrategy<T> getFindAllFactorsStrategy();
	public FindIrreducibleFactorsStrategy<T> getFindIrreducibleFactorsStrategy();
	public FindFactorizationsStrategy<T> getFindFactorizationStrategy();
	public ElasticityStrategy<T> getElasticityStrategy();

}
