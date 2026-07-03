package org.example;

public class MaximumnoArray {
    public static void main(String[] args) {
        int[] a = {10,50,119,220,500,15,15};
        int max = a[0];
        for(int i=0 ; i< a.length ; i++){
            if(a[i] > max){
                max = a[i];
            }
        }
        System.out.println(max);
    }
}
