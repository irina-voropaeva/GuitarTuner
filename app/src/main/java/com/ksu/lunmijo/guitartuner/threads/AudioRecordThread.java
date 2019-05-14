package com.ksu.lunmijo.guitartuner.threads;

import com.ksu.lunmijo.guitartuner.audiorecorder.AndroidAudioConfig;
import com.ksu.lunmijo.guitartuner.audiorecorder.AndroidAudioRecorder;
import com.ksu.lunmijo.guitartuner.audiorecorder.converter.PCMArrayConverter;


public class AudioRecordThread implements Runnable {

    public void run() {
            AndroidAudioRecorder audioRecorder = new AndroidAudioRecorder(new AndroidAudioConfig(), new PCMArrayConverter());
            audioRecorder.startRecording();
            CommonInformationForThreads.setBytes(audioRecorder.readNext());

    }
}
