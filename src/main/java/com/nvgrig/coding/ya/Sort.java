package com.nvgrig.coding.ya;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        Integer result = Arrays.stream(inputString.split(" "))
                .map(Integer::valueOf)
                .sorted()
                .skip(1)
                .findFirst()
                .get();
        System.out.printf(result.toString());
    }

}
