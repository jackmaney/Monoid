package com.jackmaney.Monoid.Strategy.Elasticity;

import com.jackmaney.Monoid.Monoid;
import com.jackmaney.Monoid.Element.MonoidElement;
import com.jackmaney.Monoid.Strategy.ElasticityStrategy;

public class UFMElasticityStrategy<T extends MonoidElement<T>> 
	implements ElasticityStrategy<T>{

	@Override
	public double find(T element, Monoid<T> m) {
		return element.equals(m.identity()) ? 0 : 1;
	}

}
