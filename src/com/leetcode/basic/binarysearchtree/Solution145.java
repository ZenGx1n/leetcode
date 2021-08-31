package com.leetcode.basic.binarysearchtree;

import com.leetcode.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZenGx1n
 * @since 2021-08-20 10:51
 * 二叉树的后序遍历
 */
class Solution145 {
    public static List<Integer> list;

    public static List<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        if (root != null) {
            postorder(root);
        }
        return list;
    }

    public static void postorder(TreeNode node) {
        if (node.left != null) {
            postorder(node.left);
        }
        if (node.right != null) {
            postorder(node.right);
        }
        list.add(node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        List<Integer> integerList = postorderTraversal(root);
        integerList.forEach(System.out::println);
    }

}
