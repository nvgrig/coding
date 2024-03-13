package com.nvgrig.coding.ya;

import java.util.Scanner;

public class MinRectangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLinesCol = Integer.parseInt(scanner.nextLine());
        int[] allXs = new int[inputLinesCol];
        int[] allYs = new int[inputLinesCol];
        for (int i = 0; i < inputLinesCol; i++) {
            String[] inputs = scanner.nextLine().split(" ");
            allXs[i] = Integer.parseInt(inputs[0]);
            allYs[i] = Integer.parseInt(inputs[1]);
        }
        int[] minMaxX = getMinMax(allXs);
        int[] minMaxY = getMinMax(allYs);
        System.out.println(minMaxX[0] + " " + minMaxY[0] + " " + minMaxX[1] + " " + minMaxY[1]);
    }

    private static int[] getMinMax(int[] ints) {
        if (ints.length == 1) {
            return new int[]{ints[0], ints[0]};
        }
        int minOrMaxLength = ints.length % 2 == 0 ? ints.length / 2 : ints.length / 2 + 1;
        int[] mins = new int[minOrMaxLength];
        int[] maxs = new int[minOrMaxLength];
        int index = 0;
        for (int i = 0; i < ints.length; i += 2) {
            if (i + 1 == ints.length) {
                mins[index] = ints[i];
                maxs[index] = ints[i];
            } else {
                if (ints[i] > ints[i + 1]) {
                    maxs[index] = ints[i];
                    mins[index] = ints[i + 1];
                    index++;
                } else {
                    maxs[index] = ints[i + 1];
                    mins[index] = ints[i];
                    index++;
                }
            }
        }
        int[] minMax = new int[2];
        minMax[0] = mins[0];
        minMax[1] = maxs[0];
        for (int i = 1; i < mins.length; i++) {
            if (mins[i] < minMax[0]) {
                minMax[0] = mins[i];
            }
            if (maxs[i] > minMax[1]) {
                minMax[1] = maxs[i];
            }
        }
        return minMax;
    }
}
