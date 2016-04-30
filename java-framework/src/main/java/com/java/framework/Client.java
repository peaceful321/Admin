package com.java.framework;

import com.java.framework.data_structure.adt.ConcretePoint;
import com.java.framework.data_structure.adt.Point;
import com.java.framework.data_structure.adt.Rational;
import com.java.framework.data_structure.adt.RationalImpl;

public class Client {

    public static void  main(String[] args) {
//        System.out.println("Ryan Xu 2016/4/28");

//        Point p1 = new ConcretePoint(2,2);
//        Point p2 = new ConcretePoint(2,2);
//        double d = p1.getDistance(p2);
//        System.out.println(p1.toString() + "与" + p2.toString() + "两点间的距离为" + d);

        Rational r1 = new RationalImpl(1,2);
        Rational r2 = new RationalImpl(2,4);
        System.out.println("equals: " + r1.equals(r2));
        System.out.println("compareTo: " + r1.compareTo(r2));
        System.out.println("addition: " + r1.addition(r2));
        System.out.println("subtraction: " + r1.subtraction(r2));
        System.out.println("multiplication: " + r1.multiplication(r2));
        System.out.println("division: " + r1.division(r2));
        System.out.println("toString: " + r1.toString());

    }
}
