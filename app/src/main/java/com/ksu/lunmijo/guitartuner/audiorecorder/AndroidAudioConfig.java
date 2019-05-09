package com.ksu.lunmijo.guitartuner.audiorecorder;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;
import android.os.Build;

public class AndroidAudioConfig {

    private static final int AUDIO_SAMPLE_RATE = 44100;

    // Input Values
    private static final int AUDIO_RECORD_CHANNEL_CONFIG = AudioFormat.CHANNEL_IN_DEFAULT;
    private static final int AUDIO_RECORD_AUDIO_FORMAT = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? AudioFormat.ENCODING_PCM_FLOAT : AudioFormat.ENCODING_PCM_16BIT;
    private static final int AUDIO_RECORD_BUFFER_SIZE = AudioRecord.getMinBufferSize(AUDIO_SAMPLE_RATE,
            AUDIO_RECORD_CHANNEL_CONFIG, AUDIO_RECORD_AUDIO_FORMAT);
    private static final int AUDIO_RECORD_READ_SIZE = AUDIO_RECORD_BUFFER_SIZE / 4;
    private static final int AUDIO_RECORD_AUDIO_SOURCE = MediaRecorder.AudioSource.DEFAULT;

    // Output Values
    // Note, for some reason this only seems to work with stereo
    private static final int AUDIO_PLAYER_CHANNEL_CONFIG = AudioFormat.CHANNEL_OUT_STEREO;
    private static final int AUDIO_PLAYER_AUDIO_FORMAT = AudioFormat.ENCODING_PCM_FLOAT;
    // Note, this should probably be four (for 32-bit float) but it doesn't seem to work with that.
    private static final int AUDIO_PLAYER_AUDIO_FORMAT_BYTE_COUNT = 2;
    private static final int AUDIO_PLAYER_BUFFER_SIZE = AudioTrack.getMinBufferSize(AUDIO_SAMPLE_RATE,
            AUDIO_PLAYER_CHANNEL_CONFIG, AUDIO_PLAYER_AUDIO_FORMAT);
    private static final int AUDIO_PLAYER_WRITE_SIZE = AUDIO_PLAYER_BUFFER_SIZE / 4;

    public AndroidAudioConfig() {
        // Default constructor
    }

    public int getSampleRate() {
        return AUDIO_SAMPLE_RATE;
    }

    public int getInputBufferSize() {
        return AUDIO_RECORD_BUFFER_SIZE;
    }

    public int getOutputBufferSize() {
        return AUDIO_PLAYER_BUFFER_SIZE;
    }

    public int getReadSize() {
        return AUDIO_RECORD_READ_SIZE;
    }

    public int getWriteSize() {
        return AUDIO_PLAYER_WRITE_SIZE;
    }

    public int getInputChannel() {
        return AUDIO_RECORD_CHANNEL_CONFIG;
    }

    public int getOutputChannel() {
        return AUDIO_PLAYER_CHANNEL_CONFIG;
    }

    public int getInputFormat() {
        return AUDIO_RECORD_AUDIO_FORMAT;
    }

    public int getOutputFormat() {
        return AUDIO_PLAYER_AUDIO_FORMAT;
    }

    public int getOutputFormatByteCount() {
        return AUDIO_PLAYER_AUDIO_FORMAT_BYTE_COUNT;
    }

    public int getInputSource() {
        return AUDIO_RECORD_AUDIO_SOURCE;
    }
}