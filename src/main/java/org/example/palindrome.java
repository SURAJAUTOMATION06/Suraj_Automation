package org.example;

import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        System.out.print("Enter the String to Verify that it is palindrome or not:- ");
        Scanner palindrome = new Scanner(System.in);
        String name = palindrome.nextLine();
        String palindromeString = "";

        for(int i = name.length() - 1; i >= 0; i-- ){
            palindromeString = palindromeString + name.charAt(i);
        }
        if (name.equals(palindromeString)){
            System.out.println("The string is palindrome");
        }
        else System.out.println("The is not palindrome");
        palindrome.close();

    }
}
