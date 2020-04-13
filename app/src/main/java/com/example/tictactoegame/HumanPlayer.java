package com.example.tictactoegame;

class HumanPlayer implements I_Player {
    private String m_playerName;
    private int m_playerScore;
    private FieldState m_fieldState;

    public HumanPlayer(String playerName, FieldState fieldState) {
        m_playerName = playerName;
        m_fieldState = fieldState;
        m_playerScore = 0;
    }

    @Override
    public String getName() {
        return m_playerName;
    }

    @Override
    public Coordinate getMove(Board board) {
        return new Coordinate(1, 1, m_fieldState);

    }

    public int getScore() {
        return m_playerScore;
    }

    public void increasePlayerScore() {
        m_playerScore++;
    }
}
