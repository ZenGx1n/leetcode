package com.leetcode.basic.binarysearchtree;

import com.leetcode.basic.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZenGx1n
 * @since 2021-08-20 10:51
 * 二叉树的前序遍历
 */
class Solution144 {
    public static List<Integer> list;

    public static List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        if (root != null) {
            preorder(root);
        }
        return list;
    }

    public static void preorder(TreeNode node) {
        list.add(node.val);
        if (node.left != null) {
            preorder(node.left);
        }
        if (node.right != null) {
            preorder(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        List<Integer> integerList = preorderTraversal(root);
        integerList.forEach(System.out::println);
    }

}


