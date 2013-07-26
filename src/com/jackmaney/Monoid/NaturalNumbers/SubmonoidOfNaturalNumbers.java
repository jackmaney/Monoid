package com.jackmaney.Monoid.NaturalNumbers;

import com.jackmaney.Monoid.IterableMonoid;
import com.jackmaney.Monoid.Element.NaturalNumber;
import com.jackmaney.Monoid.Factorization.Factorization;

public interface SubmonoidOfNaturalNumbers<T extends NaturalNumber>
	extends IterableMonoid<NaturalNumber>{
	
	public static final NaturalNumber one = new NaturalNumber(1);
	
	public Factorization<NaturalNumber> primeFactorization(NaturalNumber n);
}
