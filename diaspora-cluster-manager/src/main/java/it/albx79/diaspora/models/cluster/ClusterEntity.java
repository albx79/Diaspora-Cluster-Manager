package it.albx79.diaspora.models.cluster;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import it.albx79.diaspora.models.system.SystemEntity;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="clusters")
public class ClusterEntity {
	@DatabaseField(id=true) 
	private String name;
	
	@DatabaseField 
	private String aspect;
	
	@ForeignCollectionField
	private ForeignCollection<SystemEntity> systems;

	public ClusterEntity() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAspect() {
		return aspect;
	}

	public void setAspect(String aspect) {
		this.aspect = aspect;
	}
	
	public List<SystemEntity> getSystems() {
		return new ArrayList<SystemEntity>(systems);
	}
	
	public void setSystems(ForeignCollection<SystemEntity> systems) {
		this.systems = systems;
	}
}
