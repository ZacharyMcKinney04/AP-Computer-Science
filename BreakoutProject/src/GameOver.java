public class GameOver implements Animatable{

    boolean isGameOver;

    public GameOver() {
        this.isGameOver = false;
    }

    @Override
    public void paint (Graphics g) {
        if(isGameOver) {
            g.drawStrign("GAME OVER", 50, 200);
        }
    }

    public void setGameOver(boolean b) {
        this.isGameOver = b;
    }

    @Override
    public void update() {

    }
    
}
