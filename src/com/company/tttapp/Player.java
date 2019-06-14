package com.company.tttapp;

import java.util.Scanner;

public class Player {
    private int index, answer;

    public void answer(int answer) {
        this.answer = answer;
    }

    public int move() {
        while(true) {
            try {
                System.out.println("Enter cell number from 0 to 8 that is empty");

                Scanner keyboard = new Scanner(System.in);
                index = keyboard.nextInt();

                return index;

            } catch (Exception e) {
                System.out.println("Error in input!\n");
            }
        }
    }
}
