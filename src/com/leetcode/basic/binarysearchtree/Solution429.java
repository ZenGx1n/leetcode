package com.leetcode.basic.binarysearchtree;

import com.leetcode.basic.Node;

import java.util.*;

/**
 * @author ZenGx1n
 * @since 2021-08-20 14:03
 * N 叉树的层序遍历
 */
public class Solution429 {

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> tree = new ArrayList<>();
        if (root != null) {
            Queue<Node> queue = new LinkedList<>(root.children);
            tree.add(Collections.singletonList(root.val));
            while (!queue.isEmpty()) {
                int count = queue.size();
                List<Integer> list = new ArrayList<>();
                while (count > 0) {
                    Node node = queue.poll();
                    list.add(node.val);
                    if (node.children != null) {
                        queue.addAll(node.children);
                    }
                    count--;
                }
                tree.add(list);
            }
        }
        return tree;
    }

    public static void main(String[] args) {
        Node node1 = new Node(3, Arrays.asList(new Node(5), new Node(6)));
        Node root = new Node(1, Arrays.asList(node1, new Node(2), new Node(4)));
        List<List<Integer>> integerList = levelOrder(root);
        integerList.forEach(System.out::println);
    }

}
