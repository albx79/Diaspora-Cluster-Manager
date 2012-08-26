package it.albx79.diaspora.models.cluster;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="clusters")
public class ClusterDB {
	@DatabaseField(id=true) 
	public String name;
	@DatabaseField 
	public String aspect;

	public ClusterDB() {}
}
