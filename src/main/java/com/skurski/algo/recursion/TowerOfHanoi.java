package com.skurski.algo.recursion;


public class TowerOfHanoi {

    void moveTower(int n, String start, String finish, String temp) {
        if (n == 1) {
            System.out.println(start + " -> " + finish);
            return;
        }

        moveTower(n - 1, start, temp, finish);
        System.out.println(start + " -> " + finish);
        moveTower(n - 1, temp, finish, start);

    }

    public static void main(String[] args) {
        new TowerOfHanoi().moveTower(3, "A", "B", "C");
    }
}
