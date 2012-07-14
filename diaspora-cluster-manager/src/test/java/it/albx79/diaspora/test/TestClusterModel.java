package it.albx79.diaspora.test;

import it.albx79.diaspora.models.cluster.ClusterModel;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.xtremelabs.robolectric.RobolectricTestRunner;

import junit.framework.TestCase;

@RunWith(RobolectricTestRunner.class)
public class TestClusterModel extends TestCase {
	
	private ClusterModel model;
	
	@Test
	public void clusters_have_name_and_aspect() {
		createClusterModel();
		model.name.set("Foo Cluster");
		model.aspect.set("this is a test");
	}

	private void createClusterModel() {
		model = new ClusterModel();
	}
}
