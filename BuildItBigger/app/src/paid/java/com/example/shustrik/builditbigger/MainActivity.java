package com.example.shustrik.builditbigger;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.shustrik.androidlibrary.JokeActivity;


public class MainActivity extends AppCompatActivity implements JokeProcessor {

    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paid_activity_main);
    }

    public void launchJokeActivity(View view) {
        new JokeAsyncTask((ContentLoadingProgressBar) this.findViewById(R.id.progress_bar), this).execute();
    }

    @Override
    public void onJokeReady(String joke) {
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_KEY, joke);
        startActivity(intent);
    }

    @Override
    public void onJokeFailed() {
        showToast("Sorry, service is unavailable. Check connection and try again!");
    }

    private void showToast(String text) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.show();
    }
}
