package com.java.framework.design_mode.observer.pattern;

/**
 * Created by Ryan Xu on 2016/4/24.
 * 观察者
 */
public interface Observer {


    /**
     * 更新方法，与目标状态保持一致
     */
    public void update(Subject subject);
}
