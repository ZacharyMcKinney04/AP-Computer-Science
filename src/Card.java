import java.awt.image.BufferedImage;
import java.io.File;
// import java.io.IOException;
import javax.imageio.ImageIO;

public class Card implements Comparable<Card>{
    private final int rank;
    private final int suit;
    private BufferedImage face;
    private static BufferedImage back;
    public static final String[] RANKS = { null, "Ace", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "Jack", "Queen", "King" };
    public static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };

    static {
        String filename = "card images/back01.png";
        try {
            back = ImageIO.read(new File(filename));
        } catch (Exception e) {
            back = null;
            System.err.println(e + " file:" + filename);
        }
    }
    
    public Card(int rank, int suit) {
        if (rank < 1 || rank > 13) {
            throw new IllegalArgumentException("Invalid rank: " + rank);
        }
        if (suit < 0 || suit > 3) {
            throw new IllegalArgumentException("Invalid suit: " + suit);
        }
        this.rank = rank;
        this.suit = suit;

        int cardNum = (this.rank - 1) * 4 + (this.suit + 1);
        String filename = String.format("card images/card%02d.png", cardNum);
        try {
            face = ImageIO.read(new File(filename));
        } catch (Exception e) {
            face = null;
            System.err.println(e + " file:" + filename);
        }
    }

    public String toString() {
        String s = RANKS[this.rank] + " of " + SUITS[this.suit];
        return s;
    }

    public boolean equals(Card that) {
        return this.rank == that.rank
                && this.suit == that.suit;
    }

    public int compareTo(Card that) {
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        return 0;
    }

    public int getRank() {
        return this.rank;
    }

    public int getSuit() {
        return this.suit;
    }

    public BufferedImage getFace() {
        return this.face;
    }

    public static BufferedImage getBack() {
        return Card.back;
    }
}