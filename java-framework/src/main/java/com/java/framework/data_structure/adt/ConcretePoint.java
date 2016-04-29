package com.java.framework.data_structure.adt;

/**
 * Created by Ryan Xu on 2016/4/30.
 * 表示一个具体的点
 */
public class ConcretePoint implements Point {

    private double x, y;

    /**
     * 构造方法
     * @param x
     * @param y
     */
    public ConcretePoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getDistance(Point point) {
        ConcretePoint mPoint = (ConcretePoint) point;
        double result = Math.pow((x - ((ConcretePoint) point).x), 2) + Math.pow((y - ((ConcretePoint) point).y), 2);
        return Math.sqrt(result);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
