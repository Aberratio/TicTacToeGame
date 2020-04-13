package com.example.tictactoegame;

import java.util.Random;
import static java.lang.StrictMath.abs;

class ComputerPlayer implements I_Player {
    private static final String COMPUTER_NAME = "AI_PLAYER";
    private FieldState fieldState;

    public ComputerPlayer(FieldState fieldState) {
        this.fieldState = fieldState;
    }

    @Override
    public String getName() {
        return COMPUTER_NAME;
    }

    @Override
    public Coordinate getMove(Board board) {
        return getRandomEmptyCoordinateAndChangeItState(board.fieldStateArray, board.BOARD_SIZE);
    }

    private Coordinate getRandomEmptyCoordinateAndChangeItState(FieldState[][] fieldStateArray, int boardSize) {
        int randomColumnNumber = getRandomNumber(boardSize);
        int randomRowNumber = getRandomNumber(boardSize);

        for(int rowNumber = randomRowNumber; rowNumber < randomRowNumber + boardSize; rowNumber++) {
            for(int columnNumber = randomColumnNumber; columnNumber < randomColumnNumber + boardSize; columnNumber++) {
                if(fieldStateArray[abs(rowNumber - boardSize)][abs(columnNumber - boardSize)] == FieldState.EMPTY) {
                    return new Coordinate(abs(rowNumber - boardSize), abs(columnNumber - boardSize), fieldState);
                }
            }
        }

        return new Coordinate(-1, -1, fieldState);
    }

    private int getRandomNumber(int upperbound) {
        return new Random().nextInt(upperbound);
    }
}
