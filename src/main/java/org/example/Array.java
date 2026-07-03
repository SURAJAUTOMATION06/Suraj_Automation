package org.example;

public class Array {
    public static void main(String[] args) {/* A container which contains the value having the similar datatypes */



        int[] a = {1,2,3,4,5};// Array Literal
        int[] b = new int[5];// Initialized value into that array

        b[0] = 10;
        b[1] = 20;
        b[2] = 90;
        b[3] = 40;
        b[4] = 50;

        for(int i=0; i<=b.length; i++){
          System.out.println(b[i]);
      }

        System.out.println("Chnage");
    }
}
