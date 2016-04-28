package com.java.framework.data_structure.queue;

/**
 * Created by Ryan Xu on 2016/4/24.
 */
public interface Queue {

    /**
     * Make this queue empty
     * @author Ryan Xu
     */
    public void clear();

    /**
     * Add obj as rear element of this queue
     * @author Ryan Xu
     * @param obj
     */
    public void enqueue(Object obj);

    /**
     * Remove and return the front element of this queue
     * @author Ryan Xu
     * @return Object
     */
    public Object dedueue();


    /**
     * Return true if and only if this queue is empty
     * @author Ryan Xu
     * @return
     */
    public boolean isEmpty();


    /**
     * Return this queue's length
     * @author Ryan Xu
     * @return
     */
    public int size();


    /**
     * Return the element at the front of this queue -> 返回队首元素
     * @author Ryan Xu
     * @return
     */
    public Object peek();

}
