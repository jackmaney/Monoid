package com.jackmaney.Monoid.Factorization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.jackmaney.Monoid.ExponentList;
import com.jackmaney.Monoid.Monoid;
import com.jackmaney.Monoid.Element.MonoidElement;

public class Factorization<T extends MonoidElement<T>> 
	extends ArrayList<Power<T>>{
	
	private Monoid<T> monoid;
	
	public Factorization(Monoid<T> m){
		super();
		this.monoid = m;
	}
	
	public Factorization(Collection<? extends Power<T>> c,Monoid<T> m){
		super(c);
		this.monoid = m;
		consolidate();
	}
	
	public Factorization(int initialCapacity, Monoid<T> m){
		super(initialCapacity);
		this.monoid = m;
		consolidate();
	}
	
	public ExponentList getExponentList(){
		ArrayList<Integer> a = new ArrayList<>();
		
		for (Power<T> power : this) {
			a.add(power.getExponent());
		}
		
		return new ExponentList(a);
	}
	
	public int length(){
		int result = 0;
		
		ExponentList exponents = getExponentList();
		
		for (Integer integer : exponents) {
			result += integer;
		}
		
		return result;
	}
	
	@Override
	public void add(int index, Power<T> element) {
		super.add(index, element);
		consolidate();
	}
	
	/*
	 * Necessary for tacking elements back on to <code>this</code>
	 * within the consolidate() method.
	 */
	private boolean unconsolidatedAdd(Power<T> e){
		return super.add(e);
	}
	
	@Override
	public boolean add(Power<T> e) {
		boolean result = super.add(e);
		consolidate();
		return result;
	}
	
	@Override
	public boolean addAll(Collection<? extends Power<T>> c) {
		boolean result = super.addAll(c);
		consolidate();
		return result;
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends Power<T>> c) {
		boolean result = super.addAll(index,c);
		consolidate();
		return result;
	}
	
	private void consolidate(){
		
		HashMap<T, Integer> hash = new HashMap<>();
		
		for (Power<T> power : this) {
			if(hash.containsKey(power.getBase())){
				hash.put(power.getBase(), hash.get(power.getBase()) + power.getExponent());
			}
			else{
				hash.put(power.getBase(),power.getExponent());
			}
		}
		
		this.clear();
		
		Iterator<Entry<T, Integer>> it = hash.entrySet().iterator();
		
		while(it.hasNext()){
			Entry<T,Integer> pair = it.next();
			
			Power<T> p = new Power<T>(pair.getKey(),pair.getValue(),monoid);
			
			this.unconsolidatedAdd(p);
		}
		
		
	}
	
	public T product(){
		
		T result = null;
		
		for (Power<T> power : this) {
			if(result == null){
				result = power.product();
			}
			else{
				result = result.multiply(power.product());
			}
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for (Power<T> power : this) {
			sb.append(power.toString());
		}
		
		return sb.toString();
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 9203954067085130320L;
	

}
