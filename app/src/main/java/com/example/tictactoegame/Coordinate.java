package com.example.tictactoegame;

public class Coordinate {
    private int m_rowNumber;
    private int m_columnNumber;
    private FieldState m_fieldState;

    public Coordinate(int rowNumber, int columnNumber, FieldState fieldState) {
        m_rowNumber = rowNumber;
        m_columnNumber = columnNumber;
        m_fieldState = fieldState;
    }

    public int getRowNumber() {
        return m_rowNumber;
    }

    public int getColumnNumber() {
        return m_columnNumber;
    }

    public FieldState getFieldState() {
        return m_fieldState;
    }
}
