package com.nvgrig.coding.leet;

public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        double max = 0;
        int pointer = 0;
        boolean isFirst = true;
        while (nums.length - pointer >= k) {
            int sum = 0;
            for (int i = pointer; i < pointer + k; i++) {
                sum = sum + nums[i];
            }
            double currentAverage = (double) sum / k;
            if (isFirst) {
                max = currentAverage;
                isFirst = false;
            } else {
                max = Math.max(max, currentAverage);
            }
            pointer++;
        }
        return max;
    }
}
