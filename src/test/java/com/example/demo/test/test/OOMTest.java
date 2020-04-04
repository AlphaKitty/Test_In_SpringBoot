package com.example.demo.test.test;

import com.example.demo.test.entity.User;

import java.util.ArrayList;
import java.util.List;

public class OOMTest {
    public static void main(String[] args) throws InterruptedException {
        List<HeapOom> list = new ArrayList<>();
        while (true) {
            list.add(new HeapOom());
            Thread.sleep(10);
        }
    }
}
