package com.bl.demo;

import com.bl.demo.exception.ExceptionClass;
import com.bl.demo.exception.MoodAnalyserException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalysisFactory {
    private Class className;
    private String path;
    private String mood;
    public static MoodAnalyser createMoodAnalyser(Class className, String path, String mood) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName(path);
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(className);
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
            throw new MoodAnalyserException(ExceptionClass.MethodException.getException());
        }
        return null;
    }

    public static MoodAnalyser createMoodAnalyser(Class className, String path) throws MoodAnalyserException {
        return createMoodAnalyser(className,path,null);
    }
}
