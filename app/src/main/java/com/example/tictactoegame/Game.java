package com.example.tictactoegame;

public class Game {
    Board board;
    GameState gameState;
    I_Player crossPlayer;
    I_Player circlePlayer;
    boolean isCrossTime;

    public Game(String playerName) {
        crossPlayer = new HumanPlayer(playerName, FieldState.CROSS);
        circlePlayer = new ComputerPlayer(FieldState.CIRCLE);
    }

    public Game(String firstPlayerName, String secondPlayerName) {
        crossPlayer = new HumanPlayer(firstPlayerName, FieldState.CROSS);
        circlePlayer = new HumanPlayer(secondPlayerName, FieldState.CIRCLE);
    }

    public boolean startGame() {
        initializeGame();
        return play();
    }

    private void initializeGame() {
        board = new Board();
        gameState = GameState.DURING;
        isCrossTime = true;
    }

    private boolean play() {
        while (board.getGameState() == GameState.DURING) {
            board.changeFieldState(getPlayerToMove().getMove(board));
            isCrossTime = !isCrossTime;
        }

        return true;
    }

    private I_Player getPlayerToMove() {
        return isCrossTime ? crossPlayer : circlePlayer;
    }
}
