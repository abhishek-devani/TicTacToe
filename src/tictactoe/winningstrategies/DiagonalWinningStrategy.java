package tictactoe.winningstrategies;

import tictactoe.models.Board;
import tictactoe.models.Move;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy {

    HashMap<Character, Integer> leftDiagonalMap = new HashMap<>();
    HashMap<Character, Integer> rightDiagonalMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();
        char symbol = move.getPlayer().getSymbol();

        // check if the cell is a part of left diagonal
        if (row == column) {

            // check if this symbol is coming for the first time
            if (!leftDiagonalMap.containsKey(symbol)) {
                leftDiagonalMap.put(symbol, 0);
            }

            leftDiagonalMap.put(symbol, 1 + leftDiagonalMap.get(symbol));

            // check if the count of current symbol is same as the size of the board
            if (board.getDimension() == leftDiagonalMap.get(symbol)) {
                System.out.println("Winning via left dia");
                return true;
            }
        }

        // check if the cell is a part of right diagonal
        if (row + column == board.getDimension() - 1) {

            // check if this symbol is coming for the first time
            if (!rightDiagonalMap.containsKey(symbol)) {
                rightDiagonalMap.put(symbol, 0);
            }

            rightDiagonalMap.put(symbol, 1 + rightDiagonalMap.get(symbol));

            // check if the count of current symbol is same as the size of the board
            if (board.getDimension() == rightDiagonalMap.get(symbol)) {
                System.out.println("Winning via right dia");
                return true;
            }
        }

        return false;
    }

    @Override
    public void undo(Board board, Move lastMove) {

        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getColumn();
        char symbol = lastMove.getPlayer().getSymbol();

        if (row == col) {
            leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol) - 1);
        }

        if (row + col == board.getDimension()-1) {
            rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol) - 1);
        }

    }
}
