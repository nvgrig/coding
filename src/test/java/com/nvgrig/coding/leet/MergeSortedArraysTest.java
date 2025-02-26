package com.nvgrig.coding.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArraysTest {

    @Test
    void test() {
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        mergeSortedArrays.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2 ,5, 6}, 3);
    }

}