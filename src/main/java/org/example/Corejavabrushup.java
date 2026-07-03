package org.example;

import java.util.ArrayList;

public class Corejavabrushup {
    public static void main(String[] args) {
        int suraj = 11; //Integer datatype
        String surajstring = "suraj";// String datatype store the particular string
        char surajchar = 'c'; // char is for the one single character to store ('') in the inverted comma
        double dec = 1.19;// Decimal is for the decimal value if the value is stored in the point value
        boolean surajboolean = true;// Boolean is for the True and false


        System.out.println(suraj +  " is the value stored in the");
        System.out.println(surajstring);

//         Arrays in java
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 5;
        System.out.println(array[1]);

        int [] arr2 = {1,2,3,4,5,4,5};
        System.out.println(arr2.length);

        //for loop
        for (int i = 0; i< array.length; i++)
        {
            System.out.println(array[i]);
        }
        String[] surajstrings = {"suraj", "suraj2"};
        for(int i = 0; i<surajstrings.length; i++)
        {
            System.out.println(surajstrings[i]);
        }

        // Enhanced for loop
        for( String s: surajstrings){
            System.out.println(s);
        }
        ArrayList<String> al = new ArrayList<String>();
        al.add("suraj");
        al.add("karm");
        al.add("kam's");
//        al.remove(2);
        al.get(2);
        System.out.println(al.get(0));
        System.out.println(al.get(1));
        System.out.println(al.get(2));
    }
}
