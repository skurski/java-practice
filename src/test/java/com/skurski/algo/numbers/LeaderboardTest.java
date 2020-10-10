package com.skurski.algo.numbers;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LeaderboardTest {

    private Leaderboard leaderboard = new Leaderboard();

    @Test
    public void shouldSuccessWithEasyExample() {
        List<Integer> playerScores = leaderboard.climbingLeaderboard(
                Stream.of(100, 90, 90, 80).collect(Collectors.toList()),
                Stream.of(70, 80, 105).collect(Collectors.toList())
        );

        assertIterableEquals(
                Stream.of(4,3,1).collect(Collectors.toList()),
                playerScores
        );
    }

    @Test
    public void prepareData() throws IOException {
        String FILE_NAME = "leaderboard-player-scores.txt";
        List<String> ranked = Files.lines(Paths.get(FILE_NAME))
                .map(line -> line.split(" "))
                .flatMap(array -> Arrays.stream(array))
                .collect(Collectors.toList());

        Files.write(Paths.get(FILE_NAME), ranked, StandardCharsets.UTF_8);
    }

    @Test
    public void prepareDataForRanked() throws IOException {
        String FILE_NAME = "leaderboard-ranked.txt";
        List<String> ranked = Files.lines(Paths.get(FILE_NAME))
                .map(line -> line.split(" "))
                .flatMap(array -> Arrays.stream(array))
                .distinct()
                .collect(Collectors.toList());

        Files.write(Paths.get("leaderboard-distinct-ranked.txt"), ranked, StandardCharsets.UTF_8);
    }

    @Test
    public void shouldSuccessWithComplexExample() throws IOException {
        List<Integer> ranked = Files.lines(Paths.get("leaderboard-ranked.txt"))
                .map(line -> line.split(" "))
                .flatMap(array -> Arrays.stream(array))
                .map(value -> Integer.valueOf(value))
                .collect(Collectors.toList());

        List<Integer> player = Files.lines(Paths.get("leaderboard-player-scores.txt"))
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(value -> Integer.valueOf(value))
                .collect(Collectors.toList());

        List<Integer> result = leaderboard.climbingLeaderboard(ranked, player);

        List<Integer> expectedResult = Files.lines(Paths.get("leaderboard-player-result.txt"))
                .map(value -> Integer.valueOf(value))
                .collect(Collectors.toList());

        assertIterableEquals(expectedResult, result);
    }
}