package org.example;

public class add {
    public static void main(String[] args) {
        char ch = 'a';
        for(int i = 0 ; i<5;i++){
            // spacing
            for(int j = 5-i ; j >=0; j--){
                System.out.print(" ");
            }
            for(int j = 0; j<=i; j++){
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
