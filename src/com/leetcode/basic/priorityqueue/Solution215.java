package com.leetcode.basic.priorityqueue;

import java.util.PriorityQueue;

/**
 * @author ZenGx1n
 * @since 2021-08-31 16:22
 * 数组中的第K个最大元素（优先队列）
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.remove();
    }


    public static void main(String[] args) {
        Solution215 solution = new Solution215();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 2));
    }

}
