package it.albx79.diaspora.daos;

import it.albx79.diaspora.models.cluster.ClusterEntity;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.j256.ormlite.dao.Dao;

import android.content.Context;
import android.util.Log;

public class DatabaseManager {

    private static final String TAG = DatabaseManager.class.getName();
	static private DatabaseManager instance;

    static public void init(Context ctx) {
        if (null==instance) {
            instance = new DatabaseManager(ctx);
        }
    }

    static public DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    private DatabaseManager(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public List<ClusterEntity> getAllClusters() {
        try {
            return getHelper().getClusterDao().queryForAll();
        } catch (SQLException e) {
        	logError(e);
            return Collections.emptyList();
        }
    }

	public ClusterEntity getClusterById(String clusterName) {
		try {
			Dao<ClusterEntity, String> clusterDao = getHelper().getClusterDao();
			return clusterDao.queryForId(clusterName);
		} catch (SQLException e) {
			logError(e);
			return null;
		}
	}

	private void logError(SQLException e) {
		Log.e(TAG, e.getMessage());
	}

	public void updateCluster(ClusterEntity cluster) {
		try {
			Dao<ClusterEntity,String> dao = getHelper().getClusterDao();
			dao.update(cluster);
		} catch (SQLException e) {
			logError(e);
		}
	}
}