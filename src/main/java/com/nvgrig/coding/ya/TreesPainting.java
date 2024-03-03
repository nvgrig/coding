package com.nvgrig.coding.ya;

import java.util.*;
import java.util.stream.Stream;

public class TreesPainting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] vasyaInput = scanner.nextLine().split(" ");
        int vasyaPaintCan = Integer.parseInt(vasyaInput[0]);
        int vasyaMax = Integer.parseInt(vasyaInput[1]);
        int vasyaStart = vasyaPaintCan - vasyaMax;
        int vasyaFinish = vasyaPaintCan + vasyaMax;
        String[] mashaInput = scanner.nextLine().split(" ");
        int mashaPaintCan = Integer.parseInt(mashaInput[0]);
        int mashaMax = Integer.parseInt(mashaInput[1]);
        int mashaStart = mashaPaintCan - mashaMax;
        int mashaFinish = mashaPaintCan + mashaMax;
        if (vasyaPaintCan <= mashaPaintCan && mashaStart <= vasyaFinish || vasyaPaintCan >= mashaPaintCan && vasyaStart <= mashaFinish) {
            int min = Stream.of(vasyaStart, vasyaFinish, mashaStart, mashaFinish).min(Comparator.naturalOrder()).get();
            int max = Stream.of(vasyaStart, vasyaFinish, mashaStart, mashaFinish).max(Comparator.naturalOrder()).get();
            System.out.println(max - min + 1);
        } else {
            System.out.println(vasyaFinish - vasyaStart + mashaFinish - mashaStart + 2);
        }
    }
}
