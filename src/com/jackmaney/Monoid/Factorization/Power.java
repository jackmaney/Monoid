package com.jackmaney.Monoid.Factorization;

import com.jackmaney.Monoid.Monoid;
import com.jackmaney.Monoid.Element.MonoidElement;

public class Power<T extends MonoidElement<T>> {
	private T base;
	private int exponent;
	private Monoid<T> monoid;
	
	public Power(T base,int exponent,Monoid<T> monoid){
		if(exponent < 0){
			throw new IllegalArgumentException();
		}
		
		this.monoid = monoid;
		
		if(exponent == 0){
			this.base = monoid.identity();
			this.exponent = 1;
		}
		else{
			this.base = base;
			this.exponent = exponent;
		}
	}
	
	public Power(T base,Monoid<T> monoid){
		this(base,1,monoid);
	}
	
	public T product(){
		if(exponent > 0){
			return base.pow(exponent);
		}
		else{
			return monoid.identity();
		}
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(base.toString());
		sb.append(")");
		
		if(exponent > 1){
			sb.append("^").append(exponent);
		}
		
		return sb.toString();
	}

	/**
	 * @return the base
	 */
	public T getBase() {
		return base;
	}

	/**
	 * @return the exponent
	 */
	public int getExponent() {
		return exponent;
	}
}
