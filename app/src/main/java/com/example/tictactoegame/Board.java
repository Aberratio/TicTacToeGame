package com.example.tictactoegame;

public class Board {
    public FieldState[][] m_fieldStateArray;
    public int BOARD_SIZE = 10;

    public Board() {
        m_fieldStateArray = new FieldState[BOARD_SIZE][BOARD_SIZE];
        emptyAllBoardValues();
    }

    public void emptyAllBoardValues() {
        for(int rowNumber = 0; rowNumber < BOARD_SIZE; rowNumber++) {
            for(int columnNumber = 0; columnNumber < BOARD_SIZE; columnNumber++) {
                m_fieldStateArray[rowNumber][columnNumber] = FieldState.EMPTY;
            }
        }
    }

    public GameState getGameState() {
        if (isPlayerWinner(FieldState.CROSS)) {
            return GameState.CROSS_WINS;
        } else if (isPlayerWinner(FieldState.CIRCLE)) {
            return GameState.CIRCLE_WINS;
        } else if (isBoardFull()) {
            return GameState.DRAW;
        }

        return GameState.DURING;
    }

    public boolean changeFieldState(Coordinate coordinate) {
        if(m_fieldStateArray[coordinate.getRowNumber()][coordinate.getColumnNumber()] == FieldState.EMPTY) {
            m_fieldStateArray[coordinate.getRowNumber()][coordinate.getColumnNumber()] = coordinate.getFieldState();
            return true;
        }

        return false;
    }

    private boolean isPlayerWinner(FieldState state) {
        int successCounter = 0;

        for(int rowNumber = 0; rowNumber < BOARD_SIZE; rowNumber++) {
            for(int columnNumber = 0; columnNumber < BOARD_SIZE; columnNumber++) {
                if(m_fieldStateArray[rowNumber][columnNumber] == state) {
                    successCounter++;
                    if (successCounter == 5) {
                        return true;
                    }
                } else {
                    successCounter = 0;
                }
            }
        }

        return false;
    }

    private boolean isBoardFull() {
        for(int rowNumber = 0; rowNumber < BOARD_SIZE; rowNumber++) {
            for(int columnNumber = 0; columnNumber < BOARD_SIZE; columnNumber++) {
                if(m_fieldStateArray[rowNumber][columnNumber] == FieldState.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
