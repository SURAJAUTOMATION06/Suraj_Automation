package org.example;

import java.util.Scanner;

public class Timebasedpalindromeapproach {
    public static void main(String[] args) {
        System.out.print("Enter the String to Verify that it is palindrome or not:- ");
        Scanner palindrome = new Scanner(System.in);
        String name = palindrome.nextLine();

        int i = 0;
        int j = name.length() - 1;
        boolean isPalindrom = true;

        while (i <= j) {
            if (name.charAt(i++) != name.charAt(j--)) {
                isPalindrom = false;
                System.out.println("String is not Palindrome");
                break;
            }
        }

        if (isPalindrom) {
            System.out.println("String is Palindrome");
        }
    }
}