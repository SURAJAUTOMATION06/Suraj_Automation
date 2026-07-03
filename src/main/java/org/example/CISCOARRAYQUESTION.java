package org.example;

public class CISCOARRAYQUESTION {
    public static void main(String[] args) {
        /* Find the Maximum and the minimum number from the Array column or a Row*/
        int[][] array = {{2,4,5},{3,0,7},{1,8,9}};
        int min = array[0][0];
        int mincolumn = 0;

        for(int i = 0;i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                    mincolumn = j;
                }

            }
        }
        int max = array[0][mincolumn];
        int k = 0;
        while(k < array.length ){
            if(array[k][mincolumn] > max ){
                max = array[k][mincolumn];

            }
            k++;
        }
        System.out.println(max);
        //System.out.println(min);
    }
}
