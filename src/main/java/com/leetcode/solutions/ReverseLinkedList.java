package com.leetcode.solutions;

import com.leetcode.common.ListNode;

/**
 * 反转链表 - LeetCode #206
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * </p>
 * 示例：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class ReverseLinkedList {
    
    /**
     * 方法一：迭代解法 - 时间复杂度 O(n)，空间复杂度 O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        return prev;
    }
    
    /**
     * 方法二：递归解法 - 时间复杂度 O(n)，空间复杂度 O(n)
     */
    public ListNode reverseListRecursive(ListNode head) {
        // 基本情况：空链表或只有一个节点
        if (head == null || head.next == null) {
            return head;
        }
        
        // 递归反转剩余部分
        ListNode newHead = reverseListRecursive(head.next);
        
        // 反转当前节点的指向
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
    
    /**
     * 主方法，用于测试
     */
    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        
        // 测试用例1
        int[] nums1 = {1, 2, 3, 4, 5};
        ListNode head1 = ListNode.createFromArray(nums1);
        System.out.println("原始链表1: " + head1);
        ListNode reversed1 = solution.reverseList(head1);
        System.out.println("反转后链表1: " + reversed1);
        System.out.println();
        
        // 测试用例2
        int[] nums2 = {1, 2};
        ListNode head2 = ListNode.createFromArray(nums2);
        System.out.println("原始链表2: " + head2);
        ListNode reversed2 = solution.reverseList(head2);
        System.out.println("反转后链表2: " + reversed2);
        System.out.println();
        
        // 测试用例3：空链表
        ListNode head3 = null;
        System.out.println("原始链表3: null");
        ListNode reversed3 = solution.reverseList(head3);
        System.out.println("反转后链表3: " + reversed3);
    }
}