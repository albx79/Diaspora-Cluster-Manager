package it.albx79.diaspora.models.system;

import it.albx79.diaspora.models.cluster.ClusterDB;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="systems")
public class SystemDB {
	@DatabaseField
	public int tech;
	@DatabaseField
	public int env;
	@DatabaseField
	public int res;
	@DatabaseField(id=true)
	public String name;
	@DatabaseField(foreign=true)
	public ClusterDB cluster;
	
	public SystemDB() {}
}
