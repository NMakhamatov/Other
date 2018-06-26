package ru.tsconsulting;


import java.util.Arrays;
import java.util.Random;

public class B {
    public static void main(String[] args) {
        Random random = new Random();

        int[] a = new int[10];

        for (int i = 0; i < 10; i++) {
            a[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(a) + "\n");
        bubble(a);
        System.out.println(Arrays.toString(a));
    }
     static void bubble(int[] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0;j < x.length - 1 -i ; j++) {
                if (x[j] > x[j+1]) {
                x[j] = x[j] ^ x[j+1];
                x[j + 1] = x[j] ^ x[j+1];
                x[j] = x[j] ^ x[j+1];
                }
            }

        }
    }
}
