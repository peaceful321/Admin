package com.java.framework.design_mode.observer.pattern;

/**
 * Created by Ryan Xu on 2016/4/24.
 */
public class ConcreteSubject extends Subject {

    private String subjectName;
    private String subjectState;

    /**
     * ���췽��
     * @param subjectName
     */
    public ConcreteSubject(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * ��Ŀ��״̬����ʱ��֪ͨ�۲���
     * @param subjectState
     */
    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        this.notification();//֪ͨ
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
