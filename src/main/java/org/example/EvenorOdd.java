package org.example;

import java.util.Scanner;

public class EvenorOdd {
    public static void main(String[] args) {
        System.out.print("Enter the Numebr:-");
        Scanner suraj = new Scanner(System.in);
        int number = suraj.nextInt();

        if(number % 2 == 0){
            System.out.println("The number is Even");
        }
        else {
            System.out.println("The number is odd" );
        }
    }
}
