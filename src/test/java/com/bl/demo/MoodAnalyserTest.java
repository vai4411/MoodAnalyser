package com.bl.demo;

import com.bl.demo.exception.MoodAnalyserException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

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
        MoodAnalyser moodAnalyser = MoodAnalysisFactory.createMoodAnalyser(String.class,"com.bl.demo.MoodAnalyser","I am In Happy Mood");
        Assert.assertEquals(moodAnalyser.analyseMood(), MoodAnalyser.analyseMood("I am In Happy Mood"));
    }

    @Test
    public void givenMoodAnalyseClass_WhenImproper_ShouldThrowException() throws MoodAnalyserException {
        try {
            MoodAnalyser moodAnalyser = MoodAnalysisFactory.createMoodAnalyser(String.class,"", "I am In Happy Mood");
        }catch (MoodAnalyserException e) {
            Assert.assertEquals("No Such Class Error", e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyseMethod_WhenImproper_ShouldReturnException() throws MoodAnalyserException {
        try {
            MoodAnalyser moodAnalyser = MoodAnalysisFactory.createMoodAnalyser(Integer.class, "com.bl.demo.MoodAnalyser", "I am In Happy Mood");
        }catch (MoodAnalyserException e) {
            Assert.assertEquals("No Such Method Error", e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyseClassConstructor_WhenProper_ShouldReturnObject() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = MoodAnalysisFactory.createMoodAnalyser(String.class,"com.bl.demo.MoodAnalyser");
        Assert.assertEquals(moodAnalyser.analyseMood("I am In Happy Mood"), MoodAnalyser.analyseMood("I am In Happy Mood"));
    }

    @Test
    public void givenMoodAnalyseClassConstructor_WhenImproper_ShouldThrowException() throws MoodAnalyserException {
        try {
            MoodAnalyser moodAnalyser = MoodAnalysisFactory.createMoodAnalyser(String.class,"");
        }catch (MoodAnalyserException e) {
            Assert.assertEquals("No Such Class Error", e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyseConstructorMethod_WhenImproper_ShouldReturnException() throws MoodAnalyserException {
        try {
            MoodAnalyser moodAnalyser = MoodAnalysisFactory.createMoodAnalyser(Integer.class, "com.bl.demo.MoodAnalyser");
        }catch (MoodAnalyserException e) {
            Assert.assertEquals("No Such Method Error", e.getMessage());
        }
    }

    @Test
    public void giveMoodReflection_WhenHappyMessage_ShouldReturnHappy() throws NoSuchMethodException, MoodAnalyserException, IllegalAccessException, InvocationTargetException {
        MoodAnalysisFactory s = new MoodAnalysisFactory();
        Assert.assertEquals("Happy",s.Invoke(String.class,"com.bl.demo.MoodAnalyser","I Am In Happy Mood"));
    }

    @Test
    public void giveMoodReflection_WhenImproperMethod_ShouldThrowException() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        try {
            MoodAnalysisFactory s = new MoodAnalysisFactory();
            Assert.assertEquals("Happy",s.Invoke(Integer.class,"com.bl.demo.MoodAnalyser","I Am In Happy Mood"));
        }catch (MoodAnalyserException e) {
            Assert.assertEquals("No Such Method Error", e.getMessage());
        }
    }
}
