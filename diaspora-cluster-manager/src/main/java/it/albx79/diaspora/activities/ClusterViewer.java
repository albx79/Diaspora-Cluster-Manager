package it.albx79.diaspora.activities;

import it.albx79.diaspora.Constants;
import it.albx79.diaspora.R;
import it.albx79.diaspora.daos.DatabaseManager;
import it.albx79.diaspora.models.cluster.ClusterEntity;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;

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
	@InjectView(R.id.btn_cluster_back) Button btnBack;
	@InjectView(R.id.btn_cluster_revert) Button btnRevert;
	
	private ClusterEntity cluster;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cluster_view);
		
		clusterName.addTextChangedListener(new TextWatchAdapter() {
			@Override
			public void afterTextChanged(Editable s) {
				cluster.setName(s.toString());
				DatabaseManager.getInstance().updateCluster(cluster);
			}
		});
		
		clusterAspect.addTextChangedListener(new TextWatchAdapter() {
			@Override
			public void afterTextChanged(Editable s) {
				cluster.setAspect(s.toString());
				DatabaseManager.getInstance().updateCluster(cluster);
			}
		});
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		String name = getIntent().getStringExtra(Constants.CLUSTER_NAME);
		if (name == null|| (cluster=DatabaseManager.getInstance().getClusterById(name))==null) {
			cluster = new ClusterEntity();
			cluster.setName("New Cluster");
			cluster.setAspect("a new cluster");
		}
		
		clusterName.setText(cluster.getName());
		clusterAspect.setText(cluster.getAspect());
	}
	
	private static abstract class TextWatchAdapter implements TextWatcher {
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		@Override
		public void afterTextChanged(Editable s) {}
	}
	
	
}
