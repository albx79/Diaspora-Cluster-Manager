package it.albx79.diaspora.models;

import android.database.Observable;

/**
 * A solar system is a node in a cluster. It is defined by its name, its three
 * stats (technology, environment and resources, each between -4 and 4), and
 * three aspects. Each system is connected to at least one, and up to four other
 * systems.
 * 
 * @author albx
 * 
 */
public class SystemModel extends Observable<SystemObserver> {
	public final WProp<Integer> tech = new WProp<Integer>(0);
	public final WProp<Integer> env = new WProp<Integer>(0);
	public final WProp<Integer> res = new WProp<Integer>(0);
	public final WProp<String> name = new WProp<String>("") {
		@Override
		public boolean set(String value) {
			if (value == null)
				throw new NullPointerException("System name cannot be null");
			return super.set(value);
		};
	};

	public SystemModel() {
		tech.registerObserver(new PropObserver<Integer>() {
			@Override
			public void onValueChanged(Integer value) {
				for (SystemObserver o : SystemModel.this.mObservers)
					o.techChanged(value);
			} 
		});
		
		env.registerObserver(new PropObserver<Integer>() {
			@Override
			public void onValueChanged(Integer value) {
				for (SystemObserver o : mObservers)
					o.envChanged(value);
			}
		});
		
		res.registerObserver(new PropObserver<Integer>() {
			@Override
			public void onValueChanged(Integer value) {
				for (SystemObserver o : mObservers)
					o.resChanged(value);
			}
		});
		
		name.registerObserver(new PropObserver<String>() {
			@Override
			public void onValueChanged(String value) {
				for (SystemObserver o : mObservers) 
					o.nameChanged(value);
			}
		});
	}
	
	@Override
	public String toString() {
		return name+" "+tech+"/"+env+"/"+res;
	}
}
