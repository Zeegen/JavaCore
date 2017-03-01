package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new T1());
        threads.add(new T2());
        threads.add(new T3());
        threads.add(new T4());
        threads.add(new T5());
    }

    public static void main(String[] args) {

    }

    static class T1 extends Thread {
        @Override
        public void run() {
            while (true) {}
        }
    }
    static class T2 extends Thread {
        @Override
        public void run() {
            if (Thread.interrupted()) System.out.println("InterruptedException");
        }
    }
    static class T3 extends Thread {
        @Override
        public void run() {
            while (true) {

                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class T4 extends Thread implements Message{

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }
    static class T5 extends Thread {
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            int summy = 0;
            try {
                while (!(line = reader.readLine()).equals("N")) {summy =  summy + Integer.parseInt(line);}
                System.out.println(summy);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}