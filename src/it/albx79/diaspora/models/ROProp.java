package it.albx79.diaspora.models;

import android.database.Observable;

public class ROProp<I> extends Observable<PropObserver<? super I>> {
	protected I value;
	
	public ROProp(I initialValue) {
		if (initialValue == null)
			throw new NullPointerException("Cannot set null on properties");
		value = initialValue;
	}

	public I get() {
		return value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
}
