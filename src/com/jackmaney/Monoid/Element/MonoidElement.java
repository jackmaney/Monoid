package com.jackmaney.Monoid.Element;

public interface MonoidElement<T> {
	public T multiply(T t);
	public T pow(int n);
	public T divides(T t);
	public double elasticity();
}
