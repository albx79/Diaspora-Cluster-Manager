package it.albx79.diaspora.models;

import java.util.ArrayList;

public class Property<I> implements Observable<I> {

	protected final ArrayList<I> mObservers = 
			new ArrayList<I>();

	public Property() {
		super();
	}

	@Override
	public void addObserver(I o) {
		mObservers.add(o);
	}

	@Override
	public void removeObserver(I o) {
		mObservers.remove(o);
	}

}