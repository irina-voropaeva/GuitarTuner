package com.ksu.lunmijo.guitartuner.threads;

import com.ksu.lunmijo.guitartuner.detection.FFT.Complex;

public class CommonInformationForThreads {

    private volatile float[] bytes;

    private volatile Complex[] complexArray;

    private volatile double frequency;

    private volatile String noteName = "C";

    public float[] getBytes() {
        return bytes;
    }

    public void setBytes(float[] array) {
        this.bytes = array;
    }

    public Complex[] getComplexArray() {
        return this.complexArray;
    }

    public void setComplexArray(Complex[] array) {
        this.complexArray = array;
    }

    public double getFrequency() {
        return this.frequency;
    }

    public void setFrequency(double freq) {
        this.frequency = freq;
    }

    public String getNoteName() {
        return this.noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

}
