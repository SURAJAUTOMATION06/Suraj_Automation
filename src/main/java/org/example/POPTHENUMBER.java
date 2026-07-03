package org.example;

import java.util.ArrayList;

public class POPTHENUMBER {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        numbers.removeLast();
        System.out.println(numbers);


    }
}
