package com.nvgrig.coding.leet;

import java.util.Arrays;

public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = Arrays.copyOf(nums1, m);
        int i = 0;
        int j = 0;
        for (int k = 0; k < m + n; k++) {
            if (i == m) {
                nums1[k] = nums2[j++];
            } else if (j == n) {
                nums1[k] = nums1Copy[i++];
            } else {
                nums1[k] = nums1Copy[i] <= nums2[j] ? nums1Copy[i++] : nums2[j++];
            }
        }
        Arrays.stream(nums1).forEach(System.out::print);
    }
}
