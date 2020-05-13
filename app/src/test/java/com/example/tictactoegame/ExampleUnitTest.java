package com.example.tictactoegame;

import org.junit.Test;

import java.util.InvalidPropertiesFormatException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void gameWithOnePlayerTest() {
        //Arange
        String userName = "firstPlayerName";
        String computerName = "AI_PLAYER";

        //Act
        Game game = new Game(userName);

        //Assert
        assertEquals(userName, game.m_circlePlayer.getName());
        assertEquals(computerName, game.m_crossPlayer.getName());
    }

    @Test
    public void gameWithTwoPlayersTest() {
        //Arange
        String firstUserName = "firstPlayerName";
        String secondtUserName = "secondPlayerName";

        //Act
        Game game = new Game(firstUserName, secondtUserName);

        //Assert
        assertEquals(firstUserName, game.m_circlePlayer.getName());
        assertEquals(secondtUserName, game.m_crossPlayer.getName());
    }

    @Test
    public void duringStateTest() {
        //Arange
        Board board = new Board();

        //Act
        board.emptyAllBoardValues();

        //Assert
        assertEquals(GameState.DURING, board.getGameState());
    }

    @Test
    public void crossWinsTest() {
        //Arange
        Board board = new Board();

        //Act
        for(int i = 0; i < board.BOARD_SIZE; i++) {
            for(int j = 0; j < board.BOARD_SIZE; j++) {
                board.m_fieldStateArray[i][j] = FieldState.CROSS;
            }
        }

        //Assert
        assertEquals(GameState.CROSS_WINS, board.getGameState());
    }

    @Test
    public void circleWinsTest() {
        //Arange
        Board board = new Board();

        //Act
        for(int i = 0; i < board.BOARD_SIZE; i++) {
            for(int j = 0; j < board.BOARD_SIZE; j++) {
                board.m_fieldStateArray[i][j] = FieldState.CIRCLE;
            }
        }

        //Assert
        assertEquals(GameState.CIRCLE_WINS, board.getGameState());
    }

    @Test
    public void isGameDrawTest() {
        //Arange
        Board board = new Board();
        boolean helper = true;

        //Act
        for(int i = 0; i < board.BOARD_SIZE; i++) {
            for(int j = 0; j < board.BOARD_SIZE; j++) {
                if(helper) {
                    board.m_fieldStateArray[i][j] = FieldState.CIRCLE;
                    helper = false;
                } else {
                    board.m_fieldStateArray[i][j] = FieldState.CIRCLE;
                    helper = true;
                }
            }
            helper = !helper;
        }

        //Assert
        assertEquals(GameState.DRAW, board.getGameState());
    }

    @Test
    public void isBoardEmptyTest() {
        //Arange
        Board board = new Board();

        //Act
        board.emptyAllBoardValues();

        //Assert
        for(int i = 0; i < board.BOARD_SIZE; i++) {
            for(int j = 0; j < board.BOARD_SIZE; j++) {
                assertEquals(FieldState.EMPTY, board.m_fieldStateArray[i][j]);
            }
        }
    }

    @Test
    public void changeFieldStateTest() {
        //Arange
        Board board = new Board();
        int firstNumber = 5;
        int secondNumber = 7;
        Coordinate firstCoordinate = new Coordinate(firstNumber, secondNumber, FieldState.CIRCLE);
        Coordinate secondCoordinate = new Coordinate(secondNumber, firstNumber, FieldState.CROSS);

        //Act
        board.emptyAllBoardValues();
        board.changeFieldState(firstCoordinate);
        board.changeFieldState(secondCoordinate);

        //Assert
        assertEquals(FieldState.CIRCLE, board.m_fieldStateArray[firstNumber][secondNumber]);
        assertEquals(FieldState.CROSS, board.m_fieldStateArray[secondNumber][firstNumber]);
    }

    @Test
    public void getComputerMoveTest() {
        //Arange
        I_Player player = new ComputerPlayer(FieldState.CROSS);
        Board board = new Board();

        //Act
        Coordinate coordinate = player.getMove(board);

        //Assert
        assertTrue(coordinate.getColumnNumber() < board.BOARD_SIZE && coordinate.getColumnNumber() >= 0);
        assertTrue(coordinate.getRowNumber() < board.BOARD_SIZE && coordinate.getRowNumber() >= 0);
        assertEquals(FieldState.CROSS, coordinate.getFieldState());
    }
}