package com.nvgrig.coding.ya;

import java.util.*;


public class ChessPuzzle {


    private static class Square {
        private int i;
        private int j;


        public Square(int i, int j) {
            this.i = i;
            this.j = j;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Square tuple = (Square) o;
            return i == tuple.i && j == tuple.j;
        }


        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }


    private static Set<Square> chessBoard = new HashSet<>();


    private static Set<Square> figuresPositions = new HashSet<>();


    static {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                chessBoard.add(new Square(i, j));
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Square> bishops = new ArrayList<>();
        List<Square> rooks = new ArrayList<>();
        int rowNumber = 1;
        while (rowNumber < 9) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ') {
                    break;
                }
                if (chars[i] == '*') {
                    continue;
                }
                if (chars[i] == 'R') {
                    Square square = new Square(rowNumber, i + 1);
                    figuresPositions.add(square);
                    rooks.add(square);
                }
                if (chars[i] == 'B') {
                    Square square = new Square(rowNumber, i + 1);
                    figuresPositions.add(square);
                    bishops.add(square);
                }
            }
            rowNumber++;
        }
        bishops.forEach(square -> chessBoard.removeAll(getOccupiedSquares(square.i, square.j, false)));
        rooks.forEach(square -> chessBoard.removeAll(getOccupiedSquares(square.i, square.j, true)));
        System.out.println(chessBoard.size());
    }


    private static Set<Square> getOccupiedSquares(int rowNumber, int colNumber, boolean isRook) {
        Set<Square> resultSet = new HashSet<>();
        if (isRook) {
            for (int i = colNumber - 1; i > 0; i--) {
                Square square = new Square(rowNumber, i);
                if (figuresPositions.contains(square)) {
                    break;
                }
                resultSet.add(square);
            }
            for (int i = colNumber + 1; i < 9; i++) {
                Square square = new Square(rowNumber, i);
                if (figuresPositions.contains(square)) {
                    break;
                }
                resultSet.add(square);
            }
            for (int i = rowNumber - 1; i > 0; i--) {
                Square square = new Square(i, colNumber);
                if (figuresPositions.contains(square)) {
                    break;
                }
                resultSet.add(square);
            }
            for (int i = rowNumber + 1; i < 9; i++) {
                Square square = new Square(i, colNumber);
                if (figuresPositions.contains(square)) {
                    break;
                }
                resultSet.add(square);
            }
            resultSet.add(new Square(rowNumber, colNumber));
        } else {
            int currentRow;
            int currentCol;
            if (rowNumber > 1 && colNumber > 1) {
                currentRow = rowNumber - 1;
                currentCol = colNumber - 1;
                while (currentRow > 0 && currentCol > 0) {
                    Square square = new Square(currentRow, currentCol);
                    if (figuresPositions.contains(square)) {
                        break;
                    }
                    resultSet.add(square);
                    currentRow--;
                    currentCol--;
                }
            }
            if (rowNumber < 8 && colNumber < 8) {
                currentRow = rowNumber + 1;
                currentCol = colNumber + 1;
                while (currentRow < 9 && currentCol < 9) {
                    Square square = new Square(currentRow, currentCol);
                    if (figuresPositions.contains(square)) {
                        break;
                    }
                    resultSet.add(square);
                    currentRow++;
                    currentCol++;
                }
            }
            if (rowNumber > 1 && colNumber < 8) {
                currentRow = rowNumber == 1 ? 1 : rowNumber - 1;
                currentCol = colNumber == 8 ? 8 : colNumber + 1;
                while (currentRow > 0 && currentCol < 9) {
                    Square square = new Square(currentRow, currentCol);
                    if (figuresPositions.contains(square)) {
                        break;
                    }
                    resultSet.add(square);
                    currentRow--;
                    currentCol++;
                }
            }
            if (rowNumber < 8 && colNumber > 1) {
                currentRow = rowNumber == 8 ? 8 : rowNumber + 1;
                currentCol = colNumber == 1 ? 1 : colNumber - 1;
                while (currentRow < 9 && currentCol > 0) {
                    Square square = new Square(currentRow, currentCol);
                    if (figuresPositions.contains(square)) {
                        break;
                    }
                    resultSet.add(square);
                    currentRow++;
                    currentCol--;
                }
            }
            resultSet.add(new Square(rowNumber, colNumber));
        }
        return resultSet;
    }

}

