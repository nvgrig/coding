package com.nvgrig.coding.ya;

import java.util.Scanner;

public class Equation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        if (a == 0) {
            System.out.println("MANY SOLUTIONS");
        } else if (c < 0) {
            System.out.println("NO SOLUTION");
        } else if ((c * c - b) % a != 0) {
            System.out.println("NO SOLUTION");
        } else {
            System.out.println((c * c - b) / a);
        }
    }
}
