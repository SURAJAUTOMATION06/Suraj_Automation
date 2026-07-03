package org.example;

public class DoWhileDemo {
    public static void main(String[] args) {
        //One loop execution is guaranteed
        //Without running any block of code it will first run the code inside the do and then moves to execute the code of the while
        int j = 29;
        do{
            j++;
        }while(j<30);
        System.out.println(j);
    }
}
