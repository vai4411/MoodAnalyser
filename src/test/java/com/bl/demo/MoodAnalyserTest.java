package com.bl.demo;

import com.bl.demo.exception.MoodAnalyserException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    private MoodAnalyser analyser;

    @Test
    public void givenMood_WhenSadMessage_ShouldReturnSad() {
        analyser = new MoodAnalyser();
        try {
            Assert.assertEquals("Sad",analyser.analyseMood(Constant.Sad.getMessage()));
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMood_WhenAnyMessage_ShouldReturnHappy() {
        analyser = new MoodAnalyser();
        try {
            Assert.assertEquals("Happy",analyser.analyseMood(Constant.Any.getMessage()));
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMood_WhenSadMessageConstructor_ShouldReturnSad() {
        analyser = new MoodAnalyser(Constant.Sad.getMessage());
        try {
            Assert.assertEquals("Sad",analyser.analyseMood());
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMood_WhenAnyMessageConstructor_ShouldReturnHappy() {
        analyser = new MoodAnalyser(Constant.Any.getMessage());
        try {
            Assert.assertEquals("Happy",analyser.analyseMood());
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMood_WhenNullMessage_ShouldReturnReturnHappy() {
        try {
            analyser = new MoodAnalyser(null);
            analyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(Constant.Null.getMessage(),e.getMessage());
        }
    }

    @Test
    public void givenMood_WhenEmptyMessage_ShouldReturnReturnHappy() {
        try {
            analyser = new MoodAnalyser("");
            analyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(Constant.Empty.getMessage(),e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyseClass_WhenProper_ShouldReturnObject() {
        MoodAnalyser moodAnalyser = null;
        try {
            moodAnalyser = MoodAnalysisFactory.createMoodAnalyser(String.class,"com.bl.demo.MoodAnalyser",Constant.Happy.getMessage());
            Assert.assertEquals(moodAnalyser.analyseMood(), MoodAnalyser.analyseMood(Constant.Happy.getMessage()));
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyseClass_WhenImproper_ShouldThrowException() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalysisFactory.createMoodAnalyser(String.class,"", Constant.Happy.getMessage());
        }catch (MoodAnalyserException e) {
            Assert.assertEquals(Constant.ClassNotFound.getMessage(), e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyseMethod_WhenImproper_ShouldReturnException() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalysisFactory.createMoodAnalyser(Integer.class, "com.bl.demo.MoodAnalyser", Constant.Happy.getMessage());
        }catch (MoodAnalyserException e) {
            Assert.assertEquals(Constant.MethodNotFound.getMessage(), e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyseClassConstructor_WhenProper_ShouldReturnObject() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = MoodAnalysisFactory.createMoodAnalyser("com.bl.demo.MoodAnalyser");
        Assert.assertEquals(moodAnalyser.analyseMood(Constant.Happy.getMessage()), MoodAnalyser.analyseMood(Constant.Happy.getMessage()));
    }

    @Test
    public void givenMoodAnalyseClassConstructor_WhenImproper_ShouldThrowException() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalysisFactory.createMoodAnalyser("");
        }catch (MoodAnalyserException e) {
            Assert.assertEquals(Constant.ClassNotFound.getMessage(), e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyseConstructorMethod_WhenImproper_ShouldReturnException() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalysisFactory.createMoodAnalyser("com.bl.demo.MoodAnalyser");
        }catch (MoodAnalyserException e) {
            Assert.assertEquals(Constant.MethodNotFound.getMessage(), e.getMessage());
        }
    }

    @Test
    public void giveMoodReflection_WhenHappyMessage_ShouldReturnHappy() throws MoodAnalyserException {
        MoodAnalysisFactory s = new MoodAnalysisFactory();
        Assert.assertEquals("Happy",s.Invoke(String.class,Constant.Happy.getMessage()));
    }

    @Test
    public void giveMoodReflection_WhenImproperMethod_ShouldThrowException() {
        try {
            MoodAnalysisFactory s = new MoodAnalysisFactory();
            s.Invoke(Integer.class,Constant.Happy.getMessage());
        }catch (MoodAnalyserException e) {
            Assert.assertEquals(Constant.MethodNotFound.getMessage(), e.getMessage());
        }
    }

    @Test
    public void giveMoodDynamically_WhenHappyMessage_ShouldReturnHappy() throws MoodAnalyserException, NoSuchFieldException, NoSuchMethodException, InstantiationException {
        MoodAnalysisFactory s = new MoodAnalysisFactory();
        Assert.assertEquals("Happy",s.reflector(Constant.Happy.getMessage()));
    }

    @Test
    public void giveMoodDynamically_WhenMessageNull_ShouldThrowException() throws NoSuchFieldException {
        try {
            MoodAnalysisFactory s = new MoodAnalysisFactory();
            s.reflector(null);
        }catch (MoodAnalyserException e) {
            Assert.assertEquals(Constant.Null.getMessage(), e.getMessage());
        }
    }

    @Test
    public void giveMoodDynamically_WhenImproperMethod_ShouldThrowException() throws NoSuchFieldException {
        try {
            MoodAnalysisFactory s = new MoodAnalysisFactory();
            s.reflector(Constant.Happy.getMessage());
        }catch (MoodAnalyserException e) {
            Assert.assertEquals(Constant.FieldNotFound.getMessage(), e.getMessage());
        }
    }
}
