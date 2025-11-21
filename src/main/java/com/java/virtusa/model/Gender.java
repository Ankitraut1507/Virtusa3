package com.java.virtusa.model;

public enum Gender {
    MALE, FEMALE;

    public static Gender fromString(String s) {
        if (s == null) return null;
        s = s.trim().toUpperCase();
        try {
            return Gender.valueOf(s);
        } catch (IllegalArgumentException ex) {
            // try to map common variations
            if (s.startsWith("M")) return MALE;
            if (s.startsWith("F")) return FEMALE;
            return null;
        }
    }
}
