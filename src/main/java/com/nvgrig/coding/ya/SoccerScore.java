package com.nvgrig.coding.ya;

import java.util.Scanner;

public class SoccerScore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstMatchScores = scanner.nextLine().split(":");
        String[] secondMatchScores = scanner.nextLine().split(":");
        boolean isFirstMatchHome = scanner.nextInt() == 1;
        int firstTeamAwayScore = isFirstMatchHome ? Integer.parseInt(secondMatchScores[0]) : Integer.parseInt(firstMatchScores[0]);
        int secondTeamAwayScore = isFirstMatchHome ? Integer.parseInt(firstMatchScores[1]) : Integer.parseInt(secondMatchScores[1]);
        int firstTeamOverallScore = Integer.parseInt(firstMatchScores[0]) + Integer.parseInt(secondMatchScores[0]);
        int secondTeamOverallScore = Integer.parseInt(firstMatchScores[1]) + Integer.parseInt(secondMatchScores[1]);

        if (firstTeamOverallScore > secondTeamOverallScore) {
            System.out.println(0);
        } else if (firstTeamOverallScore == secondTeamOverallScore) {
            if (firstTeamOverallScore == 0) {
                System.out.println(1);
            } else {
                System.out.println(firstTeamAwayScore > secondTeamAwayScore ? 0 : 1);
            }
        } else {
            if (firstTeamAwayScore == secondTeamAwayScore) {
                System.out.println(isFirstMatchHome ? secondTeamOverallScore - firstTeamOverallScore : secondTeamOverallScore - firstTeamOverallScore + 1);
            } else if (firstTeamAwayScore > secondTeamAwayScore) {
                System.out.println(secondTeamOverallScore - firstTeamOverallScore);
            } else {
                int awayDiff = secondTeamAwayScore - firstTeamAwayScore;
                int overallDiff = secondTeamOverallScore - firstTeamOverallScore;
                if (overallDiff == awayDiff) {
                    System.out.println(overallDiff + 1);
                } else {
                    if (isFirstMatchHome) {
                        System.out.println(Math.max(overallDiff, awayDiff));
                    } else {
                        System.out.println(overallDiff + 1);
                    }
                }
            }
        }
    }
}



