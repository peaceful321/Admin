package com.java.framework.basis.exception;

/**
 * Created by Ryan Xu on 2016/4/24.
 */
public class FinallyDemo {

    public static void main(String args[]) {
        int val = testFinallyDemoOne();
        System.out.println("testFinallyDemoOne's value = " + val);

        int valTwo = testFinallyDemoTwo();
        System.out.println("testFinallyDemoTwo's value = " + valTwo);

    }


    public static int testFinallyDemoOne() {
        int a = 0;
        try{
            a = a / 0;
        } catch (Exception e) {
            return ++a;
        } finally {
            return ++a;
        }
    }

    public static int testFinallyDemoTwo() {
        int a = 0;
        try {
            a = a / 0;
        } catch (Exception e) {
            return ++a;
        } finally {
            a++;
        }
        return ++a;
    }

}
