package org.example;

public class Cubicpattern {
    public static void main(String[] args) {
        int k = 10;
        for(int i = 1 ; i < 5; i++){
            for(int j = 1; j <= 3 ; j++ ){
                System.out.print(k);
                k--;
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
