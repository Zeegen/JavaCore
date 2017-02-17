package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put((double) 23, "23");
        labels.put((double) 21, "21");
        labels.put((double) 20, "20");
        labels.put((double) 19, "19");
        labels.put((double) 18, "18");

    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
