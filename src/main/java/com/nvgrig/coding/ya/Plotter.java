package com.nvgrig.coding.ya;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Plotter {

    private static class Line {
        int startX;
        int startY;
        int finishX;
        int finishY;

        public Line(int startX, int startY, int finishX, int finishY) {
            this.startX = startX;
            this.startY = startY;
            this.finishX = finishX;
            this.finishY = finishY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return startX == line.startX && startY == line.startY && finishX == line.finishX && finishY == line.finishY;
        }

        @Override
        public int hashCode() {
            return Objects.hash(startX, startY, finishX, finishY);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] listParams = scanner.nextLine().split(" ");
        int commandsCol = Integer.parseInt(scanner.nextLine());
        char[] commands = scanner.nextLine().toCharArray();
        Set<Line> uniqueLines = new HashSet<>();
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < commandsCol; i++) {
            Line line = draw(startX, startY, commands[i]);
            startX = line.finishX;
            startY = line.finishY;
            if (!uniqueLines.contains(invert(line))) {
                uniqueLines.add(line);
            }
        }
        System.out.println(uniqueLines.size());
    }

    private static Line draw(int startX, int startY, char direction) {
        int finishX = startX;
        int finishY = startY;
        if (direction == 'R') {
            finishX = startX + 1;
        }
        if (direction == 'U') {
            finishY = startY + 1;
        }
        if (direction == 'L') {
            finishX = startX - 1;
        }
        if (direction == 'D') {
            finishY = startY - 1;
        }
        return new Line(startX, startY, finishX, finishY);
    }

    private static Line invert(Line line) {
        return new Line(line.finishX, line.finishY, line.startX, line.startY);
    }

}
