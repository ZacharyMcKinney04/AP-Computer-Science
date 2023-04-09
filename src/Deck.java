/**
 * @version 1.0
 * @author Zachary McKinney
 */
import java.util.List;
import java.util.ArrayList;
// import java.util.Collections;

public class Deck {
    private List<Card> cards;
    
    /**
     * Write a no- args constructor that initializes
     *  the arraylist with 52 cards with the
     * standard suits and ranks. Some of the examples
     *  in Chapter 13 of
     * the textbook may be helpful, but realize 
     * that we are using an ArrayList data structure 
     * instead of arrays as shown in the textbook.
     */
    public Deck() {
        this.cards = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                Card newCard = new Card(j, i);
                this.cards.add(newCard);
            }   
        }
    }
    
    /**
     *  Write a deal() method that removes the first card in the arraylist 
     * and returns it. Be sure to use remove() and not get()
     *  - the arraylist should have one fewer card after deal() had been invoked.
     * @return a new Card while removing this card from the arraylist.
     */
    public Card deal() {
        return this.cards.remove(0);
    }

    /**
     * 4. Write a getCardsLeft() 
     * method that returns the number of cards left
     *  in the arraylist, as an integer.
     * @return
     */
    public int getCardsLeft() {
        return this.cards.size();
    }
    
    /**
     * 5. Write a toString method that prints out all the cards, one per line.
     * Use a for-each loop to iterate across 
     * the arraylist and use \n as needed to make new lines in your returned string.
     */
    public String toString() {
        String str = new String();
        for(Card c : this.cards) {
            str = str + c.toString() +"\n";
        }
        return str;
    }


    /**
     * 6. Write a shuffle() method that randomly arranges the cards in this arraylist. 
     * Here is one fairly simple method: remove a card at a random location and
     *  place it at the end of the arraylist. Repeat about 1000 times.
     *  (52 random moves is not enough to randomize the deck - try it and see.)
     * Extra: A more efficient shuffling algorithm (called the modified Fisher-Yates shuffle) 
     * is very similar to the description above but requires only 52 steps. 
     * The wikipedia article has a good description and a step-by-step example.
     */
    public void shuffle() {
        for (int i = 0; i < 1000; i++) {
            int ranNum = (int) (Math.random() * this.cards.size());
            this.cards.add(this.cards.remove(ranNum));
        }
    }

    public void combineCards(List<Card> others) {
        this.cards.addAll(others);
    }

    public void sort() {
        Sorter.mergeSort(this.cards);
    } 

    public int linearSearch(Card search) {
        int deckSize = this.cards.size();
        for (int i = 0; i < deckSize; i++) {
            if (this.cards.get(i).compareTo(search) == 0) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(Card search) {
        int lowGuess = 0;
        int highGuess = this.cards.size() - 1;
        while (lowGuess != highGuess) {
            int guess = (lowGuess + highGuess)/2;
            if (this.cards.get(highGuess).compareTo(search) == 0) {
                return highGuess;
            } else if (this.cards.get(lowGuess).compareTo(search) == 0) {
                return lowGuess;
            } else if (this.cards.get(guess).compareTo(search) > 0) {
                highGuess = guess;
                lowGuess++;
            } else {
                lowGuess = guess;
                highGuess--;
            }
        }
       return -1;
    }

    public void removeCard(int index) {
        this.cards.remove(index);
    }

}

