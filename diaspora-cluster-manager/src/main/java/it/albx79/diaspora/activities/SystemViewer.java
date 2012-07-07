package it.albx79.diaspora.activities;

import it.albx79.diaspora.R;
import it.albx79.diaspora.controllers.Connector;
import it.albx79.diaspora.models.system.SystemModel;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class SystemViewer extends RoboActivity {
	private static final String TAG = "SystemViewer";
	
	@InjectView(R.id.systemName) TextView systemName;
	@InjectView(R.id.editEnv) EditText env;
	@InjectView(R.id.editRes) EditText res;
	@InjectView(R.id.editTech) EditText tech;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "Starting up");
		setContentView(R.layout.system_view);
		Intent i = getIntent();
		SystemModel model = new SystemModel();
		Bundle extras = i.getExtras();
		if (extras != null) {
			Log.i(TAG, "unpacking bundle");
			model.readBundle(extras);
		} else {
			Log.w(TAG, "no bundle initialise system with");
		}
		Connector.bind(model.name, systemName);
		Connector.bind(model.env, env);
		Connector.bind(model.res, res);
		Connector.bind(model.tech, tech);
	}

}
