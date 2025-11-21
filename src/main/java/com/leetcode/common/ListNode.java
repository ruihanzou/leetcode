package com.leetcode.common;

/**
 * 链表节点类，用于LeetCode中链表相关题目的数据结构
 */
public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode() {}
    
    public ListNode(int val) {
        this.val = val;
    }
    
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    /**
     * 根据数组创建链表
     * @param arr 输入数组
     * @return 创建的链表头节点
     */
    public static ListNode createFromArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        
        return head;
    }
    
    /**
     * 将链表转换为字符串表示
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }
}