package com.javarush.task.task15.task1522;

//import com.javarush.task.task15.task1522.Planet;

/**
 * Created by dogy on 16.02.17.
 */
public class Earth implements Planet
{
    private static Earth instance;

    private Earth(){}

    public static Earth getInstance(){
        if(instance == null){
            instance = new Earth();
        }
        return instance;
    }
}
