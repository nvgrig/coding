package com.nvgrig.coding.ya;

import java.util.Scanner;

public class XAndO {

    private final static int[] dX = new int[]{-1, 0, 1, 0};
    private final static int[] dY = new int[]{0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTurns = Integer.parseInt(scanner.nextLine());
        String[] turns = new String[numOfTurns];
        for (int i = 0; i < numOfTurns; i++) {
            turns[i] = scanner.nextLine();
        }

    }
}
