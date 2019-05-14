package com.ksu.lunmijo.guitartuner.threads;

import com.ksu.lunmijo.guitartuner.detection.FFT.Complex;

public class CommonInformationForThreads {

    private static volatile float[] bytes;

    private static volatile Complex[] complexArray;

    private static volatile double frequency;

    public static float[] getBytes() {
        return bytes;
    }

    public static void setBytes(float[] array) {
        bytes = array;
    }

    public static Complex[] getComplexArray() {
        return complexArray;
    }

    public static void setComplexArray(Complex[] array) {
        complexArray = array;
    }

    public static double getFrequency() {
        return frequency;
    }

    public static void setFrequency(double freq) {
        frequency = freq;
    }

}
