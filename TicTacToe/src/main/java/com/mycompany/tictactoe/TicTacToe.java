/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tictactoe;

/**
 *
 * @author Andy
 */
import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static Scanner scanner = new Scanner(System.in);
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();
        while (true) {
            int[] move = getPlayerMove();
            if (board[move[0]][move[1]] == ' ') {
                board[move[0]][move[1]] = currentPlayer;
                displayBoard();
                if (hasPlayerWon()) {
                    System.out.println("Player " + currentPlayer + " has won!");
                    break;
                }
                if (isBoardFull()) {
                    System.out.println("The game is a tie!");
                    break;
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static int[] getPlayerMove() {
        int[] move = new int[2];
        System.out.print("Player " + currentPlayer + ", enter row (1-3): ");
        move[0] = scanner.nextInt() - 1;
        System.out.print("Player " + currentPlayer + ", enter column (1-3): ");
        move[1] = scanner.nextInt() - 1;
        return move;
    }

    private static boolean hasPlayerWon() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer ||
                    board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer ||
                board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

