package com.nvgrig.coding.ya;

import java.util.Scanner;

public class FishSalesman {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstInputs = scanner.nextLine().split(" ");
        String[] prices = scanner.nextLine().split(" ");
        int pricesCol = Integer.parseInt(firstInputs[0]);
        int freshFishDaysCol = Integer.parseInt(firstInputs[1]);
        int maxProfit = 0;
        if (pricesCol > 1) {
            for (int i = 0; i < pricesCol; i++) {
                for (int j = 1; j <= freshFishDaysCol; j++) {
                    if (i + j > pricesCol - 1) {
                        break;
                    }
                    int currentMaxProfit = Integer.parseInt(prices[i + j]) - Integer.parseInt(prices[i]);
                    if (currentMaxProfit > maxProfit) {
                        maxProfit = currentMaxProfit;
                    }
                }
            }
        }
        System.out.println(maxProfit);
    }
}
