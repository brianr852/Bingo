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
public class BingoCard 
{
	private TreeSet<Character> bingoChars;
	private HashMap<Character, TreeSet<Integer>> card;
    public final static String BINGO_KEYS = "BINGO";
    public final static int MAX_VALUES_PER_LETTER = 15;
    public final static int NUMBERS_PER_LETTER = 5;

	public BingoCard()
	{
        this.bingoChars = new TreeSet<Character>();
        this.card = new HashMap<Character, TreeSet<Integer>>();
        TreeSet<Integer> values;
        int numbers;

        for (int i = 0; i < this.BINGO_KEYS.length(); i++)
        {
            values = new TreeSet<Integer>();
            while( values.size() < this.NUMBERS_PER_LETTER)
            {
                numbers = (new Random().nextInt(this.MAX_VALUES_PER_LETTER) +
                          (i * this.MAX_VALUES_PER_LETTER)) + 1;
                values.add(numbers);
            }
            this.card.put(this.BINGO_KEYS.charAt(i), values);
        }
        printCard();
	}

	public void checkNumber(BingoChip chip)
	{
        char marker = chip.getLetter();
        TreeSet<Integer> values = this.card.get(marker);

            if (this.card.get(chip.getLetter()).contains(chip.getNumber()))
            {
                this.bingoChars.add(marker);
                values.add(0);
            }
        }

	
	public boolean isWinner()
    {
        boolean winner = false;

        if (this.bingoChars.size() == this.NUMBERS_PER_LETTER)
        {
           winner = true;
        }
        return winner;
    }
	
	public void printCard()
    {
        for (int i = 0; i < BINGO_KEYS.length(); i++)
        {
            Iterator<Integer> iterator = this.card.get(this.BINGO_KEYS.charAt(i)).iterator();
            System.out.printf("%s ", this.BINGO_KEYS.charAt(i));
            while (iterator.hasNext())
            {
                System.out.printf("%2d ", iterator.next());
            }

            System.out.println();
        }
    }
}


