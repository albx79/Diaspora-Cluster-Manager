package it.albx79.diaspora.models.system;

import android.os.Bundle;
import it.albx79.diaspora.models.Bundler;

class SystemBundler implements Bundler<SystemModel> {

	public static final String ENV = "environment";
	public static final String RES = "resources";
	public static final String TECH = "technology";
	public static final String NAME = "system-name";

	@Override
	public Bundle bundle(SystemModel t) {
		Bundle b = new Bundle();
		b.putInt(ENV, t.env.get());
		b.putInt(RES, t.res.get());
		b.putInt(TECH, t.tech.get());
		b.putCharSequence(NAME, t.name.get());
		return b;
	}

	@Override
	public void unbundle(SystemModel m, Bundle b) {
		m.env.set(b.getInt(ENV));
		m.res.set(b.getInt(RES));
		m.tech.set(b.getInt(TECH));
		String name = b.getString(NAME);
		if (name != null)
			m.name.set(name);
	}

}
