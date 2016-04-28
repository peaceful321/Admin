package com.java.framework.design_mode.observer.pattern;

/**
 * Created by Ryan Xu on 2016/4/24.
 */
public class ConcreteObserver implements Observer {

    private String observerName;

    public ConcreteObserver(String observerName) {
        this.observerName = observerName;
    }


    @Override
    public void update(Subject subject) {
        System.out.println("我叫：" + observerName + ", 目标：" + subject.getSubjectName() + "状态改变为：" +
                subject.getSubjectState() + "，所以我也要执行更新操作");
    }

    public String getObserverName() {
        return observerName;
    }

}
