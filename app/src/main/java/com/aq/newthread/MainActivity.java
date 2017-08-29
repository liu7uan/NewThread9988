package com.aq.newthread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text1;
    private ProgressBar pb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView) findViewById(R.id.text1);

        pb1 = (ProgressBar) findViewById(R.id.pb1);

        Button bt1 = (Button) findViewById(R.id.btn1);
        bt1.setOnClickListener(new bt1OnclickListener());

    }

    private class bt1OnclickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            new MyThread().start();
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
/*
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            text1.setText("SubMessage");
*/
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pb1.setProgress(pb1.getProgress() + 1);
            }

        }
    }

}
