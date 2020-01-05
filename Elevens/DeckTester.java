/**
 * This is a class that tests the Card class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) 
	{
		String[] ranks = {"Jack", "Queen", "King", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
		int[] pointValues = {10, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Deck d = new Deck(ranks, suits, pointValues);
		System.out.println(d.deal());
		System.out.println(d.deal());
		
		System.out.println(d.isEmpty());
		System.out.println(d.toString());
	}
}
