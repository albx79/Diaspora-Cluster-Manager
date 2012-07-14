package it.albx79.diaspora.activities;

import android.os.Bundle;
import android.widget.TextView;
import it.albx79.diaspora.R;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class ClusterView extends RoboActivity {
	public static final String TAG = "ClusterView";
	
	@InjectView(R.id.clusterName) TextView clusterName;
	@InjectView(R.id.clusterAspect) TextView clusterAspect;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	
}
