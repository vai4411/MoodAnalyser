package com.bl.demo;

import com.bl.demo.exception.ExceptionClass;
import com.bl.demo.exception.MoodAnalyserException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public static String Invoke(Class className,String mood) throws MoodAnalyserException {
        try {
        Method method = MoodAnalyser.class.getDeclaredMethod("analyseMood",className);
        Object value = method.invoke(new MoodAnalyser(),mood);
        return (String) value;
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

  public Object reflector(String mood) throws NoSuchFieldException, IllegalAccessException, InstantiationException, MoodAnalyserException {
        MoodAnalyser obj = new MoodAnalyser();
        Field field = MoodAnalyser.class.getDeclaredField("mood");
        field.setAccessible(true);
        field.set(obj, mood);
        return obj.analyseMood();
  }
}
