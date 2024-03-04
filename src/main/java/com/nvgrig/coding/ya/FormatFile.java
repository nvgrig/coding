package com.nvgrig.coding.ya;

import java.util.Scanner;

public class FormatFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int strCol = scanner.nextInt();
        long pressingsCol = 0;
        for (int i = 0; i < strCol; i++) {
            long spacesCol = scanner.nextLong();
            pressingsCol += calculatePressings(spacesCol);
        }
        System.out.println(pressingsCol);
    }

    private static long calculatePressings(long spacesCol) {
        if (spacesCol == 0) {
            return 0;
        }
        if (spacesCol <= 2) {
            return spacesCol;
        }
        if (spacesCol == 3) {
            return 2;
        }
        if (spacesCol % 4 == 0) {
            return spacesCol / 4;
        }
        if (spacesCol % 4 > 0) {
            return spacesCol / 4 + calculatePressings(spacesCol % 4);
        }
        return 0;
    }
}
