package com.nvgrig.coding.ya;

import java.util.Scanner;

public class FishDiet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstArrrayInput = scanner.nextLine().split(" ");
        String[] secondArrayInput = scanner.nextLine().split(" ");
        int needDays = Integer.parseInt(firstArrrayInput[0]);
        int freshDays = Integer.parseInt(firstArrrayInput[1]);
        int sumMinFishCost = 0;
        int[] result = new int[needDays];
        int i = 0;
        int boughtFishes = 1;
        while (i < secondArrayInput.length) {
            int currentPrice = Integer.parseInt(secondArrayInput[i]);
            int depth = Math.min(i + freshDays - 1, secondArrayInput.length - 1);
            for (int j = i + 1; j <= depth; j++) {
                 if (currentPrice < Integer.parseInt(secondArrayInput[j])) {
                     boughtFishes++;
                 } else {
                     break;
                 }
            }
            result[i] = boughtFishes;
            sumMinFishCost += Integer.parseInt(secondArrayInput[i]) * result[i];
            i += boughtFishes;
            boughtFishes = 1;
        }
        System.out.println(sumMinFishCost);
        for (int j = 0; j < result.length; j++) {
            System.out.print(result[j] + " ");
        }
    }
}
