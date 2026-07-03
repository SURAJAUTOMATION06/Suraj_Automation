package org.example;

public class Missingnumber {
    public static void main(String[] args){
        int[] array = {1,3,4,5,7};
        int n = 7;
        int actualsum = 0;
        for (int numb : array)
        {
           actualsum += numb;
            System.out.println("Missing number" + numb);
        }
    }
}
