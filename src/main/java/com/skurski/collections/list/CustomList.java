package com.skurski.collections.list;

import java.util.Optional;

public class CustomList<T> {

    private Node<T> head = null;

    private Node<T> tail = null;

    private int size = 0;

    public void add(T value) {
        if (head == null) {
            Node headNode = new Node(null, null, value);
            head = headNode;
            tail = headNode;
            size++;
            return;
        }

        Node newNode = new Node(tail, null, value);
        if (head.next == null) {
            head.next = newNode;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void remove(int index) {
        Optional<Node<T>> serchedNode = getNode(index);

        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }

        if (index == 0) {
            head = head.next;
            head.prev = null;
            size--;
            return;
        }

        Node<T> nodeToRemove = serchedNode.get();

        // update references
        Node tempNode = nodeToRemove;
        tempNode.prev.next = tempNode.next;

        if (index == size - 1) {
            tail = tempNode.prev;
        }

        size--;
        nodeToRemove.prev = null;
        nodeToRemove.next = null;
        nodeToRemove.value = null;
    }

    public T get(int index) {
        Optional<Node<T>> searchNode = getNode(index);

        if (searchNode.isPresent()) {
            System.out.println(searchNode.get().value);
            return searchNode.get().value;
        }
        return null;
    }

    private Optional<Node<T>> getNode(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Not correct index value.");
            return Optional.empty();
        }

        Node<T> searchNode = head;
        for (int i = 1; i <= index; i++) {
            searchNode = searchNode.next;
        }
        return Optional.of(searchNode);
    }

    public void print() {
        Node headCopy = head;
        while (headCopy != null) {
            System.out.println(headCopy.value);
            headCopy = headCopy.next;
        }
    }

    private int size() {
        System.out.println("List size: " + size);
        return size;
    }

    public static void main(String[] args) {
        CustomList<String> customList = new CustomList<>();
        customList.add("one");
        customList.add("two");
        customList.add("three");
        customList.print();

        System.out.println();
        customList.add("four");
        customList.print();

        System.out.println();
        customList.get(1);
        customList.get(0);
        customList.get(11);

        customList.size();

        System.out.println();
        customList.remove(3);
        customList.print();

        System.out.println();
        customList.add("five");
        customList.print();
    }

    private class Node<T> {
        Node next;
        Node prev;
        T value;

        Node(Node prev, Node next, T value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
}
