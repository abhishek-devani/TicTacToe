# Steps to Create TicTacToe

## Structure

```
1. Create main package named tictactoe.
2. Create package called models.
3. Create models (class) for all entities along with attribute.
4. Make all the attributes private.
5. Create getter and setter method for all the classes to access private attributes of them.
6. Create constructor for all the class.
7. Create another package called winningstrategies.
8. Create interface called WinningStrategy.
9. Create different types of strategies class and implement WinningStrategy interface.
10. Create a builder for game class, so we can validate the user inputs.
11. Write validation methods in game class and call it in build method of builder class.
12. While validating if you want to throw exception, create exception package and create exception classes into that package.
13. Create package called botplayingstrategy and create interface called BotPlayingStrategy in it.
14. Create different types of playing strategy class and implement BotPlayingStrategy interface for all of that.
15. Initialize BotPlayingStrategy into bot class.
16. Create Factory class called BotPlayingStrategyFactory into botplayingstrategy package.
```

## Create a Game

1. Create a Controller package (controller is just use to pass the responsibilities).
2. Create GameController class.
3. Implement startGame and printBoard methods in it.
4. Create AppRunner(main) package.
5. Create App class in it.

---
## MakeMove feature

1. Create makeMove method in gameController and pass that responsibility to game.
2. Create makeMove method in game class and write your login to check winner by creating checkWinner method.
3. Create makeMove method in Player and bot class.

---
## Winning Strategy

1. Write logic for rowWinningStrategy
2. Write logic for columnWinningStrategy
3. Write logic for diagonalWinningStrategy

