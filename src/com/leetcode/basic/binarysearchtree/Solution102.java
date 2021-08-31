package com.leetcode.basic.binarysearchtree;

import com.leetcode.basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ZenGx1n
 * @since 2021-08-20 10:51
 * 二叉树的层序遍历
 */
class Solution102 {

    public static List<Integer> list;

    public static List<Integer> levelOrder(TreeNode root) {
        list = new ArrayList<>();
        if (root != null) {
            order(root);
        }
        return list;
    }

    public static void order(TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        order(node.left);
        order(node.right);
    }

    public static void main(String[] args) {
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, new TreeNode(9), right);
        List<Integer> integerList = levelOrder(root);
        integerList.forEach(System.out::println);
    }

}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }
}
