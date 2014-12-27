package com.tassioauad.androiditunesclientlibrary.core;

import android.content.Context;

import com.tassioauad.androiditunesclientlibrary.service.PodcastEntriesAsyncTask;
import com.tassioauad.androiditunesclientlibrary.service.SearchPodcastAsyncTask;
import com.tassioauad.androiditunesclientlibrary.service.entity.PodcastEntity;
import com.tassioauad.androiditunesclientlibrary.service.entity.PodcastEntryEntity;
import com.tassioauad.androiditunesclientlibrary.service.parameter.BasicParameter;
import com.tassioauad.androiditunesclientlibrary.service.parameter.BasicParametersList;
import com.tassioauad.androiditunesclientlibrary.service.parameter.key.Key;

import java.util.concurrent.ExecutionException;

/**
 * Created by Tássio Auad on 19/07/2014.
 */
public class PodcastApiImpl implements PodcastApi {

    private Context context;
    private OnApiResultListener listener;

    private static final String LIMIT = "20";

    public PodcastApiImpl(Context context) {
        this.context = context;
    }

    @Override
    public void setListener(OnApiResultListener listener) {
        this.listener = listener;
    }

    @Override
    public PodcastEntryEntity[] listAllEntries(PodcastEntity podcastEntity) throws ExecutionException, InterruptedException {
        PodcastEntriesAsyncTask podcastEntriesAsyncTask = new PodcastEntriesAsyncTask();
        if (listener != null) {
            podcastEntriesAsyncTask.setListener(listener);
            podcastEntriesAsyncTask.execute(podcastEntity.getFeedUrl());
            return null;
        }

        return podcastEntriesAsyncTask.execute(podcastEntity.getFeedUrl()).get();
    }

    @Override
    public PodcastEntity[] listNewPodcasts() {
        try {
            BasicParametersList basicParametersList = new BasicParametersList();
            basicParametersList.add(new BasicParameter(Key.TERM, "podcast"));
            basicParametersList.add(new BasicParameter(Key.LIMIT, LIMIT));

            SearchPodcastAsyncTask searchPodcastAsyncTask = new SearchPodcastAsyncTask();
            if (listener != null) {
                searchPodcastAsyncTask.setListener(listener);
                searchPodcastAsyncTask.execute(basicParametersList);
                return null;
            }

            return searchPodcastAsyncTask.get();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PodcastEntity[] listNewPodcasts(int numberOfPodcasts) {
        try {
            BasicParametersList basicParametersList = new BasicParametersList();
            basicParametersList.add(new BasicParameter(Key.TERM, "podcast"));
            basicParametersList.add(new BasicParameter(Key.LIMIT, String.valueOf(numberOfPodcasts)));

            SearchPodcastAsyncTask searchPodcastAsyncTask = new SearchPodcastAsyncTask();
            if (listener != null) {
                searchPodcastAsyncTask.setListener(listener);
                searchPodcastAsyncTask.execute(basicParametersList);
                return null;
            }

            return searchPodcastAsyncTask.get();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PodcastEntity[] listPodcastByTerm(String term) {
        try {
            BasicParametersList basicParametersList = new BasicParametersList();
            basicParametersList.add(new BasicParameter(Key.TERM, term));
            basicParametersList.add(new BasicParameter(Key.LIMIT, LIMIT));

            SearchPodcastAsyncTask searchPodcastAsyncTask = new SearchPodcastAsyncTask();
            if (listener != null) {
                searchPodcastAsyncTask.setListener(listener);
                searchPodcastAsyncTask.execute(basicParametersList);
                return null;
            }

            return searchPodcastAsyncTask.get();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PodcastEntity[] listPodcastByTerm(String term, int numberOfPodcasts) {
        try {
            BasicParametersList basicParametersList = new BasicParametersList();
            basicParametersList.add(new BasicParameter(Key.TERM, term));
            basicParametersList.add(new BasicParameter(Key.LIMIT, String.valueOf(numberOfPodcasts)));

            SearchPodcastAsyncTask searchPodcastAsyncTask = new SearchPodcastAsyncTask();
            if (listener != null) {
                searchPodcastAsyncTask.setListener(listener);
                searchPodcastAsyncTask.execute(basicParametersList);
                return null;
            }

            return searchPodcastAsyncTask.get();

        } catch (Exception e) {
            return null;
        }
    }

}
