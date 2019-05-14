package com.ksu.lunmijo.guitartuner.threads;

import com.ksu.lunmijo.guitartuner.detection.FFT.Complex;
import com.ksu.lunmijo.guitartuner.detection.FFT.FFT;

public class AnalyzerThread implements Runnable {

    public void run() {
            Complex[] complexArray = this.makeComplexArray();

            CommonInformationForThreads.setComplexArray(FFT.fft(complexArray));

            double[] frequencies = this.makeFrequenciesArray(CommonInformationForThreads.getComplexArray());

            CommonInformationForThreads.setFrequency(this.maxFrequency(frequencies));

    }

    private Complex[] makeComplexArray() {

        int byteArrayLength = CommonInformationForThreads.getBytes().length;
        Complex[] complexArray = new Complex[byteArrayLength];

        for (int i = 0; i < byteArrayLength; i++) {
            complexArray[i] = new Complex(CommonInformationForThreads.getBytes()[i], 0);
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
