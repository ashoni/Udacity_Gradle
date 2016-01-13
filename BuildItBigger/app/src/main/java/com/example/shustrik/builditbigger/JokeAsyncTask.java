package com.example.shustrik.builditbigger;


import android.os.AsyncTask;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.Log;

import com.example.shustrik.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;


public class JokeAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private JokeProcessor jokeProcessor;
    private ContentLoadingProgressBar progressBar;

    public JokeAsyncTask(ContentLoadingProgressBar progressBar, JokeProcessor jokeProcessor) {
        this.progressBar = progressBar;
        this.jokeProcessor = jokeProcessor;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://192.168.0.103:8080/_ah/api/")
                    .setApplicationName("CrazyDiamond")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            jokeProcessor.onJokeFailed();
            Log.e("ANNA", "Can't get joke:" + e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPreExecute() {
        progressBar.show();
    }

    @Override
    protected void onPostExecute(String result) {
        progressBar.hide();
        if (result != null) {
            jokeProcessor.onJokeReady(result);
        }
    }
}