package com.javarush.task.task15.task1522;


//import com.javarush.task.task15.task1522.Planet;

/**
 * Created by dogy on 16.02.17.
 */
public class Moon implements Planet
{
    private static Moon instance;

    private Moon(){}

    public static Moon getInstance(){
        if(instance == null){
            instance = new Moon();
        }
        return instance;
    }
}