package it.albx79.diaspora.models;

public interface PropObserver<T> {
	public void onValueChanged(T value);
}
