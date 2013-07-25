package com.jackmaney.Monoid.Strategy;

import java.util.ArrayList;

import com.jackmaney.Monoid.Monoid;
import com.jackmaney.Monoid.Element.MonoidElement;

public class NaiveIrreducibleFinderStrategy<T extends MonoidElement<T>> 
	implements FindIrreducibleFactorsStrategy<T>{
	
	@Override
	public ArrayList<T> find(T element, Monoid<T> m) {
		
		ArrayList<T> allFactors = m.getFindAllFactorsStrategy().find(element, m);
		
		ArrayList<T> result = new ArrayList<>();
		
		allFactors.remove(m.identity());
		allFactors.remove(element);
		
		if(allFactors.isEmpty()){
			result.add(element);
		}
		else{
			
			for(int i = 0; i < allFactors.size(); i++){
				
				T alpha = allFactors.get(i);
				boolean isIrreducible = true;
				
				for(int j = 0; j < allFactors.size(); j++){
					
					if(i == j){
						continue;
					}
					
					T beta = allFactors.get(j);
					
					if(beta.divides(alpha) != null){
						isIrreducible = false;
						break;
					}
				}
				
				if(isIrreducible){
					result.add(alpha);
				}
			}
		}
		
		
		return result;
	}
	
	
	
	

}
