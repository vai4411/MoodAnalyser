package com.bl.demo;

public class MoodAnalyser {
    private String mood;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String mood) {
        this.mood = mood;
    }

    public static String analyseMood(String mood) {
            if (mood.contains("Sad"))
                return "Sad";
            else
                return "Happy";
    }

    public String analyseMood() {
        return analyseMood(this.mood);
    }
}
