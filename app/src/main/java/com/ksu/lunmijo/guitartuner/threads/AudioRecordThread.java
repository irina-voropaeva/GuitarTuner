package com.ksu.lunmijo.guitartuner.threads;

import android.app.Activity;

import com.ksu.lunmijo.guitartuner.MainActivity;
import com.ksu.lunmijo.guitartuner.audiorecorder.AndroidAudioConfig;
import com.ksu.lunmijo.guitartuner.audiorecorder.AndroidAudioRecorder;
import com.ksu.lunmijo.guitartuner.audiorecorder.converter.PCMArrayConverter;


public class AudioRecordThread implements Runnable {

    Activity activity;

    public AudioRecordThread(Activity activity) {
        this.activity = activity;
    }

    public void run() {
            AndroidAudioRecorder audioRecorder = new AndroidAudioRecorder(new AndroidAudioConfig(), new PCMArrayConverter());
            audioRecorder.startRecording();
            MainActivity.commonInformationForThreads.setBytes(audioRecorder.readNext());

    }
}
