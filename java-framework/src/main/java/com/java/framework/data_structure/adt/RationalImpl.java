package com.java.framework.data_structure.adt;

/**
 * 有理数Rational规格说明的具体实现
 * Created by Ryan Xu on 2016/4/30.
 */
public class RationalImpl implements Rational {

    private int numerator;//分子
    private int denominator;//分母

    /**
     * 构造方法
     *
     * @param numerator
     * @param denominator
     */
    public RationalImpl(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("分母不能为0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public double addition(Rational rational) {
        RationalImpl other = (RationalImpl) rational;
//        other = trans(other);
        double result = (double) (numerator * other.denominator + denominator * other.numerator) / (denominator * other.denominator);
        return result;
    }

    @Override
    public double subtraction(Rational rational) {
        RationalImpl other = (RationalImpl) rational;
        double result = (double) (numerator * other.denominator - denominator * other.numerator) / denominator * other.denominator;
        return result;
    }

    @Override
    public double multiplication(Rational rational) {
        RationalImpl other = (RationalImpl) rational;
        double result = (double) (numerator * other.numerator) / (denominator * other.denominator);
        return result;
    }

    @Override
    public double division(Rational rational) {
        RationalImpl other = (RationalImpl) rational;
        if (other.numerator == 0) {
            throw new ArithmeticException("不能除以0");
        }
        double result = (double) (numerator * other.denominator) / (denominator * other.numerator);
        return result;
    }

    @Override
    public boolean equals(Rational rational) {
        RationalImpl other = (RationalImpl) rational;
        if (numerator == 0 && other.numerator == 0) {
            return true;
        } else {
            other = trans(other);
            if (numerator == other.numerator && denominator == other.denominator) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Rational rational) {
        RationalImpl other = (RationalImpl) rational;
        if (numerator == 0 && other.numerator == 0) {
            return 0;
        } else {
            other = trans(other);
            if (numerator == other.numerator) {
                return 0;
            } else if (numerator > other.numerator) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        int commonDivisor = this.getCommonDivisor(this.numerator, this.denominator);
        return (this.numerator/commonDivisor) + "/" + (this.denominator/commonDivisor);
    }

    /**
     * 通分,将两个分数转换成相同分母的两个分数
     * @param rational
     * @return
     */
    private RationalImpl trans(RationalImpl rational) {
        int denominator = this.denominator;
        this.numerator = this.numerator * rational.denominator;
        this.denominator = this.denominator * rational.denominator;
        rational.numerator = rational.numerator * denominator;
        rational.denominator = rational.denominator * denominator;
        return rational;
    }

    /**
     * 获取最大公约数
     *
     * @return
     */
    public int getCommonDivisor(int numerator, int denominator) {
        int i = 1, commDivisor = 0;
        int temp = numerator;
        if (temp < denominator){
            temp = denominator;
        }
        while (i <= temp) {
            if (numerator % i == 0 && denominator % i == 0) {
                commDivisor = i;
            }
            i++;
        }
        return commDivisor;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}
