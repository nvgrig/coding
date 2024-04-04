package com.nvgrig.coding.ya;

import java.util.*;

public class Playlist {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> dictionary = new TreeMap<>();
        int playlistSize = 0;
        for (int i = 0; i < numberOfPeople; i++) {
            scanner.nextLine();
            for (String song : scanner.nextLine().split(" ")) {
                if (dictionary.containsKey(song)) {
                    dictionary.compute(song, (key, val) -> val + 1);
                } else {
                    dictionary.put(song, 1);
                }
                if (dictionary.get(song) == numberOfPeople) {
                    playlistSize++;
                }
            }
        }
        System.out.println(playlistSize);
        dictionary.forEach((key, value) -> {
            if (value == numberOfPeople) {
                System.out.print(key + " ");
            }
        });
    }
}
