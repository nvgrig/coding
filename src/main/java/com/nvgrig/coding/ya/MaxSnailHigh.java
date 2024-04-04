package com.nvgrig.coding.ya;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSnailHigh {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int berriesCol = Integer.parseInt(scanner.nextLine());
        int[] upBerryValues = new int[berriesCol];
        int[] downBerryValues = new int[berriesCol];
        int[] deltaBerryValues = new int[berriesCol];
        for (int i = 0; i < berriesCol; i++) {
            String[] inputs = scanner.nextLine().split(" ");
            upBerryValues[i] = Integer.parseInt(inputs[0]);
            downBerryValues[i] = Integer.parseInt(inputs[1]);
            deltaBerryValues[i] = upBerryValues[i] - downBerryValues[i];
        }

        int maxUpWithNegativeDelta = 0;
        int maxUpWithNegativeDeltaPosition = 0;
        int maxDownWithPosistiveDelta = 0;
        int maxDownWithPositiveDeltaPosition = 0;
        List<Integer> positivePositions = new ArrayList<>();
        List<Integer> negativePositions = new ArrayList<>();
        for (int i = 0; i < berriesCol; i++) {
            if (deltaBerryValues[i] >= 0) {
                positivePositions.add(i);
                if (downBerryValues[i] > maxDownWithPosistiveDelta) {
                    maxDownWithPositiveDeltaPosition = i;
                    maxDownWithPosistiveDelta = downBerryValues[i];
                }
            } else {
                negativePositions.add(i);
                if (upBerryValues[i] > maxUpWithNegativeDelta) {
                    maxUpWithNegativeDeltaPosition = i;
                    maxUpWithNegativeDelta = upBerryValues[i];
                }
            }
        }

        long maxHigh = 0;
        if (negativePositions.isEmpty()) {
            for (Integer position : positivePositions) {
                if (position != maxDownWithPositiveDeltaPosition) {
                    maxHigh += (deltaBerryValues[position]);
                }
            }
            maxHigh += upBerryValues[maxDownWithPositiveDeltaPosition];
            List<Integer> orderedByDownDescPositivePositions = new ArrayList<>();
            while (!positivePositions.isEmpty()) {
                int minDownWithPosistiveDelta = downBerryValues[positivePositions.get(0)];
                int minDownWithPositiveDeltaPosition = 0;
                for (Integer position : positivePositions) {
                    if (downBerryValues[position] < minDownWithPosistiveDelta) {
                        minDownWithPosistiveDelta = downBerryValues[position];
                        minDownWithPositiveDeltaPosition = positivePositions.indexOf(position);
                    }
                }
                orderedByDownDescPositivePositions.add(positivePositions.get(minDownWithPositiveDeltaPosition));
                positivePositions.remove(minDownWithPositiveDeltaPosition);
            }
            positivePositions = orderedByDownDescPositivePositions;
        } else {
            long sum = 0;
            for (Integer position : positivePositions) {
                sum += upBerryValues[position];
                if (sum > maxHigh) {
                    maxHigh = sum;
                }
                sum -= downBerryValues[position];
            }
            sum += upBerryValues[maxUpWithNegativeDeltaPosition];
            if (sum > maxHigh) {
                maxHigh = sum;
            }
            positivePositions.add(maxUpWithNegativeDeltaPosition);
        }

        System.out.println(maxHigh);
        positivePositions.stream().map(position -> position + 1).forEach(position -> System.out.print(position + " "));
        if (!negativePositions.isEmpty()) {
            negativePositions.remove(Integer.valueOf(maxUpWithNegativeDeltaPosition));
            negativePositions.stream().map(position -> position + 1).forEach(position -> System.out.print(position + " "));
        }
    }
}
