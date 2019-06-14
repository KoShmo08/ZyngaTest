package com.company.tttapp;

import java.util.Random;

public class TTTGame {

    private final GameCanvas gameCanvas = new GameCanvas();
    private Player player;

    public TTTGame() {
        player = new Player();
    }

    public void playGame() {
        boolean b;
        boolean isCurrentX = false;
        int n;
        do {
            isCurrentX = !isCurrentX;
            //drawCanvas();
            gameCanvas.drawCanvas();
            if(isCurrentX) {
                n = getPlayerNumber();
            }
            else {
                n = getComputerNumber();
            }
            gameCanvas.markCell(n, isCurrentX ? "X" : "O");
            b = !gameCanvas.isItGameWinner(n);
            if(b && gameCanvas.isGameADraw()){
                System.out.println("Draw");
                gameCanvas.drawCanvas();
                return;
            }
        } while (b);
        //draw Canvas
        gameCanvas.drawCanvas();
        System.out.println();

        System.out.println((isCurrentX ? "Player" : "Computer") + " is the winner!");
    }

    private int getComputerNumber() {
        while (true) {
            Random random = new Random();
            int n = random.nextInt(8) + 0;
            if (n >= 0 && n < gameCanvas.getCanvas().size() && gameCanvas.getCanvas().get(n).isEmpty()) {
                System.out.println("Computer's move: " + n);
                return n;
            }
        }
    }

    private int getPlayerNumber() {
        while (true){
                int n = player.move();
                if (n >= 0 && n < gameCanvas.getCanvas().size() && gameCanvas.getCanvas().get(n).isEmpty()){
                    return n;
                }
                System.out.println("Choose free cell and enter its number");
        }

    }
}
