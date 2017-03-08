package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException {
        //start here - начни тут
        lostPeople(args);
        /*while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String testString = reader.readLine();
            if (testString.equals("")) break;
            String[] ardul = testString.split(" ");
            lostPeople(ardul);
        }*/


    }
    public static void lostPeople (String[] ardulos){
        Person tmp;
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("d/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat outDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


        switch (ardulos[0]) {
            case "-c":
                if (ardulos[2].contains("м")){
                    try {
                        allPeople.add(Person.createMale(ardulos[1], inputDateFormat.parse(ardulos[3])));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    try {
                        allPeople.add(Person.createFemale(ardulos[1], inputDateFormat.parse(ardulos[3])));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println((allPeople.size() - 1));
                break;
            case "-u":
                tmp = allPeople.get(Integer.parseInt(ardulos[1]));
                    tmp.setName(ardulos[2]);
                    tmp.setSex((ardulos[3].equals("м"))? Sex.MALE: Sex.FEMALE);
                try {
                    tmp.setBirthDay(inputDateFormat.parse(ardulos[4]));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                allPeople.set(Integer.parseInt(ardulos[1]), tmp);
                break;
            case "-d":
                tmp = allPeople.get(Integer.parseInt(ardulos[1]));
                tmp.setName(null);
                tmp.setSex(null);
                tmp.setBirthDay(null);
                allPeople.set(Integer.parseInt(ardulos[1]), tmp);
                break;
            case "-i":
                tmp = allPeople.get(Integer.parseInt(ardulos[1]));
                System.out.println(tmp.getName()
                        + " "
                        + ((tmp.getSex().equals(Sex.MALE))? "м ": "ж ")
                        + outDateFormat.format(tmp.getBirthDay()));
                break;
        }
    }
}
