package it.albx79.diaspora.models;

import android.os.Bundle;

/**
 * Implemented by any class that can be serialised into a bundle, and
 * deserialised from a bundle.
 * 
 * Deserialisation happens starting from an existing instance (possibly with
 * some default values set), and then a bundle is read and values appropriately
 * assigned to fields. Depending on the specific implementation, incomplete
 * bundle may or may not be considered valid.
 * 
 * @author albx
 * 
 */
public interface Bundleable {

	public abstract Bundle toBundle();

	public abstract void readBundle(Bundle bundle);

}