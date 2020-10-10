package com.skurski.collections.tree;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


// Implementation using BST
// For simplification I will use Comparable interface in Java
public class CustomTree<K, V> {

    TreeMap<Integer, Integer> map;

    private Entry<K, V> root;

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> parent;
        Entry<K, V> left;
        Entry<K, V> right;

        public Entry(K key, V value, Entry<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }

    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value, null);
        if (root == null) {
            root = entry;
            return;
        }

        Entry<K, V> tempEntry = root;
        Entry<K, V> prevEntry = null;
        while (tempEntry != null) {
            Comparable tempKey = (Comparable) tempEntry.key;
            if (tempKey.compareTo(key) < 0) {
                prevEntry = tempEntry;
                tempEntry = tempEntry.right;
                System.out.println("go right");
            } else if (tempKey.compareTo(key) > 0) {
                prevEntry = tempEntry;
                tempEntry = tempEntry.left;
                System.out.println("go left");
            } else {
                tempEntry.value = value;
                return;
            }
        }

        System.out.println("prev: " + prevEntry.key);
        Comparable tempKey = (Comparable) prevEntry.key;
        if (tempKey.compareTo(key) < 0) {
            prevEntry.right = entry;
        } else if (tempKey.compareTo(key) > 0) {
            prevEntry.left = entry;
        }
    }

    private void inOrderTraversal(Entry<K, V> entry) {
        if (entry == null) return;
        inOrderTraversal(entry.left);
        System.out.println(entry.key + " : " + entry.value);
        inOrderTraversal(entry.right);
    }

    public void print() {
        Entry<K, V> tempEntry = root;
        inOrderTraversal(tempEntry);
    }

    public static void main(String[] args) {
        CustomTree<Integer, String> tree = new CustomTree<>();

        PriorityQueue p;
        ArrayBlockingQueue b;
        ArrayDeque e;

        tree.put(5, "First");
        tree.put(3, "Second");
        tree.put(4, "Fourth");
        tree.put(7, "Seventh");
        tree.put(6, "Sixth");
        tree.put(6, "Sixth updated");
        tree.print();

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(null, null);
        hashMap.entrySet().stream().forEach(System.out::println);

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(null, null);
        treeMap.entrySet().stream().forEach(System.out::println);

        Collections.sort(Arrays.asList(0,1,2));
        Collections.shuffle (Arrays.asList(0,1,2));
    }

}
