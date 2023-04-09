import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class BlackjackPanel extends JPanel implements KeyListener {
    static final long serialVersionUID = 1;
    private int fps = 10;
    private String state;
    private char userInput;
    private Deck d;
    private BlackjackPlayer dealer;
    private BlackjackPlayer player1;
    private List<BlackjackPlayer> playerList;
    private int gameRound;
    private final static int CARD_WIDTH = 256;
    private final static int CARD_HEIGHT = 372;
    private double cardRatio = .25;

    public BlackjackPanel() {
        setPreferredSize(new Dimension(600, 400));
        Color greenBackground = new Color(91, 170, 128);
        setBackground(greenBackground);
        userInput = ' ';
        d = new Deck();
        dealer = new BlackjackPlayer("Mr. Culbertson", 0, 0);
        player1 = new BlackjackPlayer("Zachary", 0, 0);
        playerList = new ArrayList<BlackjackPlayer>();
        playerList.add(dealer);
        playerList.add(player1);
        addKeyListener(this);
        gameRound = 0;
        state = "READY";
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yStart = 15;
        int width = (int) (CARD_WIDTH * cardRatio);
        int height = (int) (CARD_HEIGHT * cardRatio);
        int spacer = 20;
        int xStart = 10;
        g.drawString("Game: " + (gameRound), xStart, yStart);

        for (int r = 0; r < playerList.size(); r++) {
            BlackjackPlayer user = playerList.get(r);
            String infoStr = String.format(user.name + " score %d W:%d L:%d ",
                    user.getScore(), user.getWins(), user.getLosses());
            yStart += spacer;
            g.drawString(infoStr, xStart, yStart);
            yStart += spacer;
            int handSize = playerList.get(r).hand.size();
            for (int c = 0; c < handSize; c++) {
                BufferedImage cardFace = user.hand.get(c).getFace();
                g.drawImage(cardFace, xStart, yStart, width, height, null);
                xStart += width + spacer;
            }
            yStart += (height + spacer);
            xStart = 10;
        }
    }

    public void update() {
        if (state.equals("READY")) {
            if (userInput == 'd') {
            userInput = ' ';
            gameRound++;
            dealer.emptyHand();
            player1.emptyHand();
            if (d.getCardsLeft() < 15) {
                System.out.println("Re-adding deck and reshuffling ");
                List<Card> dealHand = dealer.emptyHand();
                List<Card> player1Hand = player1.emptyHand();
                d.combineCards(dealHand);
                d.combineCards(player1Hand);
                dealer.clearCardHistory();
                player1.clearCardHistory();
                d.shuffle();
            }
            state = "DEALING";
            }
        } else if (state.equals("DEALING")) {
            d.shuffle();
            dealer.take(d.deal());
            player1.take(d.deal());
            player1.take(d.deal());
            state = "P1_TURN";
        } else if (state.equals("P1_TURN")) {
            if (player1.getScore() > 21) {
                state = "SHOW";
            } else if (userInput == 'h') {
                userInput = ' ';
                player1.take(d.deal());
            } else if (userInput == 's') {
                state = "DEALERS_TURN";
            }
        } else if (state.equals("DEALERS_TURN")) {
            if (dealer.getScore() <= 16) {
                dealer.take(d.deal());
            } else if (dealer.getScore() > 16) {
                state = "SHOW";
            }
        } else if (state.equals("SHOW")) {
            System.out.println(dealer.name + " " + dealer.getScore());
            System.out.println(player1.name + " " + player1.getScore());
            if (player1.getScore() > 21 || (dealer.getScore() > player1.getScore() && dealer.getScore() <= 21)) {
                System.out.println(dealer.name + " wins ");
                dealer.addWins(1);
                player1.addLosses(1);
            } else if (player1.getScore() == dealer.getScore()) {
                if (player1.hand.size() == 2 && dealer.hand.size() != 2) {
                    player1.addWins(1);
                    dealer.addLosses(1);
                } else if (dealer.hand.size() == 2 && player1.hand.size() != 2) {
                    player1.addLosses(1);
                    dealer.addWins(1); 
                }
                System.out.println("Tie - no one wins ");
            } else if (player1.getScore() > dealer.getScore() || dealer.getScore() > 21) {
                System.out.println(player1.name + " wins ");
                if (player1.hand.size() == 2) {
                    player1.addWins(1);
                } else {
                    player1.addWins(1);
                }
                dealer.addLosses(1);
            }
            System.out.println();
            state = "READY";
        }
    }

    public void run() {
        while (true) {
        update();
        repaint();
        delay(1000 / fps);
        }
        // for (int i = 0; i < 100; i++) {
        //     for (int j = 0; j < 100; j++) {
        //         update();
        //         // repaint();
        //         // System.out.println(i);
        //         // delay(1000 / fps);
        //     }
        //     double edgeValue = ((double) player1.getWins() - player1.getLosses()) / this.gameRound;
        //     System.out.println(edgeValue);
        // }
    }

    public void delay(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        userInput = e.getKeyChar();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // unused
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // unused
    }
}