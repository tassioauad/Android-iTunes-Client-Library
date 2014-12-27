package com.tassioauad.androiditunesclientlibrary.service;

import android.os.AsyncTask;

import com.tassioauad.androiditunesclientlibrary.core.OnApiResultListener;
import com.tassioauad.androiditunesclientlibrary.service.entity.PodcastEntryEntity;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Tássio on 09/06/2014.
 */
public class PodcastEntriesAsyncTask extends AsyncTask<String, Void, PodcastEntryEntity[]> {

    private OnApiResultListener listener;

    @Override
    protected PodcastEntryEntity[] doInBackground(String... strings) {

        String feedUrl = strings[0];
        try {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://ajax.googleapis.com/ajax/services/feed/load?v=1.0&num=100&q=" + feedUrl)
                    .build();

            Response response = client.newCall(request).execute();

            String jsonResponsed = getJson((InputStreamReader) response.body().charStream());
            return new Gson().fromJson(jsonResponsed, PodcastEntryEntity[].class);

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    protected void onPostExecute(PodcastEntryEntity[] podcastEntries) {
        if(listener != null) {
            listener.onResult(podcastEntries);
        }
    }

    public void setListener(OnApiResultListener listener) {
        this.listener = listener;
    }

    private String getJson(InputStreamReader inputStreamReader) throws IOException {

        StringBuilder response  = new StringBuilder();

        BufferedReader input = new BufferedReader(inputStreamReader);
        String strLine = null;
        while ((strLine = input.readLine()) != null)
        {
            response.append(strLine);
        }
        input.close();

        String json = response.toString();

        int indexOfBegin = json.indexOf("entries") + 9;
        json = json.substring(indexOfBegin, json.length());
        int indexOfEnd = json.indexOf("responseDetails") - 5;
        json = json.substring(0, indexOfEnd);

        return json;
    }

}
