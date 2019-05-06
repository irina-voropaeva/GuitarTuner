package com.ksu.lunmijo.guitartuner;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ksu.lunmijo.guitartuner.audiorecorder.config.AndroidAudioConfig;
import com.ksu.lunmijo.guitartuner.audiorecorder.converter.PCMArrayConverter;
import com.ksu.lunmijo.guitartuner.audiorecorder.recorder.AndroidAudioRecorder;
import com.ksu.lunmijo.guitartuner.audiorecorder.recorder.AudioRecorder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO},
                    123);
        }
        else {
            AudioRecorder audioRecorder = new AndroidAudioRecorder(new AndroidAudioConfig(), new PCMArrayConverter());
            audioRecorder.startRecording();
        }

    }
}
