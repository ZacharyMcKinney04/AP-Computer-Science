public class CardTestUnit {

    public static void main(String[] args) {
        Card card = new Card(11, 0);
        System.out.print("Jack Of Clubs ");
        System.out.println("Jack of Clubs".equals(card.toString()));
        System.out.println();
        card = new Card(4, 1);
        System.out.print("4 of Diamonds ");
        System.out.println("4 of Diamonds".equals(card.toString()));
        System.out.println();
        card = new Card(13, 3);
        System.out.print("King of Spades ");
        System.out.println("King of Spades".equals(card.toString()));
        System.out.println();
        card = new Card(1, 2);
        System.out.print("Ace of Hearts ");
        System.out.println("Ace of Hearts".equals(card.toString()));
        System.out.println();

        
        Card[] cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
        // printDeck(cards);
        
        
    }
    
    // public static void printDeck(Card[] cards) {
    //     for (Card card : cards) {
    //         System.out.println(card);
    //     }
    // }
}
