package com.leetcode.basic.priorityqueue;

import java.util.PriorityQueue;

/**
 * @author ZenGx1n
 * @since 2021-09-06 11:03
 * 丑数
 */
public class Solution264 {

    public int nthUglyNumber(int n) {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        double ugly = 1;
        for (int i = 1; i < n; i++) {
            pq.add(ugly * 2);
            pq.add(ugly * 3);
            pq.add(ugly * 5);
            ugly = pq.poll();
            while (!pq.isEmpty() && ugly == pq.peek()) {
                pq.poll();
            }
        }
        return (int) ugly;
    }

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Solution264 solution = new Solution264();
        System.out.println(solution.isUgly(10));
        System.out.println(solution.nthUglyNumber(10));
    }

}
