package com.company.tttapp;

public class GameCell {

    private final static String EMPTY_CELL_VALUE = "*";
    private final int cellIndex;
    private String cellValue;

    public GameCell(int index) {
        this.cellIndex = index;
        this.cellValue = EMPTY_CELL_VALUE;
    }

    public void setCellValue(String cellValue) {
        this.cellValue = cellValue;
    }

    public int getCellIndex() {
        return cellIndex;
    }

    public String getCellValue() {
        return cellValue;
    }

    public boolean isEmpty(){
        return this.cellValue.equals(EMPTY_CELL_VALUE);
    }

    public boolean equals(GameCell c2) {
        return this.getCellValue().equals(c2.getCellValue());
    }
}
