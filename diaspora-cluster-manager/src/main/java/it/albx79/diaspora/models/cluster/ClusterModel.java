package it.albx79.diaspora.models.cluster;

import java.util.ArrayList;
import java.util.List;

import it.albx79.diaspora.models.NonNullStringProp;
import it.albx79.diaspora.models.ROProp;
import it.albx79.diaspora.models.WProp;
import it.albx79.diaspora.models.system.SystemModel;

public class ClusterModel {
	public final WProp<String> name = new NonNullStringProp("");
	public final WProp<String> aspect = new NonNullStringProp("");
	public final ROProp<List<SystemModel>> systems = new ROProp<List<SystemModel>>(new ArrayList<SystemModel>());
}
