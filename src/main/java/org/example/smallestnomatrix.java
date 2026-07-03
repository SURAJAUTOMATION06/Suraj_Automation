package org.example;

public class smallestnomatrix {

    public static void main(String[] args) {

        int[][] a = {{10,8,19},{5,6,52},{8,9,11}};
        int min = a[0][0];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++ ){

                if(a[i][j]<min){
                   min = a[i][j];
               }
            }
        }
        System.out.println(min);

    }
}



/* Find the Maximum number out of an Array */