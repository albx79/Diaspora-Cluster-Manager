package it.albx79.diaspora.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.xtremelabs.robolectric.RobolectricTestRunner;

import it.albx79.diaspora.models.PropObserver;
import it.albx79.diaspora.models.ROProp;
import it.albx79.diaspora.models.WProp;
import junit.framework.Assert;
import junit.framework.TestCase;

@RunWith(RobolectricTestRunner.class)
public class TestProperties extends TestCase {
	/** FOO and BAR are equals only to each other and to themselves*/
	private final Object FOO = new Object() {
		public boolean equals(Object o) {
			return o==BAR || o==this;
		};
	};
	private final Object BAR = new Object() {
		public boolean equals(Object o) {
			return o==FOO || o==this;
		};
	};
	private Object receivedValue;
	
	@Test
	public void test_property_value_can_be_read() {
		ROProp<Object> prop = createReadOnlyProp(FOO);
		Assert.assertEquals(FOO, prop.get());
	}
	
	@Test
	public void test_properties_refuse_null_initialization() {
		@SuppressWarnings("unused")
		ROProp<?> prop;
		try {
			prop = createReadOnlyProp(null);
			Assert.fail("An NPE should have been thrown");
		} catch (NullPointerException e) {
		}
	}

	@Test
	public void test_properties_refuse_setting_null_value() {
		WProp<Object> prop = createWritableProp(FOO);
		boolean wasSet = prop.set(null);
		Assert.assertFalse(wasSet);
	}
	
	@Test
	public void test_properties_return_true_when_set() {
		WProp<Object> prop = createWritableProp(FOO);
		boolean wasSet = prop.set(BAR);
		Assert.assertTrue(wasSet);
	}

	@Test
	public void test_property_value_can_be_written() {
		WProp<Object> prop = createWritableProp(BAR);
		prop.set(FOO);
		Assert.assertEquals(FOO, prop.get());
	}
	
	@Test
	public void test_setting_value_notifies_observers() {
		WProp<Object> prop = createWritableProp(FOO);
		registerPropertyObserver(prop);
		prop.set(BAR);
		Assert.assertEquals(BAR, receivedValue);
	}
	
	@Test
	public void test_Prop_toString_calls_value_toString() {
		String value = "a unique string";
		ROProp<Object> prop = createReadOnlyProp(value);
		Assert.assertEquals(value, prop.toString());
	}
	
	@Test
	public void test_two_Props_are_equal_if_thei_values_are_equal() {
		WProp<Object> prop1 = createWritableProp(FOO);
		WProp<Object> prop2 = createWritableProp(BAR);
		assertEquals(prop1, prop2);
	}

	private void registerPropertyObserver(WProp<Object> prop) {
		prop.registerObserver(new PropObserver<Object>() {
			@Override
			public void onValueChanged(Object value) {
				receivedValue = value;
			}
		});
	}

	private ROProp<Object> createReadOnlyProp(Object initialValue) {
		return new ROProp<Object>(initialValue);
	}

	private WProp<Object> createWritableProp(Object initialValue) {
		return new WProp<Object>(initialValue);
	}
}
