package it.albx79.diaspora.models;

public interface SystemObserver {
	public void techChanged(int level);
	public void resChanged(int level);
	public void envChanged(int level);
	public void nameChanged(String name);
}
