public class BlackjackPlayer extends Player {
    public BlackjackPlayer(String name, int wins, int losses) {
        super(name, wins, losses);
    }

    public Card[] show() {
        return null;
    }

    @Override
    public int getScore() {
        int score = 0;
        boolean hasAce = false;
        for (Card c : hand) {
            if (c.getRank() >= 11) {
                score += 10;
            } else if (c.getRank() == 1) {
                score += 1;
                hasAce = true;
            } else {
                score += c.getRank();
            }
        }
        if (score + 10 <= 21 && hasAce) {
            score += 10;
        }
        return score;
    }

}