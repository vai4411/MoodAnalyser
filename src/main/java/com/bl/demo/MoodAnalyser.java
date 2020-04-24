package com.bl.demo;

import com.bl.demo.exception.ExceptionClass;
import com.bl.demo.exception.MoodAnalyserException;

public class MoodAnalyser {
    private String mood;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String mood) {
        this.mood = mood;
    }

    public static String analyseMood(String mood) throws MoodAnalyserException {
        try {
            if (mood.contains("Sad"))
                return "Sad";
            else if (mood.equals(""))
                throw new MoodAnalyserException(ExceptionClass.EmptyException.getException());
            else
                return "Happy";
        }catch (NullPointerException e) {
            throw new MoodAnalyserException(ExceptionClass.NullException.getException());
        }
    }

    public String analyseMood() throws MoodAnalyserException {
        return analyseMood(this.mood);
    }
}
