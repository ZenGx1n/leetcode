package com.leetcode.basic.priorityqueue;

import java.util.*;

/**
 * @author ZenGx1n
 * @since 2021-09-02 10:54
 * 前K个高频单词
 */
public class Solution692 {

    class Word {
        String word;
        int freq;

        public Word(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Word> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.freq == o2.freq) {
                return o1.word.compareTo(o2.word);
            } else {
                return o2.freq - o1.freq;
            }
        });
        Map<String, Integer> map = new TreeMap<>();
        for (int i = words.length - 1; i >= 0; i--) {
            map.merge(words[i], 1, Integer::sum);
        }
        for (String word : map.keySet()) {
            pq.add(new Word(word, map.get(word)));
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(pq.remove().word);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution692 solution = new Solution692();
        List<String> list = solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 3);
        list.forEach(System.out::println);
    }

}
