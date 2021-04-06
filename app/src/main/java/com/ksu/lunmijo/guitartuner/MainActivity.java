package com.ksu.lunmijo.guitartuner;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ksu.lunmijo.guitartuner.note.MapFrequencyFinder;
import com.ksu.lunmijo.guitartuner.threads.AnalyzerThread;
import com.ksu.lunmijo.guitartuner.threads.AudioRecordThread;
import com.ksu.lunmijo.guitartuner.threads.CommonInformationForThreads;

public class MainActivity extends AppCompatActivity {

    public static CommonInformationForThreads commonInformationForThreads = new CommonInformationForThreads();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MapFrequencyFinder mapFrequencyFinder = new MapFrequencyFinder();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO},
                    123);
        } else {
            new AudioRecordThread(this).run();
            new AnalyzerThread(this).run();
            final TextView resultNote = (TextView) findViewById(R.id.findedNote);
            final TextView anotherNoteName = (TextView) findViewById(R.id.anotherNoteNames);
            final TextView recomendation = (TextView) findViewById(R.id.recomendation);
            final TextView actualFrequency = (TextView) findViewById(R.id.actualFrequency);
            final TextView expectedFrequency = (TextView) findViewById(R.id.expectedFrequency);
            resultNote.setText(commonInformationForThreads.getNoteName());

            if (commonInformationForThreads.getIsOkNote()) {
                final Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        resultNote.setText(commonInformationForThreads.getNoteName());
                        resultNote.setTextColor(Color.rgb(0, 255, 0));
                        recomendation.setText("Perfect tone");
                        recomendation.setTextColor(Color.rgb(0, 255, 0));
                        actualFrequency.setText("Recognized frequency: " + Double.toString(commonInformationForThreads.getFrequency()));
                        actualFrequency.setTextColor(Color.rgb(0, 255, 0));
                        expectedFrequency.setText("Expected frequency: " + Double.toString(commonInformationForThreads.getFrequency()));
                        expectedFrequency.setTextColor(Color.rgb(0, 255, 0));

                        handler.postDelayed(this, 500); // set time here to refresh textView

                    }
                });

            } else {
                final Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        double tone = mapFrequencyFinder.getNearestTone(commonInformationForThreads.getFrequency());
                        actualFrequency.setText("Recognized frequency: " + Double.toString(tone));
                        actualFrequency.setTextColor(Color.rgb(255, 0, 0));

                        expectedFrequency.setText("Expected frequency: " + mapFrequencyFinder.getFindedNote());
                        expectedFrequency.setTextColor(Color.rgb(255, 0, 0));

                        handler.postDelayed(this, 500); // set time here to refresh textView
                    }

                });
            }

        }
    }
}
