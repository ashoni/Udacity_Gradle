package com.example.shustrik.androidlibrary;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by shustrik on 10.12.2015.
 */
public class JokeActivity extends ActionBarActivity {

    public static String JOKE_KEY = "OWJoke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
    }
}
