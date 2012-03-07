package it.albx79.diaspora.controllers;

import it.albx79.diaspora.models.PropObserver;
import it.albx79.diaspora.models.ROProp;
import android.widget.TextView;

public class Connector {
	public static <T>void bind(final ROProp<T> property, final TextView widget) {
		updateView(property, widget);
		property.registerObserver(new PropObserver<T>() {
			@Override
			public void onValueChanged(T value) {
				updateView(property, widget);
			}	
		});
	}

	private static <T> void updateView(ROProp<T> property, TextView widget) {
		widget.setText(property.get().toString());
	}
}
