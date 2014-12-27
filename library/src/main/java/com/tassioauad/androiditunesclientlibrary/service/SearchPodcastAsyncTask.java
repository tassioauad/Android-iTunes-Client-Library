package com.tassioauad.androiditunesclientlibrary.service;

import android.os.AsyncTask;

import com.tassioauad.androiditunesclientlibrary.core.OnApiResultListener;
import com.tassioauad.androiditunesclientlibrary.service.entity.PodcastEntity;
import com.tassioauad.androiditunesclientlibrary.service.parameter.BasicParameter;
import com.tassioauad.androiditunesclientlibrary.service.parameter.ParameterInterface;
import com.tassioauad.androiditunesclientlibrary.service.parameter.ParametersListInterface;
import com.tassioauad.androiditunesclientlibrary.service.parameter.key.Key;
import com.tassioauad.androiditunesclientlibrary.service.parameter.value.EntityValue;
import com.tassioauad.androiditunesclientlibrary.service.utils.ItunesSearchApiUrlBuilder;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Tássio on 21/05/2014.
 */
public class SearchPodcastAsyncTask extends AsyncTask<ParametersListInterface, Void, PodcastEntity[]> {

    private OnApiResultListener listener;

    @Override
    protected PodcastEntity[] doInBackground(ParametersListInterface... parametersListInterfaces) {

        ParametersListInterface parametersListInterface = parametersListInterfaces[0];

        try {
            String url = getUrl(parametersListInterface);

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder().url(url).build();

            Response response = client.newCall(request).execute();

            String jsonResponsed = getJson((InputStreamReader) response.body().charStream());

            return new Gson().fromJson(jsonResponsed, PodcastEntity[].class);

        } catch (Exception e) {
            return new PodcastEntity[0];
        }

    }

    @Override
    protected void onPostExecute(PodcastEntity[] podcastEntries) {
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

        int indexOf = json.indexOf("[") ;
        json = json.substring(indexOf, json.length());
        json = json.substring(0, json.length()-1);

        return json;
    }

    private String getUrl(ParametersListInterface parametersListInterface) {
        boolean thereIsPodcastParameter = false;
        for(ParameterInterface parameterInterface : parametersListInterface.getList()) {
            if(parameterInterface.getKey().equals(Key.ENTITY.getValue())
                    && parameterInterface.getValue().equals(EntityValue.POSCAST.getValue())) {
                thereIsPodcastParameter = true;
            }

        }

        if(!thereIsPodcastParameter) {
            parametersListInterface.add(new BasicParameter(EntityValue.POSCAST));
        }

        return ItunesSearchApiUrlBuilder.build(parametersListInterface);
    }
}
