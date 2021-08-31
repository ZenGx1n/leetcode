package com.leetcode.basic.binarysearchtree;

import com.leetcode.basic.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZenGx1n
 * @since 2021-08-20 14:03
 * N 叉树的后序遍历
 */
public class Solution590 {

    public static List<Integer> list;

    public static List<Integer> postorder(Node root) {
        list = new ArrayList<>();
        if (root != null) {
            if (root.children.size() > 0) {
                order(root.children);
            }
            list.add(root.val);
        }
        return list;
    }

    public static void order(List<Node> nodes) {
        for (Node node : nodes) {
            if (node.children != null) {
                order(node.children);
            }
            list.add(node.val);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(3, Arrays.asList(new Node(5), new Node(6)));
        Node root = new Node(1, Arrays.asList(node1, new Node(2), new Node(4)));
        List<Integer> integerList = postorder(root);
        integerList.forEach(System.out::println);
    }

}
