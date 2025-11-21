package com.leetcode.common;

import java.util.Arrays;
import java.util.List;

/**
 * LeetCode工具类，提供常用的辅助方法
 */
public class LeetCodeUtils {
    
    /**
     * 打印一维数组
     * @param arr 输入数组
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        System.out.println(Arrays.toString(arr));
    }
    
    /**
     * 打印二维数组
     * @param matrix 输入二维数组
     */
    public static void printMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("null");
            return;
        }
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
    
    /**
     * 打印链表
     * @param head 链表头节点
     */
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        System.out.println(head.toString());
    }
    
    /**
     * 打印列表
     * @param list 输入列表
     * @param <T> 元素类型
     */
    public static <T> void printList(List<T> list) {
        if (list == null) {
            System.out.println("null");
            return;
        }
        System.out.println(list.toString());
    }
    
    /**
     * 执行测试并打印结果
     * @param expected 期望结果
     * @param actual 实际结果
     * @param <T> 结果类型
     * @return 是否测试通过
     */
    public static <T> boolean runTest(T expected, T actual) {
        boolean passed = expected.equals(actual);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        System.out.println("Test " + (passed ? "PASSED" : "FAILED"));
        System.out.println("--------------------");
        return passed;
    }
    
    /**
     * 执行数组测试并打印结果
     * @param expected 期望数组
     * @param actual 实际数组
     * @return 是否测试通过
     */
    public static boolean runArrayTest(int[] expected, int[] actual) {
        boolean passed = Arrays.equals(expected, actual);
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual: " + Arrays.toString(actual));
        System.out.println("Test " + (passed ? "PASSED" : "FAILED"));
        System.out.println("--------------------");
        return passed;
    }
    
    /**
     * 执行链表测试并打印结果
     * @param expected 期望链表
     * @param actual 实际链表
     * @return 是否测试通过
     */
    public static boolean runListTest(ListNode expected, ListNode actual) {
        boolean passed = listEquals(expected, actual);
        System.out.println("Expected: " + (expected == null ? "null" : expected.toString()));
        System.out.println("Actual: " + (actual == null ? "null" : actual.toString()));
        System.out.println("Test " + (passed ? "PASSED" : "FAILED"));
        System.out.println("--------------------");
        return passed;
    }
    
    /**
     * 比较两个链表是否相等
     */
    private static boolean listEquals(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
}