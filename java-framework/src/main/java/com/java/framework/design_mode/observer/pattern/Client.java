package com.java.framework.design_mode.observer.pattern;

/**
 * Created by Ryan Xu on 2016/4/24.
 */
public class Client {

    public static void main(String[] args) {
        //1.创建目标
        ConcreteSubject subject = new ConcreteSubject("subjectOne");

        //2.创建观察者
        ConcreteObserver observer1 = new ConcreteObserver("observerOne");
        ConcreteObserver observer2 = new ConcreteObserver("observerTwo");
        ConcreteObserver observer3 = new ConcreteObserver("observerThree");

        //3.将目标与观察者绑定
        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);

        //4.目标状态更新，通知观察者同步更新
        subject.setSubjectState("new subject");
    }
}
