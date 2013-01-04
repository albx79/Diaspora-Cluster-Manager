package it.albx79.diaspora.activities;

import it.albx79.diaspora.R;
import it.albx79.diaspora.daos.DatabaseManager;
import it.albx79.diaspora.models.cluster.ClusterEntity;

import java.util.ArrayList;
import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * List all known clusters of the Universe.
 * @author albx
 *
 */
public class ClustersManager extends RoboActivity {
	protected static final String TAG = "ClustersManager";
	
	@InjectView(R.id.list_view) ListView listView;
	@InjectView(R.id.button_add) Button btn;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setupButton(btn);
    }
    
    private void setupButton(Button btn) {
        final Activity activity = this;
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(activity, ClusterViewer.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
    	super.onStart();
    	DatabaseManager.init(this);
    	setupListView(listView);
    }
    
	private void setupListView(ListView lv) {
        final List<ClusterEntity> clusters = DatabaseManager.getInstance().getAllClusters();
        
        List<String> titles = new ArrayList<String>();
        for (ClusterEntity cl : clusters) {
            titles.add(cl.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles);
        lv.setAdapter(adapter);

        final Activity activity = this;
        
        
        lv.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	ClusterEntity cluster = clusters.get(position);
                Intent intent = new Intent(activity, ClusterViewer.class);
                intent.putExtra("CLUSTER_NAME", cluster.getName());
                startActivity(intent);
            }

        });
    }

}