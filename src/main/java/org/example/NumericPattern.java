package org.example;

public class NumericPattern {
    public static void main(String[] args) {
        int k = 1;
        for(int i = 1; i < 5; i++){
            for(int j = 1; j <= 5 - i ; j++){
                System.out.print(k);
                k++;
                System.out.print("\t");

            }
            System.out.println();
        }
    }
}
