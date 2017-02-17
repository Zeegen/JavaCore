package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
        printMatrix((Integer) 3,3,"8");
        printMatrix(2, (Integer) 2, "8");
        printMatrix((Integer) 2,(Integer)4,"8");
        printMatrix((double) 3, 2, "8");
        printMatrix(2, (double) 4, "8");
        printMatrix((double)2, (double)2,"8");
        printMatrix((long)5, (long)5, "8");
        printMatrix((long)4, 3, "8");

    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(Integer m, int n, String value){
        System.out.println("Заполняем объектами String2");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, Integer n, String value){
        System.out.println("Заполняем объектами String3");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(Integer m, Integer n, String value){
        System.out.println("Заполняем объектами String4");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(double m, Integer n, String value) {
        System.out.println("Заполняем объектами String5");
        printMatrix((int) m, n, (Object) value);
    }
    public static void printMatrix(int m, double n, String value) {
        System.out.println("Заполняем объектами String6");
        printMatrix(m, (int) n, (Object) value);
    }
    public static void printMatrix(double m, double n, String value) {
        System.out.println("Заполняем объектами String7");
        printMatrix((int) m, (int) n, (Object) value);
    }
    public static void printMatrix(long m, long n, String value) {
        System.out.println("Заполняем объектами String8");
        printMatrix((int) m, (int) n, (Object) value);
    }
    public static void printMatrix(long m, int n, String value) {
        System.out.println("Заполняем объектами String9");
        printMatrix((int) m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

}
