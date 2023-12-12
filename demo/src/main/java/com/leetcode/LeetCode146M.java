package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode146M {
    class DoublyLinkedListNode {
        int key;
        int value;
        DoublyLinkedListNode next;
        DoublyLinkedListNode previous;

        public DoublyLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleLinkedList {
        DoublyLinkedListNode head;
        DoublyLinkedListNode tail;

        DoubleLinkedList() {
            head = new DoublyLinkedListNode(-1, -1);
            tail = new DoublyLinkedListNode(-1, -1);
            head.next = tail;
            tail.previous = head;
        }

        private void addNode(DoublyLinkedListNode node) {
            node.next = head.next;
            node.previous = head;

            head.next.previous = node;
            head.next = node;
        }

        private void deleteNode(DoublyLinkedListNode node) {
            DoublyLinkedListNode previousNode = node.previous;
            DoublyLinkedListNode nextNode = node.next;

            previousNode.next = nextNode;
            nextNode.previous = previousNode;
        }

        private DoublyLinkedListNode deleteNode() {
            DoublyLinkedListNode toBeDeletedNode = tail.previous;
            tail.previous = toBeDeletedNode.previous;
            toBeDeletedNode.previous.next = tail;
            return toBeDeletedNode;
        }
    }

    private Map<Integer, DoublyLinkedListNode> keyMap;
    private DoubleLinkedList dll;
    private int capacity;

    public LeetCode146M(int capacity) {
        this.capacity = capacity;
        keyMap = new HashMap<>(capacity);
        dll = new DoubleLinkedList();
    }

    public int get(int key) {
        if (keyMap.containsKey(key)) {
            DoublyLinkedListNode valueNode = keyMap.get(key);
            dll.deleteNode(valueNode);
            dll.addNode(valueNode);
            return valueNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (keyMap.containsKey(key)) {
            DoublyLinkedListNode valueNode = keyMap.get(key);
            valueNode.value = value;
            dll.deleteNode(valueNode);
            dll.addNode(valueNode);
            return;
        }
        if (keyMap.size() == capacity) {
            DoublyLinkedListNode deletedNode = dll.deleteNode();
            keyMap.remove(deletedNode.key);
        }
        DoublyLinkedListNode valueNode = new DoublyLinkedListNode(key, value);
        dll.addNode(valueNode);
        keyMap.put(key, valueNode);
    }
}
