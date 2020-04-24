package com.bl.demo;

import com.bl.demo.exception.MoodAnalyserException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    private MoodAnalyser analyser;

    @Test
    public void givenMood_WhenSadMessage_ShouldReturnSad() throws MoodAnalyserException {
        analyser = new MoodAnalyser();
        Assert.assertEquals("Sad",analyser.analyseMood("I Am In Sad Mood"));
    }

    @Test
    public void givenMood_WhenAnyMessage_ShouldReturnHappy() throws MoodAnalyserException {
        analyser = new MoodAnalyser();
        Assert.assertEquals("Happy",analyser.analyseMood("I Am In Any Mood"));
    }

    @Test
    public void givenMood_WhenSadMessageConstructor_ShouldReturnSad() throws MoodAnalyserException {
        analyser = new MoodAnalyser("I Am In Sad Mood");
        Assert.assertEquals("Sad",analyser.analyseMood());
    }

    @Test
    public void givenMood_WhenAnyMessageConstructor_ShouldReturnHappy() throws MoodAnalyserException {
        analyser = new MoodAnalyser("I Am In Any Mood");
        Assert.assertEquals("Happy",analyser.analyseMood());
    }

    @Test
    public void givenMood_WhenNullMessage_ShouldReturnReturnHappy() {
        try {
            analyser = new MoodAnalyser(null);
            analyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("Null Parameter Is Passed",e.getMessage());
        }
    }

    @Test
    public void givenMood_WhenEmptyMessage_ShouldReturnReturnHappy() {
        try {
            analyser = new MoodAnalyser("");
            analyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("Empty Parameter Is Passed",e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyseClass_WhenProper_ShouldReturnObject() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = MoodAnalysisFactory.createMoodAnalyser("I am In Happy Mood");
        Assert.assertEquals(moodAnalyser.analyseMood(), MoodAnalyser.analyseMood("I am In Happy Mood"));
    }
}
