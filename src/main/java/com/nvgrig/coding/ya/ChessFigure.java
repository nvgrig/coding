package com.nvgrig.coding.ya;

import java.util.Scanner;

public class ChessFigure {

    private final static int[] dX = new int[]{-1, 0, 1, 0};
    private final static int[] dY = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int squaresCol = Integer.parseInt(scanner.nextLine());
        int[] rows = new int[squaresCol];
        int[] columns = new int[squaresCol];
        for (int i = 0; i < squaresCol; i++) {
            String[] inputs = scanner.nextLine().split(" ");
            rows[i] = Integer.parseInt(inputs[0]);
            columns[i] = Integer.parseInt(inputs[1]);
        }
        int[][] board = new int[10][10];
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                board[i][j] = 0;
            }
        }
        for (int i = 0; i < 10; i++) {
            board[0][i] = -1;
            board[9][i] = -1;
            board[i][0] = -1;
            board[i][9] = -1;
        }
        for (int i = 0; i < squaresCol; i++) {
            board[rows[i]][columns[i]] = 1;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        int perimeter = 0;
        for (int i = 0; i < squaresCol; i++) {
            perimeter += 4;
            for (int j = 0; j < 4; j++) {
                if (board[rows[i] + dX[j]][columns[i] + dY[j]] == 1) {
                    perimeter -= 1;
                }
            }
        }
        System.out.println(perimeter);
    }
}
