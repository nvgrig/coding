package com.nvgrig.coding.tnkf;

import java.util.Scanner;

public class Exam2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(n == 1 ? 1 : n * 4 - 4);
    }

}
