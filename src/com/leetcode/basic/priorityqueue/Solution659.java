package com.leetcode.basic.priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ZenGx1n
 * @since 2021-09-02 9:46
 * 分割数组为连续子序列
 */
public class Solution659 {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);
        }
        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0);
            if (count <= 0) {
                continue;
            } else if (endMap.getOrDefault(num - 1, 0) > 0) {
                countMap.put(num, count - 1);
                endMap.put(num - 1, endMap.get(num - 1) - 1);
                endMap.put(num, endMap.getOrDefault(num, 0) + 1);
            } else if (countMap.getOrDefault(num + 1, 0) > 0 && countMap.getOrDefault(num + 2, 0) > 0) {
                countMap.put(num, count - 1);
                countMap.put(num + 1, countMap.get(num + 1) - 1);
                countMap.put(num + 2, countMap.get(num + 2) - 1);
                endMap.put(num + 2, endMap.getOrDefault(num + 2, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution659 solution = new Solution659();
        System.out.println(solution.isPossible(new int[]{1, 2, 3, 3, 4, 5}));
    }

}
