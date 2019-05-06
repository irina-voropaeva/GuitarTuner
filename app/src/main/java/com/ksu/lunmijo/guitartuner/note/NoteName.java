package com.ksu.lunmijo.guitartuner.note;

public enum NoteName {

    A("A"),
    A_SHARP("A♯"),
    B("B"),
    C("C"),
    C_SHARP("C♯"),
    D("D"),
    D_SHARP("D♯"),
    E("E"),
    F("F"),
    F_SHARP("F♯"),
    G("G"),
    G_SHARP("G♯"),
    UNDEFINED("U");

    public static NoteName forName(final String name) {
        if (name != null) {
            String updatedName = name.trim().toUpperCase().replace('#', '♯');

            try {
                for (NoteName noteName : values()) {
                    if (noteName.getName().equals(updatedName)) {
                        return noteName;
                    }
                }
            } catch (IllegalArgumentException e) {
                // No operation
            }
        }

        return UNDEFINED;
    }

    private String name;

    NoteName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

