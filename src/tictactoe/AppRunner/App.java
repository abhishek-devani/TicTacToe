package tictactoe.AppRunner;

import tictactoe.controller.GameController;
import tictactoe.exception.DuplicateSymbolException;
import tictactoe.exception.MoreThanOneBotException;
import tictactoe.exception.PlayersCountMismatchException;
import tictactoe.models.*;
import tictactoe.winningstrategies.ColumnWinningStrategy;
import tictactoe.winningstrategies.DiagonalWinningStrategy;
import tictactoe.winningstrategies.RowWinningStrategy;
import tictactoe.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws DuplicateSymbolException, PlayersCountMismatchException, MoreThanOneBotException {

        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        int dimension = 3;
        List<Player> playerList = new ArrayList<>();
        List<WinningStrategy> winningStrategies = new ArrayList<>();

        playerList.add(new Player('O', "abc", 1, PlayerType.HUMAN));
        playerList.add(new Bot('X', "GPT", 2, PlayerType.BOT, BotDifficultyLevel.EASY));

        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = gameController.startGame(dimension, playerList, winningStrategies);

        while (game.getGameState().equals(GameState.in_progress)) {
//            game.printBoard();
            gameController.printBoard(game);

            System.out.println("Does anyone want to undo? (y/n)");
            String undo = scanner.next();

            if (undo.equalsIgnoreCase("y")) {
                gameController.undo(game);
                continue;
            }

            gameController.makeMove(game);
        }

        // If I'm here, it means game is not in progress anymore
        if (GameState.success.equals(game.getGameState())) {
            gameController.printBoard(game);
            System.out.println(game.getWinner().getName() +", Congratulation! You won the game :)");
        }
        if (GameState.draw.equals(game.getGameState())) {
            gameController.printBoard(game);
            System.out.println("Match tied :| ");
        }

    }
}
