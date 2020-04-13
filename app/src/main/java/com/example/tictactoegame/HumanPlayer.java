package com.example.tictactoegame;

class HumanPlayer implements I_Player {
    private String playerName;
    private int playerScore;
    private FieldState fieldState;

    public HumanPlayer(String playerName, FieldState fieldState) {
        this.playerName = playerName;
        this.fieldState = fieldState;
        playerScore = 0;
    }

    @Override
    public String getName() {
        return playerName;
    }

    @Override
    public Coordinate getMove(Board board) {
        return new Coordinate(1, 1, fieldState);

    }

    public int getScore() {
        return playerScore;
    }

    public void increasePlayerScore() {
        playerScore++;
    }
}
