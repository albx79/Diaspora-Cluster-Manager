package it.albx79.diaspora.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.xtremelabs.robolectric.RobolectricTestRunner;

import it.albx79.diaspora.models.system.SystemModel;
import it.albx79.diaspora.models.system.SystemObserver;
import junit.framework.Assert;
import junit.framework.TestCase;
import android.os.Bundle;

@RunWith(RobolectricTestRunner.class)
public class TestSystemModel extends TestCase {
	private static final String ANOTHER_NAME = "another name";
	private static final int TECH_LVL = 1;
	private static final int RES_LVL = 2;
	private static final int ENV_LVL = 3;
	private static final String SYS_NAME = "Foo";
	private SystemModel system;
	private int received_tech_lvl;
	private int received_res_lvl;
	private int received_env_lvl;
	private String received_sys_name;

	@Test
	public void test_that_getting_tech_lgets_last_value_set() {
		createSystem();
		system.tech.set(TECH_LVL);
		received_tech_lvl = system.tech.get();
		assertEquals(TECH_LVL, received_tech_lvl);
	}
	
	@Test
	public void test_that_setting_tech_notifies_observers() {
		createSystem();
		registerTechLevelObserver();
		assertFalse(TECH_LVL == received_tech_lvl);
		system.tech.set(TECH_LVL);
		assertEquals(TECH_LVL, received_tech_lvl);
	}
	
	@Test
	public void test_that_getting_res_gets_last_value_set() {
		createSystem();
		system.res.set(RES_LVL);
		received_res_lvl = system.res.get();
		assertEquals(RES_LVL, received_res_lvl);
	}
	
	@Test
	public void test_that_setting_res_notifies_observers() {
		createSystem();
		registerResLevelObserver();
		assertFalse(RES_LVL == received_res_lvl);
		system.res.set(RES_LVL);
		assertEquals(RES_LVL, received_res_lvl);
	}
	
	@Test
	public void test_that_getting_env_gets_last_value_set() {
		createSystem();
		system.env.set(ENV_LVL);
		received_env_lvl = system.env.get();
		assertEquals(ENV_LVL, received_env_lvl);
	}

	@Test
	public void test_that_setting_env_notifies_observers() {
		createSystem();
		registerEnvLevelObserver();
		assertFalse(ENV_LVL == received_env_lvl);
		system.env.set(ENV_LVL);
		assertEquals(ENV_LVL, received_env_lvl);
	}
	
	@Test
	public void test_that_sys_name_is_never_null() {
		createSystem();
		received_sys_name = system.name.get();
		assertNotNull(received_sys_name);
	}
	
	@Test
	public void test_that_cannot_set_null_sys_name() {
		boolean gotNPE = false;
		createSystem();
		try {
			system.name.set(null);
		} catch (NullPointerException e) {
			gotNPE = true;
		}
		assertTrue(gotNPE);
	}
	
	@Test
	public void test_that_getting_name_gets_last_value_set() {
		createSystem();
		system.name.set(SYS_NAME);
		received_sys_name = system.name.get();
		assertEquals(SYS_NAME, received_sys_name);
	}
	
	@Test
	public void test_that_setting_name_notifies_observers() {
		createSystem();
		registerSysNameObserver();
		assertFalse(SYS_NAME == received_sys_name);
		system.name.set(SYS_NAME);
		assertEquals(SYS_NAME, received_sys_name);
	}
	
	@Test
	public void test_comparison_between_equal_systems() {
		createSystem();
		SystemModel otherSystem = system;
		createSystem();
		assertEquals(system, otherSystem);
	}
	
	@Test
	public void test_comparison_betweem_different_systems() {
		createSystem();
		SystemModel otherSystem = system;
		createSystem();
		otherSystem.env.set(1);
		otherSystem.name.set(ANOTHER_NAME);
		assertFalse(system.equals(otherSystem));
		assertFalse(otherSystem.equals(system));
	}
	
	@Test
	public void test_comparison_between_systems_and_other_objects() {
		createSystem();
		assertFalse(system.equals(new Object()));
	}
	
	@Test
	public void test_SystemModel_can_create_bundle() {
		createSystem();
		Bundle bundle = system.toBundle();
		assertNotNull(bundle);
	}
	
	@Test
	public void test_reading_empty_bundle_leaves_system_unchanged() {
		createSystem();
		SystemModel newSystem = system;
		newSystem.readBundle(new Bundle());
		assertEquals(system, newSystem);
	}
	
	@Test
	public void test_can_recreate_system_from_bundle() {
		createSystem();
		system.tech.set(TECH_LVL);
		system.env.set(ENV_LVL);
		system.res.set(RES_LVL);
		system.name.set(SYS_NAME);
		Bundle bundle = system.toBundle();
		SystemModel oldSystem = system;
		createSystem();
		system.readBundle(bundle);
		assertEquals(oldSystem, system);
	}
	
	private void registerSysNameObserver() {
		system.registerObserver(new FailingSystemObserver() {
			@Override
			public void nameChanged(String name) {
				received_sys_name = name;
			}
		});
	}

	private void registerEnvLevelObserver() {
		system.registerObserver(new FailingSystemObserver() {
			@Override
			public void envChanged(int level) {
				received_env_lvl = level;
			}
		});
	}

	private void registerResLevelObserver() {
		system.registerObserver(new FailingSystemObserver() {
			@Override
			public void resChanged(int level) {
				received_res_lvl = level;
			}
		});
	}

	private void registerTechLevelObserver() {
		system.registerObserver(new FailingSystemObserver() {
			@Override
			public void techChanged(int level) {
				received_tech_lvl = level;
			}
		});
	}

	private void createSystem() {
		system = new SystemModel();
	}

	private void unexpectedCall() {
		Assert.fail("this method should not have been called");
	}
	
	private class FailingSystemObserver implements SystemObserver {
		@Override
		public void techChanged(int level) {
			unexpectedCall();
		}

		@Override
		public void resChanged(int level) {
			unexpectedCall();
		}

		@Override
		public void envChanged(int level) {
			unexpectedCall();
		}
		
		@Override
		public void nameChanged(String name) {
			unexpectedCall();
		}
		
	}
}
