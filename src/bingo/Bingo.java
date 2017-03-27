/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.Scanner;

/**
 *
 * @author brian
 */
public class Bingo {

    public static void main(String[] args) 
    {
            System.out.println("---> Setting up bingo game.");

            Scanner scan = new Scanner(System.in);
            int numOfPlayers;
            do
            {
                    System.out.println("Enter number of players.");
                    numOfPlayers = scan.nextInt();
            }while (numOfPlayers < 1);

            BingoGame game = new BingoGame(numOfPlayers);

            System.out.println("---> Starting the game with " + numOfPlayers + " players:");
            System.out.println("     *********************************\n");
            game.play();
    }
}
