/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

/**
 *
 * @author brian
 */
import java.util.*;

public class BingoGame 
{
	private final int NUM_OF_CHIPS = 75;
	private int numOfPlayers;
	private ArrayList<BingoChip> bingoDrum;
	private BingoCard[] playersCards;

	public BingoGame(int numOfPlayers) 
	{
        setNumOfPlayers(numOfPlayers);
        createBingoDrum();
        createPlayersCards();
	}
	
	private void createBingoDrum()
	{
        this.bingoDrum = new ArrayList<BingoChip>();
        for ( int i = 1; i < this.NUM_OF_CHIPS; i++)
        {
            this.bingoDrum.add(new BingoChip(i));
        }
	}
	
	private void createPlayersCards()
	{
        this.playersCards = new BingoCard[this.numOfPlayers];
        for (int i = 0; i < this.playersCards.length; i++)
        {
            System.out.println("---> Creating bingo card for Player " + (i + 1));
            this.playersCards[i] = new BingoCard();
            System.out.println();
        }
	}
	
	private void setNumOfPlayers(int numOfPlayers)
	{
        this.numOfPlayers = numOfPlayers;
    }

	public int getNumberOfChips()
	{
		return this.bingoDrum.size();
	}

	public BingoChip pullChip()
	{
		return this.bingoDrum.remove(new Random().nextInt(this.bingoDrum.size()));
	}
	
	public void play()
	{
        BingoChip chip;
        boolean done = false;

        while(!done)
        {
            chip = pullChip();
            System.out.println( "---> Calling: " + chip.toString());
            for (int i = 0; i < this.playersCards.length;i++)
            {
                System.out.println("Player's " + ( i + 1) + " card:");
                this.playersCards[i].printCard();
                this.playersCards[i].checkNumber(chip);

                if (this.playersCards[i].isWinner())
                {
                    System.out.println("!!! Player " + (i + 1) + " says BINGO !!!");
                    done = true;
                }
                System.out.println();
            }
        }
        System.out.println(NUM_OF_CHIPS - getNumberOfChips() + " chips were called");
	}
}
