package org.example;

public class MultidimensionalArray { //This is an 2-dimensional array having the 2 row and the Three Column
    public static void main(String[] args) {

        int[][] a = new int[2][3];
        a[0][0] = 2;
        a[0][1] = 4;
        a[0][2] = 6;
        a[1][0] = 8;
        a[1][1] = 10;
        a[1][2] = 12;


        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j]);
            }
        }
    }
}
