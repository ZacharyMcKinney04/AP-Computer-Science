import java.util.List;
/**
 * @author Zachary McKinney
 * @version 1.0
 */

import java.util.ArrayList;

public class Player {
    protected List<Card> hand;
    protected List<Card> disCards = new ArrayList<Card>();
    protected String name;
    protected int wins;
    protected int losses;
    
    public Player(String name, int wins, int losses) {
        hand = new ArrayList<Card>();
        this.name = name;
        this.wins = wins;
        this.losses = losses;
    }
    
    public void take(Card c) {
        this.hand.add(c);
    }
    
    public int getScore() {
        return 0;
    }

    public int getWins() {
        return this.wins;
    }
    
    public int getLosses() {
        return this.losses;
    }

    public void addLosses(int losses) {
        this.losses += losses;
    }
    
    public void addWins(int wins) {
        this.wins += wins;
    }
    
    
    public String toString() {
        String str = new String();
        str = String.format("%s \n ",
        this.name);
        for (Card c : this.hand) {
            str += c.toString() + "\n ";
        }
        return str;
    }
    
    public List<Card> emptyHand() {
        disCards.addAll(this.hand);
        this.hand = new ArrayList<Card>();
        return disCards;
    }

    public void clearCardHistory() {
        disCards = new ArrayList<Card>();
    }

}
