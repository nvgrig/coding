package com.nvgrig.coding.tnkf;

import java.util.*;

public class Exam5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Set<Integer>> processes = new ArrayList<>();
        Set<Integer> done = new HashSet<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> process = new HashSet<>();
            String[] inputs = sc.nextLine().split(" ");
            if (Integer.parseInt(inputs[0]) > 0) {
                for (int j = 1; j < Integer.parseInt(inputs[0]) + 1; j++) {
                    process.add(Integer.parseInt(inputs[j]));
                }
                processes.add(process);
            } else {
                processes.add(process);
                done.add(i + 1);
                answer.add(i + 1);
            }
        }
        int todo = n - done.size();
        List<List<Integer>> answers = new ArrayList<>();
        answers.add(new ArrayList<>(answer));
        while (todo > 0) {
            answer = new ArrayList<>();
            for (int i = 1; i < processes.size() + 1; i++) {
                if (!processes.get(i - 1).isEmpty()) {
                    processes.get(i - 1).removeIf(done::contains);
                    if (processes.get(i - 1).isEmpty()) {
                        done.add(i);
                        answer.add(i);
                        todo--;
                    }
                }
            }
            answers.add(answer);
        }
        System.out.println(answers.size());
        for (List<Integer> list : answers) {
            System.out.print(list.size() + " ");
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
