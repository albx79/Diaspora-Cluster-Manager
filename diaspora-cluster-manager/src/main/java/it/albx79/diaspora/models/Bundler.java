package it.albx79.diaspora.models;

import android.os.Bundle;

/**
 * A bundler can serialize an object of type T into a bundle, and read a bundle
 * to recreate the original object.
 * 
 * @author albx
 * 
 * @param <T>
 */
public interface Bundler<T> {
	/**
	 * Creates a new bundle containing the state of {@code model}, so that it
	 * can be reconstracted from the bundle.
	 * 
	 * @param model
	 * @return
	 */
	public Bundle bundle(T model);
	
	/**
	 * Populates {@code model} with the parameters extracted from {@code bundle}.
	 * 
	 * @param model
	 * @param bundle
	 */
	public void unbundle(T model, Bundle bundle);
}
