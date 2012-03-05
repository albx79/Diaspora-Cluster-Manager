package it.albx79.diaspora.activities;

import it.albx79.diaspora.R;
import it.albx79.diaspora.models.SystemModel;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SystemViewer extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.system_view);
		Intent i = getIntent();
		SystemModel model = (SystemModel)i.getExtras().get("SYSTEM_MODEL");
	}

}
