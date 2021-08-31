package com.leetcode.basic.binarysearchtree;

import com.leetcode.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZenGx1n
 * @since 2021-08-20 10:51
 * 二叉树的中序遍历
 */
class Solution94 {
    public static List<Integer> list;

    public static List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        if (root != null) {
            inorder(root);
        }
        return list;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        List<Integer> integerList = inorderTraversal(root);
        integerList.forEach(System.out::println);
    }

}
