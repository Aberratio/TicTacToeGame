package com.example.tictactoegame;

public class Coordinate {
    private int rowNumber;
    private int columnNumber;
    private FieldState fieldState;

    public Coordinate(int rowNumber, int columnNumber, FieldState fieldState) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.fieldState = fieldState;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public FieldState getFieldState() {
        return fieldState;
    }
}
