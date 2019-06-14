package com.company.tttapp;

import java.util.*;

public class GameCanvas {

    private List<GameCell> canvas;
    private Map<String, List<GameCell>> winningLines;

    public GameCanvas() {
        initGameCanvas();
        initWinningLines();
    }

    public void markCell(int ind, String value) {
        canvas.get(ind).setCellValue(value);
    }

    public void drawCanvas(){
        System.out.println("     |     |     ");
        for (GameCell c : canvas) {
            if (c.getCellIndex() != 0){
                if (c.getCellIndex() % 3 == 0) {
                    System.out.println();
                    System.out.println("_____|_____|_____");
                    System.out.println("     |     |     ");
                }
                else
                    System.out.print("|");
            }

            if (c.isEmpty()) {
                System.out.print("  " + c.getCellIndex() + "  ");
            } else {
                System.out.print("  " + c.getCellValue() + "  ");
            }
        }
        System.out.println();
        System.out.println("     |     |     ");
    }

    public boolean isItGameWinner(int index) {
        for(String key : winningLines.keySet()) {
            if(key.contains(String.valueOf(index))) {
                List<GameCell> line = winningLines.get(key);
                if (line.get(0).equals(line.get(1)) && line.get(1).equals(line.get(2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isGameADraw() {
        for(GameCell c : canvas) {
            if(c.isEmpty())
                return false;
        }
        return true;
    }

    public List<GameCell> getCanvas() {
        return canvas;
    }

    private void initGameCanvas() {
        canvas = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            canvas.add(new GameCell(i));
        }
    }

    private void initWinningLines() {
        winningLines = new HashMap<>();
        // 3 horisontal: 0-1-2, 3-4-5, 6-7-8
        winningLines.put("012", Arrays.asList(canvas.get(0), canvas.get(1), canvas.get(2)));
        winningLines.put("345", Arrays.asList(canvas.get(3), canvas.get(4), canvas.get(5)));
        winningLines.put("678", Arrays.asList(canvas.get(6), canvas.get(7), canvas.get(8)));
        // 3 vertical: 0-3-6, 3-4-5, 6-7-8
        winningLines.put("036", Arrays.asList(canvas.get(0), canvas.get(3), canvas.get(6)));
        winningLines.put("147", Arrays.asList(canvas.get(1), canvas.get(4), canvas.get(7)));
        winningLines.put("258", Arrays.asList(canvas.get(2), canvas.get(5), canvas.get(8)));
        // 3 diagonals: 0-4-8, 2-4-6
        winningLines.put("048", Arrays.asList(canvas.get(0), canvas.get(4), canvas.get(8)));
        winningLines.put("246", Arrays.asList(canvas.get(2), canvas.get(4), canvas.get(6)));
    }

}
