package com.leetcode.basic;

import java.util.List;

/**
 * @author ZenGx1n
 * @since 2021-08-20 14:02
 * N叉树
 */
public class Node {

    public int val;

    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}
