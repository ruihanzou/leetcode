package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和 - LeetCode #1
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，
 * 并返回它们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * </p>
 * 示例：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class TwoSum {
    
    /**
     * 方法一：暴力解法 - 时间复杂度 O(n²)，空间复杂度 O(1)
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    /**
     * 方法二：哈希表解法 - 时间复杂度 O(n)，空间复杂度 O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }
    
    /**
     * 主方法，用于测试
     */
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        
        // 测试用例1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("测试用例1结果: [" + result1[0] + ", " + result1[1] + "]");
        
        // 测试用例2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("测试用例2结果: [" + result2[0] + ", " + result2[1] + "]");
        
        // 测试用例3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("测试用例3结果: [" + result3[0] + ", " + result3[1] + "]");
    }
}