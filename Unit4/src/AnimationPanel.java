import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AnimationPanel extends JPanel implements KeyListener, MouseListener {

    // put class & instance variables to control animation here
    final static int X_DIMEN = 500;
    final static int Y_DIMEN = 500;
    static int gridSize = 10;
    final static int X_ARR_LEN = X_DIMEN / gridSize;
    final static int Y_ARR_LEN = Y_DIMEN / gridSize;
    final static int NUM_SQUARES = (Y_DIMEN / gridSize) * (X_DIMEN / gridSize);
    int[][] grid;
    int fps = 3;
    boolean quit = false;

    public void resetAnimation(int div, int mult) {
        if (!quit)
            quit = true;
        grid = new int[Y_ARR_LEN][X_ARR_LEN];
        for (int n = 0; n < (mult * (NUM_SQUARES / div)); n++) {
            int ranNum1 = (int) (Math.random() * Y_ARR_LEN);
            int ranNum2 = (int) (Math.random() * X_ARR_LEN);
            grid[ranNum1][ranNum2] = 1;
        }
        repaint();
    }

    public AnimationPanel(int w, int h) {
        setPreferredSize(new Dimension(X_DIMEN, Y_DIMEN));
        setBackground(Color.WHITE);
        grid = new int[Y_ARR_LEN][X_ARR_LEN];
        resetAnimation(1, 1);
        addKeyListener(this);
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawCells(g);
        // draw background BufferedImage here
        // draw foreground objects here
    }

    public void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int row = 0; row <= Y_DIMEN; row += gridSize) {
            g.drawLine(0, row, X_DIMEN, row);
        }
        for (int col = 0; col <= X_DIMEN; col += gridSize) {
            g.drawLine(col, 0, col, Y_DIMEN);
        }
    }

    public void drawCells(Graphics g) {
        int len = grid.length;
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    g.setColor(Color.BLUE);
                } else if (grid[row][col] == 2) {
                    g.setColor(Color.GREEN);
                } else if (grid[row][col] == 3) {
                    g.setColor(Color.YELLOW);
                } else if (grid[row][col] == 4) {
                    g.setColor(Color.ORANGE);
                } else if (grid[row][col] > 4) {
                    g.setColor(Color.RED);
                }
                if (grid[row][col] > 0) {
                    int xCoord = (int) (col * gridSize + gridSize * 1 / 4);
                    int yCoord = (int) (row * gridSize + gridSize * 1 / 4);
                    g.fillRect(xCoord, yCoord, gridSize * 3 / 4, gridSize * 3 / 4);
                }
            }
        }
    }

    public int[][] updateCells(int[][] cells) {
        int[][] newGrid = new int[Y_ARR_LEN][X_ARR_LEN];
        for (int row = 0; row < cells.length; row++) { // row iteration
            for (int col = 0; col < cells[row].length; col++) { // column iteration
                int neighbors = 0;
                for (int r = -1; r < 2; r++) { // iterate through row offset
                    for (int c = -1; c < 2; c++) { // col offset
                        int rowNeigh = (row + r + Y_ARR_LEN) % Y_ARR_LEN;
                        int colNeigh = (col + c) % X_ARR_LEN;
                        if (colNeigh < 0) { // special case to check
                            colNeigh = X_ARR_LEN + colNeigh;
                        }
                        if (cells[rowNeigh][colNeigh] > 0) {
                            neighbors++;
                        }
                        if (r == 0 && c == 0 && cells[rowNeigh][colNeigh] >= 1) { // dont count center
                            neighbors--;
                        }
                    }
                }
                newGrid[row][col] = neighbors;
            }
        }
        for (int row = 0; row < newGrid.length; row++) { // go through 2d arr, apply rules
            for (int col = 0; col < newGrid[row].length; col++) {
                if (newGrid[row][col] == 3 && cells[row][col] == 0) {
                    newGrid[row][col] = 1;
                } else if ((newGrid[row][col] == 2 || newGrid[row][col] == 3) && cells[row][col] != 0) {
                    newGrid[row][col] = cells[row][col] + 1;
                } else{
                    newGrid[row][col] = 0;
                }
            }
        }
        return newGrid;
    }

    public void run() {
        while (true) {
            if (!quit) {
                repaint();
                grid = updateCells(grid);
            }
            delay(1000 / fps);
        }
    }

    public void delay(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (quit) {
                quit = false;
            }
            fps--;
            if (fps <= 0) {
                fps = 1;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!quit) {
                quit = true;
            } else {
                quit = false;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (quit) {
                quit = false;
            }
            fps++;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (!quit) {
                quit = true;
            }
            repaint();
            grid = updateCells(grid);
        }
        if (e.getKeyChar() == '1') {
            resetAnimation(10, 1);
        }
        if (e.getKeyChar() == '2') {
            resetAnimation(4, 1);
        }
        if (e.getKeyChar() == '3') { 
            resetAnimation(2, 1);
        }
        if (e.getKeyChar() == '4') {
            resetAnimation(4, 3);
        }
    }

    public void mouseClicked(MouseEvent e) {
        int pressX = e.getX() / gridSize;
        int pressY = e.getY() / gridSize;
        grid[pressY][pressX]++;
        repaint();
    }
    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
}