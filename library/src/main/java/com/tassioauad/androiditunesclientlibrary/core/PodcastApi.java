package com.tassioauad.androiditunesclientlibrary.core;

import com.tassioauad.androiditunesclientlibrary.service.entity.PodcastEntryEntity;
import com.tassioauad.androiditunesclientlibrary.service.entity.PodcastEntity;

import java.util.concurrent.ExecutionException;

/**
 * Created by Tássio Auad on 19/07/2014.
 */
public interface PodcastApi {

    public PodcastEntryEntity[] listAllEntries(PodcastEntity podcastEntity) throws ExecutionException, InterruptedException;

    public PodcastEntity[] listNewPodcasts();

    PodcastEntity[] listNewPodcasts(int numberOfPodcasts);

    public PodcastEntity[] listPodcastByTerm(String term);

    public void setListener(OnApiResultListener listener);

    PodcastEntity[] listPodcastByTerm(String term, int numberOfPodcasts);
}
