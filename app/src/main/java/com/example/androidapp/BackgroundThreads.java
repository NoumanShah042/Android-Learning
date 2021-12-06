package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.os.Looper;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//  https://www.youtube.com/watch?v=QfQE1ayCzf8

public class BackgroundThreads extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button buttonStartThread;

    private Handler mainHandler = new Handler(); // Default constructor associates this handler with the Looper for the current thread.
    //  we use handlers to change the main UI class from the other background thread

    private volatile boolean stopThread = false;
    // volatile makes sure that all of our threads gets the most update value of that variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_threads);

        buttonStartThread = findViewById(R.id.button_start_thread);
    }

    public void startThread(View view) {
        stopThread = false;
        ExampleRunnable runnable = new ExampleRunnable(10);
        new Thread(runnable).start();


//         Simple Thread
//        ExampleThread thread = new ExampleThread(10);
//        thread.start();

        //  anonymous thread
        /*

        new Thread(new Runnable() {
            @Override
            public void run() {
                //work
            }
        }).start();
        */
    }

    public void stopThread(View view) {
        stopThread = true;
    }

    class ExampleThread extends Thread {
        int seconds;

        ExampleThread(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < seconds; i++) {
                Log.d(TAG, "startThread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class ExampleRunnable implements Runnable {
        int seconds;

        ExampleRunnable(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < seconds; i++) {
                if (stopThread) {
                    return;
                }

                //  we want to change text of button ( main UI class)  when counter value is 5
                if (i == 5) {

                    //  change main UI class using mainHandler ------------------    1st way
                    /*
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("50%");
                        }
                    });
                     */

                    //   if we create handler here we need to initialize it with MainLooper ------------------    1st way with slight variation
                    /*
                    Handler threadHandler = new Handler(Looper.getMainLooper());
                    threadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("50%");
                        }
                    });
                    */

                    //  another way to change  main UI class from the other background thread    ------------------    2nd way
                    //  just call post method of view of main thread
                    /*
                    buttonStartThread.post(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("50%");
                        }
                    });
                    */

                    //  another way is to use this method that will Runs the specified action on the UI thread.   ------------------    3rd way
                    //  runOnUiThread is the activity own method
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("50%");
                        }
                    });

                }

                Log.d(TAG, "startThread: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



/*

https://www.youtube.com/watch?v=u2fmW0FTnt8   - harry
//  paste these codes in onCreate method directly to show result

        //    run for 35 seconds and perform  task ( onTick) every given seconds
        new CountDownTimer(35000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
               //  execute this method on every tick ( 1s in this case)
                Log.d("lpg", "onTick: I am hero");

            }
            @Override
            public void onFinish() {
                Log.d("lpg", "Khatam ho gaya");

            }
        }.start();

        // Task Scheduler using Handler and Runnable
        //        final Handler handler = new Handler();
        //        Runnable run = new Runnable(){
        //            @Override
        //            public void run() {
        //                // Code to execute (  display toast continuously for every 1 seconds)
        //                number++;
        //                Toast.makeText(MainActivity.this, "This is toast " + number , Toast.LENGTH_SHORT).show();
        //                handler.postDelayed(this, 1000);
        //
        //            }
        //        };
        //        handler.post(run);

*/