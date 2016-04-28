package com.java.framework.design_mode.observer.pattern;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ryan Xu on 2016/4/24.
 */
public abstract class Subject {

    private List<Observer> observers = new LinkedList<Observer>();

    /**
     * 观察者与目标绑定
     * @param observer
     */
    public void attach(Observer observer){
        observers.add(observer);
    }

    /**
     * 观察者与目标解除绑定
     * @param observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }


    /**
     * 状态修改，通知观察者更新
     */
    public void notification() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    protected abstract String getSubjectName();

    protected  abstract String getSubjectState();


}
