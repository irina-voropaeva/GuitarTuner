package com.ksu.lunmijo.guitartuner.audiorecorder;

import android.media.AudioRecord;
import android.os.Build;

import com.ksu.lunmijo.guitartuner.audiorecorder.converter.ArrayConverter;

public class AndroidAudioRecorder {

    private final ArrayConverter converter;
    private final AudioRecord audioRecorder;
    private final int readSize = 4096;
    private final short[] buffer;
    private final float[] floatBuffer;

    public AndroidAudioRecorder(final AndroidAudioConfig audioConfig, final ArrayConverter converter) {
        this.converter = converter;
        this.audioRecorder = new AudioRecord(audioConfig.getInputSource(), audioConfig.getSampleRate(),
                audioConfig.getInputChannel(), audioConfig.getInputFormat(), audioConfig.getInputBufferSize());
        this.buffer = new short[readSize];
        this.floatBuffer = new float[readSize];
    }

    public void startRecording() {
        audioRecorder.startRecording();
    }

    public void stopRecording() {
        audioRecorder.stop();
    }

    public float[] readNext() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            audioRecorder.read(floatBuffer, 0, readSize, AudioRecord.READ_BLOCKING);
        } else {
            audioRecorder.read(buffer, 0, readSize);

            converter.convert(buffer, floatBuffer);
        }
        return floatBuffer;
    }
}
