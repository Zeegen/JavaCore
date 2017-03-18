package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
CRUD 2
*/

public class Solution2 {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args1) {
        //start here - начни тут
String ds = "-u 0 Миронов м 15/01/1990 1 Миронова ж 25/09/1997";
    //    String ds = "-i 0 1";
String[] args = ds.split(" ");
        String re = "";
        for (String s : args) re = re + s + " ";
        Pattern pattern = Pattern.compile("[а—яА-я]+\\s[а—яА-я]+\\s\\d+\\/\\d+\\/\\d++");
        Pattern pattern2 = Pattern.compile("\\d+\\s[а—яА-я]+\\s[а—яА-я]+\\s\\d+\\/\\d+\\/\\d++");
        Matcher matcher = pattern.matcher(re);
        Matcher matcher2 = pattern.matcher(re);
        switch (args[0]) {
            case "-c":
                while (matcher.find()) {
                    crud2(matcher.group().split(" "), args[0], null);
                }
                break;
            case "-u":
                while (matcher2.find()) {
                    crud2(matcher2.group().split(" "), args[0], matcher2.start());
                }
                break;
            case "-d":
                for (int i = 1; i < args.length; i++){
                    crud2(null, args[0], Integer.parseInt(args[i]));
                }
                break;
            case "-i":
                for (int i = 1; i < args.length; i++){
                    crud2(null, args[0], Integer.parseInt(args[i]));
                }
                break;
        }
        for (Person d: allPeople
             ) {System.out.println(d.getName().toString() + " " + d.getSex().toString() + " " + d.getBirthDay());

        }
    }

    public static void crud2(String[] asd, String a, Integer b) {

        Person tmp;
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("d/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat outDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        switch (a) {
            case "-c":
                try {
                    if (asd[1].contains("м")) {
                        allPeople.add(Person.createMale(asd[0], inputDateFormat.parse(asd[2])));
                    } else {
                        allPeople.add(Person.createFemale(asd[0], inputDateFormat.parse(asd[2])));
                    }
                } catch (ParseException e) {
                }
                System.out.println((allPeople.size() - 1));
                break;
            case "-u":
                tmp = allPeople.get(b);
                tmp.setName(asd[0]);
                tmp.setSex((asd[1].equals("м")) ? Sex.MALE : Sex.FEMALE);
                try {
                    tmp.setBirthDay(inputDateFormat.parse(asd[2]));
                } catch (ParseException e) {
                }
                allPeople.set(b, tmp);
                break;
            case "-d":
                tmp = allPeople.get(b);
                tmp.setName(null);
                tmp.setSex(null);
                tmp.setBirthDay(null);
                allPeople.set(b, tmp);
                break;
            case "-i":
                tmp = allPeople.get(b);
                System.out.println(tmp.getName()
                        + " "
                        + ((tmp.getSex().equals(Sex.MALE)) ? "м " : "ж ")
                        + outDateFormat.format(tmp.getBirthDay()));
                break;
        }

    }
}
