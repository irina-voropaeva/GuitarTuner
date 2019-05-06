package com.ksu.lunmijo.guitartuner.recorder;

import android.media.AudioRecord;
import android.os.Build;

import com.ksu.lunmijo.guitartuner.config.AudioConfig;
import com.ksu.lunmijo.guitartuner.converter.ArrayConverter;

public class AndroidAudioRecorder implements AudioRecorder {

    private final ArrayConverter converter;
    private final AudioRecord audioRecorder;
    private final int readSize;
    private final short[] buffer;
    private final float[] floatBuffer;

    public AndroidAudioRecorder(final AudioConfig audioConfig, final ArrayConverter converter) {
        this.converter = converter;
        this.audioRecorder = new AudioRecord(audioConfig.getInputSource(), audioConfig.getSampleRate(),
                audioConfig.getInputChannel(), audioConfig.getInputFormat(), audioConfig.getInputBufferSize());
        this.readSize = audioConfig.getReadSize();
        this.buffer = new short[readSize];
        this.floatBuffer = new float[readSize];
    }

    @Override
    public void startRecording() {
        audioRecorder.startRecording();
    }

    @Override
    public void stopRecording() {
        audioRecorder.stop();
    }

    @Override
    public float[] readNext() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            audioRecorder.read(floatBuffer, 0, readSize, AudioRecord.READ_BLOCKING);
        } else {
            audioRecorder.read(buffer, 0, readSize);

            converter.convert(buffer, floatBuffer);
        }
        System.out.println("Bytes: " + floatBuffer);
        return floatBuffer;
    }
}
