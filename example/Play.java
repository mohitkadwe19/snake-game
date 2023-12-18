package example;

import example.constant.ImageUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

/**
 * The main game class for the snake game.
 * Handles game state and rendering the game elements.
 */
public class Play extends MyFrame {

	private static final long serialVersionUID = -3641221053272056036L;

	public MySnake mySnake = new MySnake(100, 100);

	public Food food = new Food();

	public Image background = ImageUtil.images.get("UI-background");

	public Image restartGame = ImageUtil.images.get("restart-game");

	public Image  startGame = ImageUtil.images.get("start-game");

	public Image resumeGame = ImageUtil.images.get("resume-game");

	public Image pauseGame = ImageUtil.images.get("pause-game");

	private final int buttonWidth = 80;

	private final int buttonHeight = 40;

	public static int game_change = 0;

	private int highScore = 0;

	/**
	 * Handles keyboard input to change
	 * the direction of the snake.
	 *
	 * @param e the KeyEvent triggered
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		mySnake.keyPressed(e);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, null);

		if(game_change == 0){
			drawStartButton(g);
		} else if (game_change == 1) {
			drawPauseButton(g);
		} else if (game_change == 2) {
			drawResumeButton(g);
		}

		 if (mySnake.l) {
			 if(game_change == 1) {
				 mySnake.draw(g);
				 if (food.l) {
					 food.draw(g);
					 food.eaten(mySnake);
				 } else {
					 food = new Food();
				 }
			 }
		 } else {
			 g.drawImage(restartGame, 410, 250, buttonWidth, buttonHeight, null);
		 }
		 drawScore(g);
	}

	/**
	 * Restarts the game by resetting the snake
	 * and clearing previous body points.
	 */

	public void restart() {
		mySnake = new MySnake(100, 100);
		mySnake.changeLength(1);  // Reset the length of the snake
		mySnake.bodyPoints.clear();  // Clear the list of body points
	}

	/**
	 * Draws the current score and high score
	 * on the screen.
	 *
	 * @param g the Graphics object to draw with
	 */
	public void drawScore(Graphics g) {
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		g.setColor(Color.MAGENTA);
		g.drawString("SCORE : " + mySnake.score, 20, 40);

		// Display the high score
		g.setColor(Color.CYAN);
		g.drawString("HIGH SCORE : " + highScore, 300, 40);

		if (!mySnake.l) {
			updateHighScore();
		}
	}

	/**
	 * Updates the high score if the current
	 * score is higher.
	 */
	public void updateHighScore() {
		if (mySnake.score > highScore) {
			highScore = mySnake.score;
		}
	}

	public void drawStartButton(Graphics g) {
		g.drawImage(startGame, 700, 5, buttonWidth, buttonHeight, null);
	}

	public void drawResumeButton(Graphics g) {
		g.drawImage(resumeGame, 790, 5,buttonWidth-40, buttonHeight, null);
	}

	public void drawPauseButton(Graphics g) {
		g.drawImage(pauseGame, 810, 5,buttonWidth-40, buttonHeight, null);
	}

	public static void main(String[] args) {
		Play play = new Play();
		play.loadFrame();

//		MusicPlayer.getMusicPlay("example/frogger.mp3");

		// Add mouse listener to detect clicks
		play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!play.mySnake.l && e.getX() >= 410 && e.getX() <= 410 + play.restartGame.getWidth(null)
						&& e.getY() >= 250 && e.getY() <= 250 + play.restartGame.getHeight(null)) {
					play.restart();
					play.updateHighScore();
				}
			}
		});

		play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getX() >= 700 && e.getX() <= 700 + play.startGame.getWidth(null)
						&& e.getY() >= 5 && e.getY() <= 5 + play.startGame.getHeight(null)) {
					game_change = 1;
				}
			}
		});

		play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getX() >= 790 && e.getX() <= 790 + play.pauseGame.getWidth(null)
						&& e.getY() >= 5 && e.getY() <= 5 + play.pauseGame.getHeight(null)) {
					game_change = 1;
				}
			}
		});

		play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getX() >= 810 && e.getX() <= 810 + play.resumeGame.getWidth(null)
						&& e.getY() >= 5 && e.getY() <= 5 + play.resumeGame.getHeight(null)) {
					game_change = 2;
				}
			}
		});
	}
}

