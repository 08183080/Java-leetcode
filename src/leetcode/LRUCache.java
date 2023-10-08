package src.leetcode;/*
* 2023/9/24 雨天 细雨蒙蒙
* 周日 宿舍将近11点起床的...
* 【146.LRU缓存】
*
* 我不会做,这题面试常考
* 哈希 + 双向链表
*
* 参考:
* https://leetcode.cn/problems/lru-cache/solutions/259678/lruhuan-cun-ji-zhi-by-leetcode-solution/?envType=daily-question&envId=2023-09-24
* */

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // 定义一个满足题意的双向链表类
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {};
        public DLinkedNode(int k, int v) {
            key = k; value = v;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    DLinkedNode head, tail;

    // 将某个节点放在双向链表的最开始之处
    private void addToHead (DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 删除某个节点
    private void removeNode (DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 将某个节点移动到头部
    private void moveToHead (DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    //删除尾部
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity; //this.capacity = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put (int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode n = new DLinkedNode(key, value);
            cache.put(key, n);
            addToHead(n);
            size++;
            if (size > capacity) {
                // 如果加入之后超容了,那就
                // 1. 删除尾部节点
                // 2. 删除尾部节点的hash表中的值
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;//node.value = key;
            moveToHead(node);
        }
    }

    public static void main(String args[]) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));       //应该输出3的,却输出了2
    }

}
