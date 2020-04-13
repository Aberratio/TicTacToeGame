package com.example.tictactoegame;

public class Game {
    Board m_board;
    GameState m_gameState;
    I_Player m_crossPlayer;
    I_Player m_circlePlayer;
    boolean m_isCrossTime;

    public Game(String playerName) {
        m_crossPlayer = new HumanPlayer(playerName, FieldState.CROSS);
        m_circlePlayer = new ComputerPlayer(FieldState.CIRCLE);
    }

    public Game(String firstPlayerName, String secondPlayerName) {
        m_crossPlayer = new HumanPlayer(firstPlayerName, FieldState.CROSS);
        m_circlePlayer = new HumanPlayer(secondPlayerName, FieldState.CIRCLE);
    }

    public boolean startGame() {
        initializeGame();
        return play();
    }

    private void initializeGame() {
        m_board = new Board();
        m_gameState = GameState.DURING;
        m_isCrossTime = true;
    }

    private boolean play() {
        while (m_board.getGameState() == GameState.DURING) {
            m_board.changeFieldState(getPlayerToMove().getMove(m_board));
            m_isCrossTime = !m_isCrossTime;
        }

        return true;
    }

    private I_Player getPlayerToMove() {
        return m_isCrossTime ? m_crossPlayer : m_circlePlayer;
    }
}
