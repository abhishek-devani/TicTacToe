package tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int dimension;
    private List<List<Cell>> board;

    public Board(int dimension) {
        this.dimension = dimension;
        board = new ArrayList<>();

        for (int row = 0; row < dimension; row++) {
            board.add(new ArrayList<>());
            for (int col = 0; col < dimension; col++) {
                board.get(row).add(new Cell(row, col));
            }
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void printBoard() {

        for (List<Cell> row: board) {
            for (Cell cell: row) {
                cell.display();
            }
            System.out.println();
        }

    }
}
