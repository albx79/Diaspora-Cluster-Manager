package it.albx79.diaspora.models;



public class ROProp<I> extends Property<PropObserver<I>> {
	protected I value;
	
	public ROProp(I initialValue) {
		if (initialValue == null)
			throw new NullPointerException("Cannot set null on properties");
		value = initialValue;
		assert mObservers != null;
	}

	public I get() {
		return value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
	@Override
	public final boolean equals(Object o) {
		return o instanceof ROProp && ((ROProp<?>)o).get().equals(value);
	}
}
