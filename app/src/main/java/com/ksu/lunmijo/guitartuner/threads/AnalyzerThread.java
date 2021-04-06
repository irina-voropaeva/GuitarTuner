package com.ksu.lunmijo.guitartuner.threads;

import android.app.Activity;

import com.ksu.lunmijo.guitartuner.MainActivity;
import com.ksu.lunmijo.guitartuner.detection.FFT.Complex;
import com.ksu.lunmijo.guitartuner.detection.FFT.FFT;

public class AnalyzerThread extends Thread {

    Activity activity;

    public AnalyzerThread(Activity activity) {
        this.activity = activity;
    }
    public void run() {
            Complex[] complexArray = this.makeComplexArray();
        MainActivity.commonInformationForThreads.setComplexArray(FFT.fft(complexArray));

            double[] frequencies = this.makeFrequenciesArray(MainActivity.commonInformationForThreads.getComplexArray());

        MainActivity.commonInformationForThreads.setFrequency(this.maxFrequency(frequencies));

    }

    private Complex[] makeComplexArray() {

        int byteArrayLength = MainActivity.commonInformationForThreads.getBytes().length;
        Complex[] complexArray = new Complex[byteArrayLength];

        for (int i = 0; i < byteArrayLength; i++) {
            complexArray[i] = new Complex(MainActivity.commonInformationForThreads.getBytes()[i], 0);
        }

        return complexArray;
    }

    private double[] makeFrequenciesArray(Complex[] array) {
        double[] freqArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            freqArray[i] = Math.sqrt(array[i].re()*array[i].re() + array[i].im()*array[i].im());
        }

        return freqArray;
    }

    private double maxFrequency(double[] frequencies) {
        double max = frequencies[0];
        for (int i = 0; i < frequencies.length; i++) {
            if (max < frequencies[i]) {
                max = frequencies[i];
            }
        }
        return max;
    }
}
