package com.nvgrig.coding.leet;

public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int seq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                seq++;
            } else {
                max = Math.max(max, seq);
                seq = 0;
            }
        }
        return Math.max(max, seq);
    }
}
