import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
        {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
        {"spades", "hearts", "diamonds", "clubs"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 ,12 ,13};

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;


    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
     public ElevensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
     }

    /**
     * Determines if the selected cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face cards
     * whose values add to 11, and (2) a group of three cards consisting of
     * a jack, a queen, and a king in some order.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards) {
        if (selectedCards.size() == 2)
          return containsPairSum11(selectedCards);
         else if (selectedCards.size() == 3)
          return containsJQK(selectedCards);
         return false;
    }

    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible() {
       List<Integer> x = cardIndexes();
     
     for (int a = 0; a < x.size(); a++){
         for( int b = 0; b < x.size(); b++){
             for (int c = 0; c < x.size(); c++) //add up all 3 and if they = 0, then return true
                 {
                     String JQKCounter = "", JQKCounter2 = "", JQKCounter3 = "";
                     
                     if(cardAt(x.get(a)).pointValue() == 11)
                     {JQKCounter = "j";}
                     else if(cardAt(x.get(a)).pointValue() == 12)
                     {JQKCounter = "q";}
                     else if(cardAt(x.get(a)).pointValue() == 13)
                     {JQKCounter = "k";}
                     if(cardAt(x.get(b)).pointValue() == 11)
                     {JQKCounter2 = "j";}
                     else if(cardAt(x.get(b)).pointValue() == 12)
                     {JQKCounter2 = "q";}
                     else if(cardAt(x.get(b)).pointValue() == 13)
                     {JQKCounter2 = "k";}
                     if(cardAt(x.get(c)).pointValue() == 11)
                     {JQKCounter3 = "j";}
                     else if(cardAt(x.get(c)).pointValue() == 12)
                     {JQKCounter3 = "q";}
                     else if(cardAt(x.get(c)).pointValue() == 13)
                     {JQKCounter3 = "k";}
                     
                     if (JQKCounter.contains("j") && JQKCounter2.contains("q") && JQKCounter3.contains("k"))
                     return true;
                     else if (JQKCounter.contains("j") && JQKCounter2.contains("k") && JQKCounter3.contains("q"))
                     return true;
                     else if (JQKCounter.contains("q") && JQKCounter2.contains("j") && JQKCounter3.contains("k"))
                     return true;
                     else if (JQKCounter.contains("q") && JQKCounter2.contains("k") && JQKCounter3.contains("j"))
                     return true;
                     else if (JQKCounter.contains("k") && JQKCounter2.contains("j") && JQKCounter3.contains("q"))
                     return true;
                     else if (JQKCounter.contains("k") && JQKCounter2.contains("q") && JQKCounter3.contains("j"))
                     return true;
                 }
             }
         }  
         
     for(int i = 0; i < x.size(); i++) //loop checking for 2 card values to 11
         for(int e = 0; e < x.size(); e++){
             if(cardAt(x.get(i)).pointValue() + cardAt(x.get(e)).pointValue() == 11)
             return true;
         }
         return false;

    
    }

    /**
     * Check for an 11-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return true if the board entries in selectedCards
     *              contain an 11-pair; false otherwise.
     */
    private boolean containsPairSum11
    (List<Integer> selectedCards) {
        int sum = 0;
        for (int i = 0; i < selectedCards.size(); i++)
        {
            sum += cardAt(selectedCards.get(i)).pointValue();
          }
          if (sum == 11)
          return true;
          return false;
    }

    /**
     * Check for a JQK in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *              inclu   de a jack, a queen, and a king; false otherwise.
     */
    private boolean containsJQK(List<Integer> selectedCards) {
      int sum1 = 0;
      for (int i = 0; i < selectedCards.size(); i++)
      sum1 += cardAt(selectedCards.get(i)).pointValue();
     if (sum1 == 36)
     return true;
     return false;
  
    }
}
