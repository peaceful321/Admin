package com.java.framework.design_mode.observer.pattern;

/**
 * Created by Ryan Xu on 2016/4/24.
 */
public class Client {

    public static void main(String[] args) {
        //1.����Ŀ��
        ConcreteSubject subject = new ConcreteSubject("subjectOne");

        //2.�����۲���
        ConcreteObserver observer1 = new ConcreteObserver("observerOne");
        ConcreteObserver observer2 = new ConcreteObserver("observerTwo");
        ConcreteObserver observer3 = new ConcreteObserver("observerThree");

        //3.��Ŀ����۲��߰�
        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);

        //4.Ŀ��״̬���£�֪ͨ�۲���ͬ������
        subject.setSubjectState("new subject");
    }
}
