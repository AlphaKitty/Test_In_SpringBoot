package com.example.demo.test.test.algorithm.sort;

import java.util.Collections;
import java.util.LinkedList;

public class BubbleTest {
    public static void main(String[] args) {
        BubbleTest test = new BubbleTest();
        int[] array = {
                3, 7, 2, 2, 1, 9, 5, 0, 6
        };
        int[] sort = test.sort(array);
        for (int i : sort) {
            System.out.println(i);
        }
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        Collections.reverse(integers);
        System.out.println(integers);
    }

    private int[] sort(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
