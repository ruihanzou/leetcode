package com.leetcode.common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树节点类，用于LeetCode中树相关题目的数据结构
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode() {}
    
    public TreeNode(int val) {
        this.val = val;
    }
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    /**
     * 根据数组创建二叉树（层序遍历的方式）
     * 数组中的null表示该位置没有节点
     * @param arr 输入数组
     * @return 创建的二叉树根节点
     */
    public static TreeNode createFromArray(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }
        
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();
            
            // 添加左子节点
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            
            // 添加右子节点
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        
        return root;
    }
    
    /**
     * 中序遍历输出二叉树
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inorderTraversal(this, sb);
        return sb.toString();
    }
    
    private void inorderTraversal(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        
        inorderTraversal(node.left, sb);
        sb.append(node.val).append(" ");
        inorderTraversal(node.right, sb);
    }
}