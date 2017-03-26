package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1

       //

    }

    public static void main(String[] args) {
        //start here - начни тут

        switch (args[0]){
            case "-c":
                synchronized (allPeople){
                inPeople(args);}
                break;
            case "-u":
                synchronized (allPeople){
                updatePeople(args);}
                break;
            case "-d":
                synchronized (allPeople){
                killPeople(args);}
                break;
            case "-i":
                synchronized (allPeople){
                infoPeople(args);}
                break;
        }

    }
    public static void inPeople (String[] args){
        SimpleDateFormat inDate = new SimpleDateFormat("d/MM/yyyy", Locale.ENGLISH);
        for (int i = 1; i < args.length; i = i + 3) {
            try {
                if (args[i + 1].contains("м")) {
                    allPeople.add(Person.createMale(args[i], inDate.parse(args[i + 2])));
                } else {
                    allPeople.add(Person.createFemale(args[i], inDate.parse(args[i + 2])));
                }
            } catch (ParseException e) {
            }
            System.out.println((allPeople.size() - 1));
        }
    }
    public static void updatePeople (String[] args){
        Person tmp;
        SimpleDateFormat inDate = new SimpleDateFormat("d/MM/yyyy", Locale.ENGLISH);
        for (int i = 1; i < args.length; i = i + 4){
            tmp = allPeople.get(Integer.parseInt(args[i]));
            tmp.setName(args[i + 1]);
            tmp.setSex((args[i + 2].equals("м")) ? Sex.MALE : Sex.FEMALE);
            try {
                tmp.setBirthDay(inDate.parse(args[i + 3]));
            } catch (ParseException e) {
            }
            allPeople.set(Integer.parseInt(args[i]), tmp);
        }

    }
    public static void killPeople (String[] args){
        Person tmp;
        for (int i = 1; i < args.length; i++){
            tmp = allPeople.get(Integer.parseInt(args[i]));
            tmp.setName(null);
            tmp.setSex(null);
            tmp.setBirthDay(null);
            allPeople.set(Integer.parseInt(args[i]), tmp);

        }
    }
    public static void infoPeople(String[] args) {
        Person tmp;
        SimpleDateFormat outDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (int i = 1; i < args.length; i++) {
            tmp = allPeople.get(Integer.parseInt(args[i]));
            System.out.println(tmp.getName()
                    + " "
                    + ((tmp.getSex().equals(Sex.MALE)) ? "м " : "ж ")
                    + outDate.format(tmp.getBirthDay()));
        }
    }
}
