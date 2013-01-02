package it.albx79.diaspora.models.system;

import it.albx79.diaspora.models.cluster.ClusterEntity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="systems")
public class SystemEntity {
	
	@DatabaseField
	private int tech;
	
	@DatabaseField
	private int env;
	
	@DatabaseField
	private int res;
	
	@DatabaseField(id=true)
	private String name;
	
	@DatabaseField(foreign=true)
	private ClusterEntity cluster;
	
	public SystemEntity() {}

	public int getTech() {
		return tech;
	}

	public void setTech(int tech) {
		this.tech = tech;
	}

	public int getEnv() {
		return env;
	}

	public void setEnv(int env) {
		this.env = env;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClusterEntity getCluster() {
		return cluster;
	}

	public void setCluster(ClusterEntity cluster) {
		this.cluster = cluster;
	}
	
	
}
