package com.bl.demo;

import com.bl.demo.exception.ExceptionClass;
import com.bl.demo.exception.MoodAnalyserException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalysisFactory {
    public static MoodAnalyser createMoodAnalyser(String path, String mood) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName(path);
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
            Object moodObj = moodConstructor.newInstance(mood);
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(ExceptionClass.ClassException.getException());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
