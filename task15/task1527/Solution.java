package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = reader.readLine();
            String[] splits = line.substring(line.indexOf(63) + 1).split("&");
            String alert = null;
            for (String d : splits) {
                if (d.contains("obj")) alert = d.substring(d.indexOf(61) + 1, d.length());
                System.out.print(d.substring(0, (d.contains("=") ? d.indexOf(61) : d.length())) + " ");
            }
            System.out.println();
            if (alert != null) {
                try {
                    alert(Double.parseDouble(alert));
                } catch (Exception e) {
                    alert(alert);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
