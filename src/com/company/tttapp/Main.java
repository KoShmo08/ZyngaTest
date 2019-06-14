package com.company.tttapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        do {
            TTTGame game = new TTTGame();
            game.playGame();

            System.out.println("To start new game enter: Y/y");
            Scanner keyboard = new Scanner(System.in);
            String answer = keyboard.next();
            if(!"y".equalsIgnoreCase(answer))
                return;
        } while (true);

    }
}
