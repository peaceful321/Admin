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
        System.out.println("�ҽУ�" + observerName + ", Ŀ�꣺" + subject.getSubjectName() + "״̬�ı�Ϊ��" +
                subject.getSubjectState() + "��������ҲҪִ�и��²���");
    }

    public String getObserverName() {
        return observerName;
    }

}
