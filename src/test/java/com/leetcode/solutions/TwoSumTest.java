package com.leetcode.solutions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * TwoSum类的单元测试
 */
class TwoSumTest {
    
    private final TwoSum solution = new TwoSum();
    
    @Test
    void testTwoSumCase1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        int[] result = solution.twoSum(nums, target);
        
        // 因为答案可能有不同的顺序，我们需要排序后再比较
        java.util.Arrays.sort(expected);
        java.util.Arrays.sort(result);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    void testTwoSumCase2() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {1, 2};
        int[] result = solution.twoSum(nums, target);
        
        java.util.Arrays.sort(expected);
        java.util.Arrays.sort(result);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    void testTwoSumCase3() {
        int[] nums = {3, 3};
        int target = 6;
        int[] expected = {0, 1};
        int[] result = solution.twoSum(nums, target);
        
        java.util.Arrays.sort(expected);
        java.util.Arrays.sort(result);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    void testTwoSumBruteForce() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        int[] result = solution.twoSumBruteForce(nums, target);
        
        java.util.Arrays.sort(expected);
        java.util.Arrays.sort(result);
        
        assertArrayEquals(expected, result);
    }
}