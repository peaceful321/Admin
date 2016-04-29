package com.java.framework.data_structure.adt;

/**
 * Created by Ryan Xu on 2016/4/29.
 */
public class MyString implements IMyString {

    private char[] array;

    /**
     * Constructor
     */
    public MyString() {
        array = new char[0];
    }

    /**
     * Constructor
     * @param that
     */
    public MyString(char[] that) {
        this.array = new char[that.length];
        for (int i = 0; i < that.length; i++) {
            array[i] = that[i];
        }
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int i) {
        if (i < 0 || i >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        return array[i];
    }

    @Override
    public boolean equals(IMyString that) {
        MyString other = (MyString) that;
        if (array.length != other.length()) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != other.array[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public IMyString substring(int i, int j) {
        if (i < 0 || j >= array.length || j < 0 || j >= array.length || i > j) {
            throw new IndexOutOfBoundsException();
        }
        int len = j - i;
        char[] newArray = new char[len];
        for (int t = 0; t < len; t++) {
            newArray[t] = array[i + t];
        }
        return new MyString(newArray);
    }

    @Override
    public IMyString concat(IMyString that) {
        MyString other = (MyString) that;
        int len = array.length + other.length();
        char[] newArray = new char[len];
        int i = 0, j = 0;
        while(j < array.length) {
            newArray[i++] = array[j++];
        }
        j = 0;
        while(j < other.length()) {
            newArray[i++] = other.array[j++];
        }
        return new MyString(newArray);
    }

    public String toString() {
        return new String(array);
    }
}
