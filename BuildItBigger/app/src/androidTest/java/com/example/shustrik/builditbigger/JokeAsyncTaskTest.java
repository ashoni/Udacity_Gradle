package com.example.shustrik.builditbigger;

import android.os.ConditionVariable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.test.AndroidTestCase;
import android.util.Log;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class JokeAsyncTaskTest extends AndroidTestCase implements JokeProcessor {
    private JokeAsyncTask jokeAsyncTask;
    private ConditionVariable monitor;


    @Override
    public void setUp() throws Exception {
        super.setUp();
        jokeAsyncTask = new JokeAsyncTask(new ContentLoadingProgressBar(getContext()), this);
        monitor = new ConditionVariable();
    }

    public void testJokeAsyncTask() {
        jokeAsyncTask.execute();
        monitor.block();
    }

    @Override
    public void onJokeReady(String joke) {
        Log.i("JOKETEST", joke);
        assertNotNull(joke);
        assertTrue(joke.length() > 0);
        monitor.open();
    }

    @Override
    public void onJokeFailed() {
        fail();
        monitor.open();
    }
}