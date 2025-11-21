package com.leetcode.solutions;

/**
 * 设计链表 - LeetCode #707
 * 使用双向链表实现
 * 时间复杂度：
 * - get(index): O(min(n, index)) - 根据索引位置选择从头或从尾开始遍历
 * - addAtHead(val): O(1) - 直接在头部添加节点
 * - addAtTail(val): O(1) - 直接在尾部添加节点
 * - addAtIndex(index, val): O(min(n, index)) - 根据索引位置选择遍历方向
 * - deleteAtIndex(index): O(min(n, index)) - 根据索引位置选择遍历方向
 * 空间复杂度：O(n) - 存储n个节点的空间
 */

/**
 * 最优实现：使用双向链表
 * 优势：
 * 1. 尾部操作（如get、delete）的时间复杂度可以优化
 * 2. 对于索引靠近尾部的操作，可以从尾部开始遍历，减少遍历次数
 * 3. 在已知节点位置的情况下，删除操作更加高效
 */
public class DesignLinkedList {
    // 定义双向链表节点类
    private class Node {
        int val;        // 节点值
        Node next;      // 指向下一个节点的引用
        Node prev;      // 指向上一个节点的引用
        
        // 构造函数
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    
    private Node head;      // 头节点
    private Node tail;      // 尾节点
    private int size;       // 链表大小
    
    /**
     * 初始化链表
     * 时间复杂度：O(1)
     */
    public DesignLinkedList() {
        // 初始化头尾节点为null，大小为0
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * 获取链表中下标为index的节点的值
     * 时间复杂度：O(min(n, index)) - 优化：根据index位置选择从头或从尾开始遍历
     * @param index 要获取的节点下标
     * @return 节点的值，如果下标无效则返回-1
     */
    public int get(int index) {
        // 检查索引是否有效
        if (index < 0 || index >= size) {
            return -1;
        }
        
        Node current;
        // 优化：如果index更靠近头部，从头开始遍历；否则从尾部开始遍历
        if (index < size / 2) {
            // 从头开始遍历
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            // 从尾部开始遍历
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        
        return current.val;
    }
    
    /**
     * 在链表头部添加节点
     * 时间复杂度：O(1)
     * @param val 要添加的节点值
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        
        // 如果链表为空
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            // 新节点的next指向当前头节点
            newNode.next = head;
            // 当前头节点的prev指向新节点
            head.prev = newNode;
            // 更新头节点为新节点
            head = newNode;
        }
        
        size++;
    }
    
    /**
     * 在链表尾部添加节点
     * 时间复杂度：O(1)
     * @param val 要添加的节点值
     */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        
        // 如果链表为空
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            // 当前尾节点的next指向新节点
            tail.next = newNode;
            // 新节点的prev指向当前尾节点
            newNode.prev = tail;
            // 更新尾节点为新节点
            tail = newNode;
        }
        
        size++;
    }
    
    /**
     * 在链表的指定索引位置添加节点
     * 时间复杂度：O(min(n, index)) - 优化：根据index位置选择遍历方向
     * @param index 要插入的位置
     * @param val 要添加的节点值
     */
    public void addAtIndex(int index, int val) {
        // 如果索引大于链表大小，不执行操作
        if (index > size) {
            return;
        }
        
        // 如果索引小于等于0，在头部添加
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        
        // 如果索引等于链表大小，在尾部添加
        if (index == size) {
            addAtTail(val);
            return;
        }
        
        // 创建新节点
        Node newNode = new Node(val);
        
        Node current;
        // 优化：根据index位置选择从头或从尾开始遍历
        if (index < size / 2) {
            // 从头开始遍历到目标索引位置
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            // 从尾部开始遍历到目标索引位置
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        
        // 获取目标位置的前一个节点
        Node prev = current.prev;
        
        // 插入新节点
        newNode.prev = prev;
        newNode.next = current;
        prev.next = newNode;
        current.prev = newNode;
        
        size++;
    }
    
    /**
     * 删除链表中指定索引位置的节点
     * 时间复杂度：O(min(n, index)) - 优化：根据index位置选择遍历方向
     * @param index 要删除的节点位置
     */
    public void deleteAtIndex(int index) {
        // 检查索引是否有效
        if (index < 0 || index >= size) {
            return;
        }
        
        // 如果链表只有一个节点
        if (size == 1) {
            head = null;
            tail = null;
        } 
        // 如果删除的是头节点
        else if (index == 0) {
            head = head.next;
            head.prev = null;
        } 
        // 如果删除的是尾节点
        else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } 
        // 删除中间节点
        else {
            Node current;
            // 优化：根据index位置选择从头或从尾开始遍历
            if (index < size / 2) {
                current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
            } else {
                current = tail;
                for (int i = size - 1; i > index; i--) {
                    current = current.prev;
                }
            }
            
            // 调整指针完成删除
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        
        size--;
    }
    
    /**
     * 主方法，用于测试
     */
    public static void main(String[] args) {
        // 测试示例
        DesignLinkedList myLinkedList = new DesignLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        System.out.println(myLinkedList.get(1));              // 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        System.out.println(myLinkedList.get(1));              // 返回 3
    }
}