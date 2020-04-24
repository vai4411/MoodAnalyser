package com.bl.demo;

public class MoodAnalyser {
    private String mood;

    public static String analyseMood(String mood) {
            if (mood.contains("Sad"))
                return "Sad";
            else
                return "Happy";
        }
    }
}
