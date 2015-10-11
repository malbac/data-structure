package Test;

import data.Osoba;
import data.RBTree.Node;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Created by Malbac on 11.10.2015.
 */
public class Reflection {
    public static void main (String[] args){
        Field[] fields = Osoba.class.getDeclaredFields();
//        for(Field f: fields){
//            f.setAccessible(true);
//        }

        for(Field f: fields){
            f.setAccessible(true);
            System.out.println(f + "  " + f.getType());
        }

        if (fields[0].getName().equals("rodneCislo")){

            System.out.println("kss");
        }

    }
}
