package it.albx79.diaspora.test;

import it.albx79.diaspora.models.ListObserver;
import it.albx79.diaspora.models.ListProp;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class TestListProperty extends TestCase {

	private abstract class AbstractListObserver implements ListObserver<String> {
		@Override
		public void onElementRemoved(String elem) {}

		@Override
		public void onElementAdded(String elem) {}
	}

	private ListProp<String> prop;
	
	@Test
	public void prop_contains_elements_passed_to_constructor() {
		prop = new ListProp<String>("foo", "bar");
		assertEquals(2, prop.all().size());
	}
	
	private String elementAdded;
	
	@Test
	public void adding_elements_notifies_observers() {
		createEmptyList();
		prop.addObserver(new AbstractListObserver(){
			@Override
			public void onElementAdded(String elem) {
				elementAdded = elem;
			}
		});
		prop.add("foobar");
		assertEquals("foobar", elementAdded);
	}

	private String elementRemoved;
	
	@Test
	public void removing_elements_notifies_observers() {
		createEmptyList();
		prop.add("foobar");
		prop.addObserver(new AbstractListObserver() {
			@Override
			public void onElementRemoved(String elem) {
				elementRemoved = elem;
			}
		});
		prop.remove("foobar");
		assertEquals("foobar", elementRemoved);
	}
	
	private void createEmptyList() {
		prop = new ListProp<String>();
	}
}
