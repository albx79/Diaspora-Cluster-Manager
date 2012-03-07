package it.albx79.diaspora.activities;

import it.albx79.diaspora.R;
import it.albx79.diaspora.controllers.Connector;
import it.albx79.diaspora.models.SystemModel;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SystemViewer extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.system_view);
		Intent i = getIntent();
		SystemModel model = null;
		if (i.getExtras() != null) {
			model = (SystemModel)i.getExtras().get("SYSTEM_MODEL");
		}
		if (model==null) {
			model = new SystemModel();
			model.name.set("My First System");
			model.tech.set(1);
			model.res.set(2);
			model.env.set(3);
		}
		
		Connector.bind(model.name, (TextView)findViewById(R.id.systemName));
	}

}
