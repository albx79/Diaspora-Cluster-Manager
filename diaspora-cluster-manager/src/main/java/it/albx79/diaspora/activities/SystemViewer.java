package it.albx79.diaspora.activities;

import it.albx79.diaspora.R;
import roboguice.RoboGuice;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;

public class SystemViewer extends OrmLiteBaseActivity<OrmLiteSqliteOpenHelper> {
	private static final String TAG = "SystemViewer";
	
	@InjectView(R.id.systemName) TextView systemName;
	@InjectView(R.id.editEnv) EditText env;
	@InjectView(R.id.editRes) EditText res;
	@InjectView(R.id.editTech) EditText tech;

	public SystemViewer() {
		RoboGuice.getBaseApplicationInjector(getApplication()).injectMembers(this);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "Starting up");
		setContentView(R.layout.system_view);
		Intent i = getIntent();
		// TODO everything...
	}

}
