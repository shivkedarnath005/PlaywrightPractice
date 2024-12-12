package Debugging;

import java.util.Scanner;

public class NumAddition
{
    public static void main(String[] args)
    {
        int a, b;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter value of a : ");
        a = sc.nextInt();

        System.out.println("Enter value of b : ");
        b = sc.nextInt();

        int result = a + b;

        System.out.println(a + " + " + b + " = " + result);

        System.out.println("Addition of two numbers : " + result);

    }
}
