package com.nvgrig.coding.ya;

import java.util.Scanner;

public class Ropes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ropesLeft = Integer.parseInt(scanner.nextLine());
        String[] ropesSizes = scanner.nextLine().split(" ");
        int sum = Integer.parseInt(ropesSizes[0]);
        int max = Integer.parseInt(ropesSizes[0]);
        for (int i = 1; i < ropesLeft; i++) {
            int currentSize = Integer.parseInt(ropesSizes[i]);
            if (currentSize > max) {
                max = currentSize;
            }
            sum += currentSize;
        }
        System.out.println(sum - max < max ? 2 * max - sum : sum);
    }
}
