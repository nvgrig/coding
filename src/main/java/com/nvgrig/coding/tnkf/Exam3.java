package com.nvgrig.coding.tnkf;

import java.util.Scanner;

public class Exam3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        long[][] matrix = new long[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            String row = sc.nextLine();
            String[] elements = row.split(" ");
            long rowSum = 0;
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Long.parseLong(elements[j]);
                rowSum += matrix[i][j];
                matrix[n][j] = matrix[n][j] + matrix[i][j];
            }
            matrix[i][n] = rowSum;
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(matrix[i][n] - matrix[n][j]) <= matrix[i][j]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
