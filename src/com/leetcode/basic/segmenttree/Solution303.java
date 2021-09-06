package com.leetcode.basic.segmenttree;

import java.util.Arrays;

/**
 * @author ZenGx1n
 * @since 2021-09-03 9:13
 */
public class Solution303 {

    int[] sums;

    public Solution303(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        System.out.println(Arrays.toString(sums));
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

    public static void main(String[] args) {
        Solution303 solution = new Solution303(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(solution.sumRange(2, 6));
    }

}
