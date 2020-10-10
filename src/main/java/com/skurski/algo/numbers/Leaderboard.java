package com.skurski.algo.numbers;

import java.util.ArrayList;
import java.util.List;

public class Leaderboard {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked ex: [100,90,90,80]
     *  2. INTEGER_ARRAY player ex: [95,94,105,70]
     */
    public List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        List<Integer> scores = new ArrayList<>();
        scores.add(1);
        for (int i = 1; i < ranked.size(); i++) {
            if (ranked.get(i).intValue() == ranked.get(i - 1).intValue()) {
                scores.add(scores.get(i - 1));
            } else {
                scores.add(scores.get(i - 1) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < player.size(); i++) {

            if (player.get(i).intValue() > ranked.get(0).intValue()) {
                result.add(1);
            } else if (player.get(i).intValue() < ranked.get(ranked.size() - 1).intValue()) {
                result.add(scores.get(scores.size() - 1) + 1);
            } else {
                int index = binarySearch(ranked, player.get(i));
                result.add(scores.get(index));
            }
        }

        return result;
    }

    private static int binarySearch(List<Integer> allScores, int playerScore) {
        int low = 0;
        int high = allScores.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int currentAllScore = allScores.get(mid).intValue();
            if (currentAllScore > playerScore) {
                low = mid + 1;
            } else if (currentAllScore < playerScore) {
                if (allScores.get(mid - 1).intValue() > playerScore) {
                    return mid;
                }
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int index = binarySearchIterative(new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15}, 11);
        System.out.println(index);

        int index2 = binarySearchRecursive(new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15}, 11, 0, 9);
        System.out.println(index2);
    }

    private static int binarySearchIterative(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (array[middle] > key) {
                high = middle - 1;
            } else if (array[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    private static int binarySearchRecursive(int[] array, int key, int low, int high) {
        if (low > high) return -1;
        int middle = (low + high) / 2;

        if (key == array[middle]) {
            return middle;
        } else if (array[middle] > key) {
            return binarySearchRecursive(array, key, low, middle - 1);
        } else {
            return binarySearchRecursive(array, key, middle + 1, high);
        }
    }
}
