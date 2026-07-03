package org.example;

public class Whileloop {
    public static void main(String[] args) {
        // Why While loop is used ??
        //The While loop is used to Execute the code after the visibility of the Element (Instead of this we can use Implicit and the Explicit wait)
        //It is only used for the boolean value
        int i = 0;
        int j = 10;
        while(i<=10){
            System.out.println(i);
            i++; //To increment the value of i
        }
        System.out.println("********************************************");
        while (j>10){
            System.out.println(i);
            i++;
        }
    }

}
