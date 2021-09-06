package com.leetcode.basic.priorityqueue;

import java.util.*;

/**
 * @author ZenGx1n
 * @since 2021-08-31 16:04
 * 前 K 个高频元素
 */
public class Solution347 {

    class Num {
        int num, freq;

        public Num(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Num> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.freq));
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
                continue;
            }
            map.put(num, map.get(num) + 1);
        }
        for (Integer key : map.keySet()) {
            pq.add(new Num(key, map.get(key)));
            if (pq.size() > k) {
                pq.remove();
            }
        }
        int[] res = new int[k];
        int cnt = 0;
        while (!pq.isEmpty()) {
            res[cnt++] = pq.remove().num;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution347 solution = new Solution347();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

}
