package it.albx79.diaspora.models;

public interface ListObserver<T> {
	public void onElementAdded(T elem);
	public void onElementRemoved(T elem);
}
