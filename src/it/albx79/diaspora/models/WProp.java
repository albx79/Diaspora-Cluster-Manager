package it.albx79.diaspora.models;

public class WProp<I> extends ROProp<I> {
	public WProp(I initialValue) {
		super(initialValue);
	}

	/**
	 * @param value
	 * @return <code>true</code> if value was actually changed.
	 */
	public boolean set(I value) {
		if (value == null)
			return false;
		this.value = value;
		for (PropObserver<? super I> l : mObservers)
			l.onValueChanged(value);
		return true;
	}

}
