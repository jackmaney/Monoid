package com.jackmaney.Monoid.NaturalNumbers;

import java.util.ArrayList;
import java.util.Iterator;

import com.jackmaney.Monoid.Element.NaturalNumber;
import com.jackmaney.Monoid.Factorization.Factorization;
import com.jackmaney.Monoid.Factorization.Power;
import com.jackmaney.Monoid.Iterator.NaturalNumberIterator;
import com.jackmaney.Monoid.Strategy.ElasticityStrategy;
import com.jackmaney.Monoid.Strategy.FindAllFactorsStrategy;
import com.jackmaney.Monoid.Strategy.FindFactorizationsStrategy;
import com.jackmaney.Monoid.Strategy.FindIrreducibleFactorsStrategy;
import com.jackmaney.Monoid.Strategy.Elasticity.UFMElasticityStrategy;
import com.jackmaney.Monoid.Strategy.Iterable.DefaultFactorFindingStrategy;
import com.jackmaney.Monoid.Strategy.Iterable.IterableFindAllFactorsStrategy;

public abstract class AbstractSubMonoidOfNaturalNumbers<T extends NaturalNumber> 
	implements SubmonoidOfNaturalNumbers<T>{


	private static final long serialVersionUID = -683826020917202021L;

	/* (non-Javadoc)
	 * @see com.jackmaney.Monoid.Monoid#identity()
	 */
	@Override
	public NaturalNumber identity() {
		return one;
	}
	
	@Override
	public Factorization<NaturalNumber> primeFactorization(NaturalNumber n){
		
		Factorization<NaturalNumber> result = null;
		
		if(!n.equals(identity())){
			int value = n.intValue();
			ArrayList<Integer> primeList = new ArrayList<>();
			
			while(value > 1){
				int prime = peelOffPrime(value);
				primeList.add(prime);
				value /= prime;
			}
			
			ArrayList<Power<NaturalNumber>> powers = new ArrayList<>();
			
			for(int i = 0; i < primeList.size(); i++){
				powers.add(new Power<NaturalNumber>(new NaturalNumber(primeList.get(i)),this));
			}
			
			result = new Factorization<NaturalNumber>(powers,this);
		}
		
		
		return result;
	}
	
	private int peelOffPrime(int n){
		
		if(n <= 1){
			throw new IllegalArgumentException();
		}
		
		
		if(n == 2 || n == 3){
			return n;
		}
		else{
			for(int i = 2; i <= Math.ceil(Math.sqrt(n)); i++){
				if(n % i == 0){
					return i;
				}
			}
		}
		
		return n;
		
	}

	


	/* (non-Javadoc)
	 * @see com.jackmaney.Monoid.IterableMonoid#getIterableFindAllFactorsStrategy()
	 */
	@Override
	public IterableFindAllFactorsStrategy<NaturalNumber> getIterableFindAllFactorsStrategy() {
		return new DefaultFactorFindingStrategy<NaturalNumber>();
	}


	/* (non-Javadoc)
	 * @see com.jackmaney.Monoid.Monoid#getFindAllFactorsStrategy()
	 */
	@Override
	public FindAllFactorsStrategy<NaturalNumber> getFindAllFactorsStrategy() {
		return getIterableFindAllFactorsStrategy();
	}


	/* (non-Javadoc)
	 * @see com.jackmaney.Monoid.Monoid#getFindIrreducibleFactorsStrategy()
	 */
	@Override
	public FindIrreducibleFactorsStrategy<NaturalNumber> getFindIrreducibleFactorsStrategy() {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see com.jackmaney.Monoid.Monoid#getFindFactorizationStrategy()
	 */
	@Override
	public FindFactorizationsStrategy<NaturalNumber> getFindFactorizationStrategy() {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see com.jackmaney.Monoid.Monoid#getElasticityStrategy()
	 */
	@Override
	public ElasticityStrategy<NaturalNumber> getElasticityStrategy() {
		return new UFMElasticityStrategy<>();
	}
	
	
	@Override
	public Iterator<NaturalNumber> intervalIterator(NaturalNumber min,
			NaturalNumber max) {
		return new NaturalNumberIterator(min, max);
	}
	
}
