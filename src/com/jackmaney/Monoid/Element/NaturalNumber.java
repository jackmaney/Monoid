package com.jackmaney.Monoid.Element;



public class NaturalNumber extends Number  implements ComparableMonoidElement<NaturalNumber>{

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6039590190258946047L;
	private int value;
	
	public NaturalNumber(int n){
		if(n < 0){
			throw new IllegalArgumentException();
		}
		
		this.value = n;
	}

	@Override
	public NaturalNumber multiply(NaturalNumber t) {
		return new NaturalNumber(intValue() * t.intValue());
	}

	@Override
	public NaturalNumber pow(int n) {
		if(n < 0){
			throw new IllegalArgumentException();
		}
		
		NaturalNumber result = new NaturalNumber(1);
		
		for(int i = 0; i < n; i++){
			result = result.multiply(this);
		}
		
		return result;
	}

	@Override
	public NaturalNumber divides(NaturalNumber t) {
		NaturalNumber result = null;
		
		double ratio = t.doubleValue() / doubleValue();
		
		if(ratio == (int)ratio){
			result = new NaturalNumber((int)ratio);
		}
		
		return result;
	}


	@Override
	public int intValue() {
		return value;
	}

	@Override
	public long longValue() {
		return (long)value;
	}

	@Override
	public float floatValue() {
		return (float)value;
	}

	@Override
	public double doubleValue() {
		return (double)value;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return intValue();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof NaturalNumber)) {
			return false;
		}
		NaturalNumber other = (NaturalNumber) obj;
		if (intValue() != other.intValue()) {
			return false;
		}
		return true;
	}


	@Override
	public int compareTo(NaturalNumber o) {
		
		Integer a = new Integer(intValue());
		Integer b = new Integer(o.intValue());
		
		return a.compareTo(b);
	}

	@Override
	public String toString() {
		return String.valueOf(intValue());
	}

}
