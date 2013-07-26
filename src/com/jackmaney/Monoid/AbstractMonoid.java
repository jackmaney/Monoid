package com.jackmaney.Monoid;

import java.util.ArrayList;

import com.jackmaney.Monoid.Element.MonoidElement;
import com.jackmaney.Monoid.Factorization.Factorization;
import com.jackmaney.Monoid.Strategy.ElasticityStrategy;
import com.jackmaney.Monoid.Strategy.Elasticity.DefaultElasticityStrategy;

public abstract class AbstractMonoid<T extends MonoidElement<T>>
	implements Monoid<T>{
	
	

	public double getElasticity(T element){
		return getElasticityStrategy().find(element, this);
	}
	
	public ArrayList<T> getAllFactors(T element){
		return getFindAllFactorsStrategy().find(element, this);
	}
	
	public ArrayList<T> getAllIrreducibleFactors(T element){
		return getFindIrreducibleFactorsStrategy().find(element, this);
	}
	
	public ArrayList<Factorization<T>> getAllIrreducibleFactorizations(T element){
		return getFindFactorizationStrategy().find(element, this);
	}
	
	/* (non-Javadoc)
	 * @see com.jackmaney.Monoid.Monoid#getElasticityStrategy()
	 */
	@Override
	public ElasticityStrategy<T> getElasticityStrategy() {
		return new DefaultElasticityStrategy<>();
	}

}
