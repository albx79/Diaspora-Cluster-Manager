package it.albx79.diaspora.activities;

import it.albx79.diaspora.R;
import it.albx79.diaspora.controllers.Connector;
import it.albx79.diaspora.models.system.SystemDB;
import it.albx79.diaspora.models.system.SystemModel;

import java.sql.SQLException;

import roboguice.RoboGuice;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

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
		SystemModel model = new SystemModel();
//		Bundle extras = i.getExtras();
//		if (extras != null) {
//			Log.i(TAG, "unpacking bundle");
//			model.readBundle(extras);
//		} else {
//			Log.w(TAG, "no bundle initialise system with");
//		}
		String sysName = i.getStringExtra("system");
		if (sysName != null)
			model.name.set(sysName);
		else
			Log.e(TAG, "no 'system' extra in intent");
		Connector.bind(model.name, systemName);

		getConnectionSource();
		
//		RuntimeExceptionDao<SystemDB, String> sysDao = new RuntimeExceptionDao<SystemDB, String>(DaoManager.createDao(helper.getConnectionSource(), SystemDB.class));
		Connector.bind(model.env, env);
		Connector.bind(model.res, res);
		Connector.bind(model.tech, tech);
	}

}
