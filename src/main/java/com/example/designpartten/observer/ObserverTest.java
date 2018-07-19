package com.example.designpartten.observer;

import java.lang.reflect.Method;

/**
 * Created by James on 2018/7/19.
 */
public class ObserverTest {
    public static void main(String[] args) {
        try {
            Observer observer = new Observer();
            Method advice = Observer.class.getMethod("advice",new Class<?>[]{Event.class});

            Subject subject = new Subject();
            //subject.addLisener(SubjectEventType.ON_ADD,observer,advice);

            subject.add();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
