package it.albx79.diaspora.test;

import org.junit.Test;

import it.albx79.diaspora.activities.SystemViewer;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

public class TestSystemViewer extends ActivityInstrumentationTestCase2<SystemViewer> {

	private static final String PACKAGE = "it.albx79.diaspora";
	private static final Class<SystemViewer> TEST_CLASS = SystemViewer.class;

	public TestSystemViewer() {
		super(PACKAGE, TEST_CLASS);
	}

	@Test
	public void test_that_can_create_activity() {
		launchActivityWithIntent(PACKAGE, TEST_CLASS, createIntent());
	}

	private Intent createIntent() {
		Intent intent = new Intent(getActivity(), TEST_CLASS);
		intent.putExtra("system", "my first system");
		return intent;
	}
}
