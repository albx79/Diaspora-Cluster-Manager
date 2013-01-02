package it.albx79.diaspora.daos;

import it.albx79.diaspora.models.cluster.ClusterEntity;
import it.albx79.diaspora.models.system.SystemEntity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getName();

	private static final String DATABASE_NAME = "DiasporaClusters.sqlite";
    
    private static final int DATABASE_VERSION = 1;
    
    private Dao<ClusterEntity, String> clusterDao = null;
    private Dao<SystemEntity, String> systemDao = null;
	
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
        try {
            TableUtils.createTable(connectionSource, ClusterEntity.class);
            TableUtils.createTable(connectionSource, SystemEntity.class);
        } catch (SQLException e) {
            Log.e(TAG, "Can't create database", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource arg1, int oldVersion, int newVersion) {
        try {
            List<String> allSql = new ArrayList<String>(); 
            switch(oldVersion) 
            {
              case 1: 
                  //allSql.add("alter table xxx add column `yyy` TTT");
                  //allSql.add("alter table zzz add column `jjj` UUU");
            }
            for (String sql : allSql) {
                db.execSQL(sql);
            }
        } catch (SQLException e) {
            Log.e(TAG, "exception during onUpgrade", e);
            throw new RuntimeException(e);
        }
    }

	public Dao<ClusterEntity, String> getClusterDao() {
		if (clusterDao == null) {
			try {
				clusterDao = getDao(ClusterEntity.class);
			} catch (java.sql.SQLException e) {
				Log.e(TAG, e.getMessage());
			}
		}
		return clusterDao;
	}
	
	public Dao<SystemEntity, String> getSystemDao() {
		if (systemDao == null) {
			try {
				systemDao = getDao(SystemEntity.class);
			} catch (java.sql.SQLException e) {
				Log.e(TAG, e.getMessage());
			}
		}
		return systemDao;
	}
}
