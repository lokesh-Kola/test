package Exam;


import java.util.Scanner;

public class matrix{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter elements of matrix A:");
        int a11 = sc.nextInt(), a12 = sc.nextInt();
        int a21 = sc.nextInt(), a22 = sc.nextInt();
        
        System.out.println("Enter elements of matrix B:");
        int b11 = sc.nextInt(), b12 = sc.nextInt();
        int b21 = sc.nextInt(), b22 = sc.nextInt();
        
        System.out.println("Resultant Matrix C:");
        System.out.println((a11 + b11) + " " + (a12 + b12));
        System.out.println((a21 + b21) + " " + (a22 + b22));
        
        sc.close();
    }
}
