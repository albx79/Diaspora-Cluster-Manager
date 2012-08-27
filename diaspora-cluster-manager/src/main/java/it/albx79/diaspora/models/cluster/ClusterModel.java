package it.albx79.diaspora.models.cluster;

import it.albx79.diaspora.models.ListProp;
import it.albx79.diaspora.models.NonNullStringProp;
import it.albx79.diaspora.models.WProp;
import it.albx79.diaspora.models.system.SystemModel;

public class ClusterModel {
	public final WProp<String> name = new NonNullStringProp("");
	public final WProp<String> aspect = new NonNullStringProp("");
	public final ListProp<SystemModel> systems = new ListProp<SystemModel>();	
}
