package com.leetcode.basic.trie;

import java.util.TreeMap;

/**
 * @author ZenGx1n
 * @since 2021-09-06 16:03
 */
public class Solution208 {

    public class Node {
        boolean isWord;
        TreeMap<Character, Node> next;

        public Node() {
            this.isWord = false;
            next = new TreeMap<>();
        }

    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Solution208() {
        this.root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution208 solution = new Solution208();
        System.out.println(solution.search("hello"));
        System.out.println(solution.startsWith("he"));
        solution.insert("hello");
        System.out.println(solution.search("hello"));
        System.out.println(solution.startsWith("he"));
    }

}
