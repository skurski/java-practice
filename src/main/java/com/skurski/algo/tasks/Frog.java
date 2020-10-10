package com.skurski.algo.tasks;

/*
	classA frog only moves forward, but it can move in steps 1 inch long or
	in jumps 2 inches long. classA frog can cover the same distance using
	different combinations of steps and jumps.

	Write a function that calculates the number of different combinations
	a frog can use to cover a given distance.

	For example, a distance of 3 inches can be covered in three ways:
	step-step-step, step-jump, and jump-step.
 */
public class Frog {

    private static int combinations = 0;

    private int distance(int distance) {
        steps("", distance);
        return combinations;
    }

    private void steps(String print, int distance) {
        if (distance == 0) {
            combinations++;
            System.out.println(print);
            return;
        }
        if (distance > 0) {
            steps(print + " jump", distance - 2);
            steps(print + " step", distance - 1);
        }
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        int numberOfCombinations = frog.distance(6);
        System.out.println("Number of combinations: " + numberOfCombinations);
    }
}
