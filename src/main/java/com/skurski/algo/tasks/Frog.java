package com.skurski.algo.tasks;

/*
	Frog only moves forward, but it can move in steps 1 inch long or
	in jumps 2 inches long. Frog can cover the same distance using
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
        System.out.println("Frog executed for: " + distance +
                ", print: " + print);
        if (distance < 0) return;

        if (distance == 0) {
            combinations++;
            System.out.println("return base case");

            System.out.println(print);
            return;
        }

        if (distance > 0) {
            System.out.println("Recursive call");

            steps(print + " jump", distance - 2);
            steps(print + " step", distance - 1);
        }
    }

    private int count(int distance) {
        if (distance < 0) {
            return 0;
        }
        if (distance == 0) {
            return 1;
        }

        return count(distance - 2) + count(distance - 1);
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        int numberOfCombinations = frog.distance(12);
        System.out.println("Number of combinations: " + numberOfCombinations);

        System.out.println(frog.count(12));
    }
}
