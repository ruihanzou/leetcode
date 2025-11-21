package com.leetcode.solutions;

import com.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * ReverseLinkedList类的单元测试
 */
class ReverseLinkedListTest {
    
    private final ReverseLinkedList solution = new ReverseLinkedList();
    
    @Test
    void testReverseListCase1() {
        // 测试用例1: [1,2,3,4,5] -> [5,4,3,2,1]
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createFromArray(nums);
        ListNode result = solution.reverseList(head);
        
        // 验证反转后的链表值
        assertEquals(5, result.val);
        assertEquals(4, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(1, result.next.next.next.next.val);
        assertNull(result.next.next.next.next.next);
    }
    
    @Test
    void testReverseListCase2() {
        // 测试用例2: [1,2] -> [2,1]
        int[] nums = {1, 2};
        ListNode head = ListNode.createFromArray(nums);
        ListNode result = solution.reverseList(head);
        
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertNull(result.next.next);
    }
    
    @Test
    void testReverseListEmpty() {
        // 测试用例3: 空链表
        ListNode head = null;
        ListNode result = solution.reverseList(head);
        assertNull(result);
    }
    
    @Test
    void testReverseListSingleNode() {
        // 测试用例4: 单节点链表
        int[] nums = {1};
        ListNode head = ListNode.createFromArray(nums);
        ListNode result = solution.reverseList(head);
        
        assertEquals(1, result.val);
        assertNull(result.next);
    }
    
    @Test
    void testReverseListRecursive() {
        // 测试递归方法
        int[] nums = {1, 2, 3};
        ListNode head = ListNode.createFromArray(nums);
        ListNode result = solution.reverseListRecursive(head);
        
        assertEquals(3, result.val);
        assertEquals(2, result.next.val);
        assertEquals(1, result.next.next.val);
        assertNull(result.next.next.next);
    }
}