package com.leetcode.basic.priorityqueue;

import java.util.*;

/**
 * @author ZenGx1n
 * @since 2021-08-31 16:44
 * 根据字符出现频率排序
 */
public class Solution451 {

    class NS {
        char c;
        int freq;

        public NS(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    public String frequencySort(String s) {
        PriorityQueue<NS> pq = new PriorityQueue<>((o1, o2) -> o2.freq - o1.freq);
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.merge(c, 1, Integer::sum);
        }
        for (Character c : map.keySet()) {
            pq.add(new NS(c, map.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            NS remove = pq.remove();
            for (int i = 0; i < remove.freq; i++) {
                sb.append(remove.c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution451 solution = new Solution451();
        System.out.println(solution.frequencySort("Aabb"));
    }

}
