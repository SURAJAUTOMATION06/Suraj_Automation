package org.example;

public class Corejavabrushup2 {
    public static void main(String[] args) {
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Even number
        for (int i = 0; i < array2.length; i++) {
            if (array2[i] % 2 == 0) {
                System.out.println(array2[i]);
                break;
            }
            else {
                System.out.println(array2[i] + " is the odd one");
            }
        }
    }
}
