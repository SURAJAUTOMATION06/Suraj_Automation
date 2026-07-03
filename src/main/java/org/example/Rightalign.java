package org.example;

public class Rightalign {
    public static void main(String[] args)
    {
        int i, j, row = 5;
        for (i = 1; i <= row; i++)
        {
            for (j = 1; j <= i; j++)
            {
                System.out.println("*");
            }
            System.out.println();
        }

    }
}