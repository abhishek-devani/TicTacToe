package tictactoe.winningstrategies;

import tictactoe.models.Board;
import tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy {

    Map<Integer, Map<Character, Integer>> map = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int col = move.getCell().getColumn();
        char symbol = move.getPlayer().getSymbol();

        // check if current col is present in map or not
        if (!map.containsKey(col)) {
            map.put(col, new HashMap<>());
        }

        Map<Character, Integer> colMap = map.get(col);

        // first time entry for symbol
        if (!colMap.containsKey(symbol)) {
            colMap.put(symbol, 0);
        }

        // update the symbol entry for colMap
        colMap.put(symbol, 1 + colMap.get(symbol));

        // check if the symbol count has reached the size of the board
        if (board.getBoard().size() == colMap.get(symbol)) {
            System.out.println("Winning via " +col);
            return true;
        }

        return false;
    }

    @Override
    public void undo(Board board, Move lastMove) {

        int column = lastMove.getCell().getColumn();
        char symbol = lastMove.getPlayer().getSymbol();

        Map<Character, Integer> colMap = map.get(column);
        colMap.put(symbol, colMap.get(symbol) - 1);
    }
}
