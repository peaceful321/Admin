package com.java.framework.design_mode.observer.pattern;

/**
 * Created by Ryan Xu on 2016/4/24.
 */
public class ConcreteSubject extends Subject {

    private String subjectName;
    private String subjectState;

    /**
     * 构造方法
     * @param subjectName
     */
    public ConcreteSubject(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * 当目标状态更新时，通知观察者
     * @param subjectState
     */
    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        this.notification();//通知
    }

    @Override
    protected String getSubjectName() {
        return this.subjectName;
    }

    @Override
    protected String getSubjectState() {
        return subjectState;
    }

}
