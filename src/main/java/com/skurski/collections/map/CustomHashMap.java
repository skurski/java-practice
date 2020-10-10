package com.skurski.collections.map;

import java.util.Arrays;
import java.util.Objects;

public class CustomHashMap<K, V> {

    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return key.equals(node.key) &&
                    value.equals(node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    static int DEFAULT_SIZE = 1 << 4;

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//        return 1;
    }

    public CustomHashMap() {
        this.table = new Node[DEFAULT_SIZE];
    }

    // bucket
    private Node<K, V>[] table;

    private int getIndex(int hash) {
        return DEFAULT_SIZE - 1 & hash;
    }

    public void put(K key, V value) {
        int hashKey = hash(key);
        int index = getIndex(hashKey);
        Node<K, V> tempNode = table[index];
        Node<K, V> newNode = new Node<>(hashKey, key, value, null);

        if (tempNode == null) {
            table[index] = newNode;
            return;
        }

        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = newNode;
    }

    public V get(K key) {
        int hashKey = hash(key);
        int index = getIndex(hashKey);

        Node<K, V> tempNode = table[index];

        while (tempNode != null) {
            if (hashKey == tempNode.hash && key.equals(tempNode.key)) {
                return tempNode.value;
            }
            tempNode = tempNode.next;
        }
        return null;
    }

    public void remove(K key) {
        int hashKey = hash(key);
        int index = getIndex(hashKey);

        Node<K, V> tempNode = table[index];
        Node<K, V> prevNode = null;

        while (tempNode != null) {
            if (hashKey == tempNode.hash && key.equals(tempNode.key)) {
                if (prevNode == null) {
                    table[index] = tempNode.next;
                    tempNode.value = null;
                    return;
                }
                prevNode.next = tempNode.next;
                tempNode.value = null;
            }
            prevNode = tempNode;
            tempNode = tempNode.next;
        }
    }

    public void print() {
        Arrays.stream(table)
                .filter(node -> node != null)
                .forEach(node -> {
                    while (node != null) {
                        System.out.println(node.key + " : " + node.value);
                        node = node.next;
                    }
                });
    }


    public static void main(String[] args) {
        CustomHashMap<Integer, String> customHashMap = new CustomHashMap<>();
        customHashMap.put(1, "First");
        customHashMap.put(2, "Second");
        customHashMap.put(3, "Third");

        customHashMap.print();
        System.out.println(customHashMap.get(2));

        customHashMap.remove(2);
        customHashMap.remove(1);
        customHashMap.print();
    }
}
