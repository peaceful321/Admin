package com.java.framework.data_structure.adt;

/**
 * Created by Ryan Xu on 2016/4/29.
 */
public interface IMyString {

    /**
     * Return the length of this string.
     * @return
     */
    public int length();

    /**
     * Return the character at index i in this string
     * @param i
     * @return
     */
    public char charAt(int i);

    /**
     * Return -1 if this string is lexicographicallly less than that,
     * or 0 if this string is equal to that,
     * or +1 if this string is lexicographically greater than that.
     * @param that
     * @return
     */
    public boolean equals(IMyString that);

    /**
     * Return the substring of this string consisting of
     * the characters whose indices are i,..., j-1.
     * @param i
     * @param j
     * @return
     */
    public IMyString substring(int i, int j);

    /**
     * Return the string obtained by concatenating this string and that.
     * @param that
     * @return
     */
    public IMyString concat(IMyString that);
}
