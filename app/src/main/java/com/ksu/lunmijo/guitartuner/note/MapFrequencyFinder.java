package com.ksu.lunmijo.guitartuner.note;

import java.util.HashMap;
import java.util.Map;


public class MapFrequencyFinder {

    private final Map<NoteName, double[]> notes = new HashMap<>();

    public MapFrequencyFinder() {
        notes.put(NoteName.A, new double[]{110.0, 220.0, 440.0});
        notes.put(NoteName.A_SHARP, new double[]{116.5, 233.0, 466.0});
        notes.put(NoteName.B, new double[]{123.5, 247.0, 494.0});
        notes.put(NoteName.C, new double[]{130.8, 261.6, 523.2});
        notes.put(NoteName.C_SHARP, new double[]{138.6, 277.2, 544.4});
        notes.put(NoteName.D, new double[]{146.8, 293.6, 587.2});
        notes.put(NoteName.D_SHARP, new double[]{155.6, 311.2, 622.4});
        notes.put(NoteName.E, new double[]{164.8, 329.6, 659.2});
        notes.put(NoteName.F, new double[]{174.6, 349.2, 698.4});
        notes.put(NoteName.F_SHARP, new double[]{185.0, 370.0, 740.0});
        notes.put(NoteName.G, new double[]{196.0, 392.0, 784.0});
        notes.put(NoteName.G_SHARP, new double[]{207.6, 415.2, 830.4});
        notes.put(NoteName.UNDEFINED, new double[]{0.0});
    }

    public double[] getFrequency(NoteName name) {
        return notes.get(name);
    }
}
