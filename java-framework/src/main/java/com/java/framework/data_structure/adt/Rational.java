package com.java.framework.data_structure.adt;

/**
 * 有理数Rational的规格说明
 * Created by Ryan Xu on 2016/4/30.
 */
public interface Rational {

    /**
     * 加法
     * @param rational
     * @return
     */
    public double addition(Rational rational);

    /**
     * 减法
     * @param rational
     * @return
     */
    public double subtraction(Rational rational);

    /**
     * 乘法
     * @param rational
     * @return
     */
    public double multiplication(Rational rational);

    /**
     * 除法
     * @param rational
     * @return
     */
    public double division(Rational rational);

    /**
     * 判断是否相等
     * @param rational
     * @return
     */
    public boolean equals(Rational rational);

    /**
     * 比较大小
     * @param rational
     * @return
     */
    public int compareTo(Rational rational);

    /**
     * 返回对应格式的字符串
     * @return
     */
    public String toString();

}
