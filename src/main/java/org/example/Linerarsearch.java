package org.example;

import java.util.Scanner;

public class Linerarsearch {
    public static void main(String[] args) {
        int[] array = {40,50,90,90};
        System.out.print("Enter the number to search whether it is linear or not:- ");
        Scanner scannerlinearsearch = new Scanner(System.in);
        int value = scannerlinearsearch.nextInt();
        for(int i = 0; i < array.length; i++){
            if(value == array[i]){
                System.out.println("The Linear search is found");
                break;
            }
            else{
                System.out.println("The number is not found");
            }

        }

    }
}
