package it.albx79.diaspora.test;

import it.albx79.diaspora.activities.ClustersManager;
import it.albx79.diaspora.controllers.Connector;
import it.albx79.diaspora.models.WProp;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class TestViewController extends ActivityInstrumentationTestCase2<ClustersManager> {
	private final String STRING_VAL = "an example string";
	private final String ANOTHER_STRING = "this is another string";
	private WProp<String> prop;
	private TextView textView;

	public TestViewController() {
		super("it.albx79.diaspora", ClustersManager.class);
	}

	@Test
	public void test_TextView_reflects_property_value() {
		createPropertyWith(STRING_VAL);
		createTextView();
		bindPropertyWithView();
		Assert.assertEquals(STRING_VAL, textView.getText());
	}

	@Test
	public void test_setting_Prop_updates_TextView() {
		createPropertyWith(STRING_VAL);
		createTextView();
		bindPropertyWithView();
		prop.set(ANOTHER_STRING);
		Assert.assertEquals(ANOTHER_STRING, textView.getText());
	}
	
	@Test
	public void test_that_can_launch_activity_with_intent() {
		launchActivity("it.albx79.diaspora", ClustersManager.class, new Bundle());
	}

	private void bindPropertyWithView() {
		Connector.bind(prop, textView);
	}
	
	private void createPropertyWith(String initialValue) {
		prop = new WProp<String>(initialValue);
	}

	private void createTextView() {
		textView = new TextView(getActivity());		
	}
	
}
