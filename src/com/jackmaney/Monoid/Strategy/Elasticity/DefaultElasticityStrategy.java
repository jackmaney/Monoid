package com.jackmaney.Monoid.Strategy.Elasticity;

import java.util.ArrayList;

import com.jackmaney.Monoid.Monoid;
import com.jackmaney.Monoid.Element.MonoidElement;
import com.jackmaney.Monoid.Factorization.Factorization;
import com.jackmaney.Monoid.Strategy.ElasticityStrategy;

public class DefaultElasticityStrategy<T extends MonoidElement<T>> 
implements ElasticityStrategy<T> {

	@Override
	public double find(T element, Monoid<T> m) {
		
		double result = 0;
		
		if(!element.equals(m.identity())){
			
			ArrayList<Factorization<T>> factorizations = m.getFindFactorizationStrategy().find(element, m);
			
			int minLength = 0;
			int maxLength = 0;
			
			for (Factorization<T> factorization : factorizations) {
				int length = factorization.length();
				
				if(minLength == 0 || length < minLength){
					minLength = length;
				}
				
				if(length > maxLength){
					maxLength = length;
				}
			}
			
			result = (double)maxLength / (double)minLength;
		}
		
		return result;
	}

}
