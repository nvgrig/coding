package com.nvgrig.coding.tnkf;

import java.util.Scanner;

public class MobileTariffCost {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringInput = scanner.nextLine();
        String[] arrayInput = stringInput.split(" ");
        int a = Integer.parseInt(arrayInput[0]);
        int b = Integer.parseInt(arrayInput[1]);
        int c = Integer.parseInt(arrayInput[2]);
        int d = Integer.parseInt(arrayInput[3]);
        System.out.println(a + ((b - d)> 0 ? 0 : (d - b) * c));
    }

}
