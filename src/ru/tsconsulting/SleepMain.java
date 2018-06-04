package ru.tsconsulting;

import java.util.*;

public class SleepMain {
    public static void main(String[] args) {
        int[] a[] = new int[2][10];

        System.out.println(Arrays.deepToString(a));
    }
    static int[] reverse(int[] a) {
        for (int i = 0, len = a.length; i <= len/2; i++) {
            int t = a[i];
            a[i] = a[len-i-1];
            a[len-i-1] = t;
        }
        return a;
    }
}