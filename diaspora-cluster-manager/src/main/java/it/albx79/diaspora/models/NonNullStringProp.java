package it.albx79.diaspora.models;

/**
 * A string property that throws a {@link NullPointerException} if an attempt is
 * made to set it to <code>null</code>. This is different from the standard
 * behaviour of properties, that will just ignore a call to {@link #set(String)}
 * if the value is <code>null</code>.
 * 
 * @author albx
 * 
 */
public class NonNullStringProp extends WProp<String> {
	public NonNullStringProp(String initialValue) {
		super(initialValue);
	}

	@Override
	public boolean set(String value) {
		if (value == null)
			throw new NullPointerException("System name cannot be null");
		return super.set(value);
	}
}