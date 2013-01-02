package it.albx79.diaspora.activities;

import android.os.Bundle;
import android.widget.TextView;
import it.albx79.diaspora.Constants;
import it.albx79.diaspora.R;
import it.albx79.diaspora.daos.DatabaseManager;
import it.albx79.diaspora.models.cluster.ClusterEntity;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

/**
 * View and edit a single cluster.
 * 
 * Also used to manage the systems in a cluster.
 * @author albx
 *
 */
public class ClusterViewer extends RoboActivity {
	public static final String TAG = "ClusterView";
	
	@InjectView(R.id.clusterName) TextView clusterName;
	@InjectView(R.id.clusterAspect) TextView clusterAspect;
	
	private ClusterEntity cluster;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cluster_view);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		String clusterName = getIntent().getStringExtra(Constants.CLUSTER_NAME);
		if (clusterName == null)
			cluster = new ClusterEntity();
		else
			cluster = DatabaseManager.getInstance().getClusterById(clusterName);
	}
	
	
}
