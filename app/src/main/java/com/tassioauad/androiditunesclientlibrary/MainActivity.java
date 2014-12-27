package com.tassioauad.androiditunesclientlibrary;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.tassioauad.androiditunesclientlibrary.core.OnApiResultListener;
import com.tassioauad.androiditunesclientlibrary.core.PodcastApi;
import com.tassioauad.androiditunesclientlibrary.core.PodcastApiImpl;
import com.tassioauad.androiditunesclientlibrary.service.entity.PodcastEntity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        final PodcastApi podcastApi = new PodcastApiImpl(this);
        podcastApi.setListener(new OnApiResultListener() {
            @Override
            public void onResult(Object[] result) {
                PodcastEntity[] podcastEntityArray = (PodcastEntity[]) result;
                for(PodcastEntity podcastEntity : podcastEntityArray) {
                    Log.i("PODCAST", podcastEntity.toString());
                }
            }
        });

        podcastApi.listNewPodcasts();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
