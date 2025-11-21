package com.leetcode.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * DesignLinkedList类的单元测试
 * 测试所有方法的正确性和边界情况
 */
class DesignLinkedListTest {
    
    private DesignLinkedList linkedList;
    
    // 每个测试方法执行前初始化链表
    @BeforeEach
    void setUp() {
        linkedList = new DesignLinkedList();
    }
    
    /**
     * 测试基本操作组合 - 题目示例中的测试用例
     */
    @Test
    void testExampleScenario() {
        // 执行题目示例中的操作序列
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        
        assertEquals(2, linkedList.get(1));  // 验证获取索引1的值为2
        
        linkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        assertEquals(3, linkedList.get(1));  // 验证获取索引1的值为3
    }
    
    /**
     * 测试空链表的get操作
     */
    @Test
    void testGetOnEmptyList() {
        assertEquals(-1, linkedList.get(0));  // 空链表的任何索引都应返回-1
        assertEquals(-1, linkedList.get(5));  // 超出范围的索引应返回-1
    }
    
    /**
     * 测试无效索引的get操作
     */
    @Test
    void testGetWithInvalidIndex() {
        linkedList.addAtHead(1);
        linkedList.addAtHead(2);
        
        assertEquals(-1, linkedList.get(-1)); // 负索引应返回-1
        assertEquals(-1, linkedList.get(10)); // 超出范围的索引应返回-1
    }
    
    /**
     * 测试头节点操作
     */
    @Test
    void testAddAtHead() {
        linkedList.addAtHead(1);
        assertEquals(1, linkedList.get(0));  // 验证头节点值
        
        linkedList.addAtHead(2);
        assertEquals(2, linkedList.get(0));  // 验证新头节点值
        assertEquals(1, linkedList.get(1));  // 验证旧头节点现在在索引1位置
    }
    
    /**
     * 测试尾节点操作
     */
    @Test
    void testAddAtTail() {
        linkedList.addAtTail(1);
        assertEquals(1, linkedList.get(0));  // 验证尾节点值（也是头节点）
        
        linkedList.addAtTail(2);
        assertEquals(2, linkedList.get(1));  // 验证新尾节点值
        
        linkedList.addAtTail(3);
        assertEquals(3, linkedList.get(2));  // 验证新尾节点值
    }
    
    /**
     * 测试在各种位置插入节点
     */
    @Test
    void testAddAtIndex() {
        // 测试在头部插入（index=0）
        linkedList.addAtIndex(0, 1);
        assertEquals(1, linkedList.get(0));
        
        // 测试在中间插入
        linkedList.addAtIndex(1, 3);
        linkedList.addAtIndex(1, 2);  // 在索引1位置插入2，链表变为 [1,2,3]
        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
        assertEquals(3, linkedList.get(2));
        
        // 测试在尾部插入（index=size）
        linkedList.addAtIndex(3, 4);
        assertEquals(4, linkedList.get(3));
        
        // 测试索引小于0，应在头部插入
        linkedList.addAtIndex(-1, 0);
        assertEquals(0, linkedList.get(0));
        
        // 测试索引大于size，不应执行操作
        linkedList.addAtIndex(10, 100);
        assertEquals(-1, linkedList.get(10));  // 超出范围应返回-1
    }
    
    /**
     * 测试删除各种位置的节点
     */
    @Test
    void testDeleteAtIndex() {
        // 准备测试数据 [1,2,3,4,5]
        for (int i = 1; i <= 5; i++) {
            linkedList.addAtTail(i);
        }
        
        // 测试删除头部节点
        linkedList.deleteAtIndex(0);
        assertEquals(2, linkedList.get(0));  // 现在头部是2
        
        // 测试删除中间节点
        linkedList.deleteAtIndex(1);  // 删除值为3的节点
        assertEquals(2, linkedList.get(0));
        assertEquals(4, linkedList.get(1));  // 原来的4现在在索引1位置
        
        // 测试删除尾部节点
        linkedList.deleteAtIndex(2);  // 删除值为5的节点
        assertEquals(-1, linkedList.get(2));  // 现在链表长度为2，索引2无效
        
        // 测试删除无效索引
        linkedList.deleteAtIndex(-1);  // 负索引，不应执行操作
        linkedList.deleteAtIndex(10);  // 超出范围索引，不应执行操作
        
        // 验证链表状态没有改变
        assertEquals(2, linkedList.get(0));
        assertEquals(4, linkedList.get(1));
    }
    
    /**
     * 测试连续操作的正确性
     */
    @Test
    void testComplexOperations() {
        // 混合执行各种操作
        linkedList.addAtHead(5);
        linkedList.addAtHead(2);
        linkedList.deleteAtIndex(1);  // 删除5
        linkedList.addAtIndex(1, 9);  // 链表变为 [2,9]
        linkedList.addAtHead(4);      // 链表变为 [4,2,9]
        linkedList.addAtHead(1);      // 链表变为 [1,4,2,9]
        linkedList.addAtHead(5);      // 链表变为 [5,1,4,2,9]
        linkedList.get(3);            // 返回2
        linkedList.addAtTail(7);      // 链表变为 [5,1,4,2,9,7]
        linkedList.addAtTail(2);      // 链表变为 [5,1,4,2,9,7,2]
        linkedList.get(3);            // 返回2
        linkedList.get(5);            // 返回7
        linkedList.deleteAtIndex(6);  // 删除最后一个2
        
        // 验证最终状态
        assertEquals(5, linkedList.get(0));
        assertEquals(1, linkedList.get(1));
        assertEquals(4, linkedList.get(2));
        assertEquals(2, linkedList.get(3));
        assertEquals(9, linkedList.get(4));
        assertEquals(7, linkedList.get(5));
        assertEquals(-1, linkedList.get(6));  // 现在链表长度为6，索引6无效
    }
}