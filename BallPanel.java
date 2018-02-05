import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BallPanel extends JPanel {
	
	public int hamx = 300;
	public int hamy = 300;
	public int peterx;
	public int petery;
	public int score = 0;
	public int sx;
	public int sy;
	Random rand = new Random();
	Random rand2 = new Random();
	protected int ballX = 250;
	public int count = 0;
	protected int ballY = 250;
	private int ballDiameter = 50;
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image5;
	private BufferedImage image6;
	private BufferedImage image7;
	private BufferedImage peterdown;
	public BufferedImage image4;
	private BufferedImage currentImage2;
	Boolean bool = true;
	public String inputValue;
	public int level;
	private BufferedImage currentImage = image1;
	private BufferedImage leftwalk;
	boolean bool2 = true;
	private BufferedImage currentImage5;
	boolean bool3 = true;
	private BufferedImage peterupdown;
	private BufferedImage currentImage8;
	private BufferedImage wound;
	private BufferedImage plusone;
	int timefactor;

	private double ballXSpeed = 5;
	private double ballYSpeed = 10;
	public int life = 3;
	public int time = 0;
	Random r;
	Random r2;

	public void ResetGame() {
		count = 0;
		hamx = r.nextInt(540);
		hamy = r2.nextInt(550);
		peterx = rand.nextInt(580);
		petery = rand2.nextInt(575);
		score = 0;
		life = 3;
		time = 0;
		repaint();
	}

	public void resetIt() {
		if (peterx <= ballX + 60 && petery <= ballY + 60
				&& peterx >= ballX - 60 && petery >= ballY - 60) {
			if (score % 5 == 0) {
				score++;
				level++;
			}
			life--;
			r = new Random();
			r2 = new Random();
			peterx = r.nextInt(600);
			petery = r2.nextInt(600);
			repaint();
		}
		if (peterx <= hamx + 45 && petery <= hamy + 45 && peterx >= hamx - 45
				&& petery >= hamy - 45) {
			score++;
			r = new Random();
			r2 = new Random();
			hamx = r.nextInt(595);
			hamy = r2.nextInt(520);
			repaint();
		}
		if (peterx >= 580) {
			peterx -= 10;
		}
		if (petery >= 490) {
			petery -= 10;
		}
		if (peterx <= -30) {
			peterx += 10;
		}
		if (petery <= -10) {
			petery += 10;
		}
		if (life <= 0) {

			Object[] possibleValues = { "Close", "Restart" };
			Object selectedValue = JOptionPane.showInputDialog(null,
					"You got: " + score + " point(s)", "You Lose!",
					JOptionPane.INFORMATION_MESSAGE, null, possibleValues,
					possibleValues[0]);
			if (selectedValue == possibleValues[0]) {
				System.exit(0);
			}
			if (selectedValue == possibleValues[1]) {
				ResetGame();
			}
		}
	}

	public BallPanel() {
		try {

			image1 = ImageIO.read(new File(
					"/Users/MWaldman/Desktop/hungrypeter/petergriffin2.png"));
			image2 = ImageIO.read(new File(
					"/Users/MWaldman/Desktop/hungrypeter/cheeseburger2.png"));
			image3 = ImageIO.read(new File(
					"/Users/MWaldman/Desktop/hungrypeter/SpikeBall.png"));
			image5 = ImageIO.read(new File(
					"/Users/MWaldman/Desktop/hungrypeter/BrickWall2.jpg"));
			image6 = ImageIO.read(new File(
					"/Users/MWaldman/Desktop/hungrypeter/petergriffin3.png"));
			
			currentImage2 = ImageIO.read(new File(
					"/Users/MWaldman/Desktop/hungrypeter/petergriffinleft.png"));
			leftwalk = ImageIO.read(new File(
					"/Users/MWaldman/Desktop/hungrypeter/petergriffinleftwalk.png"));
			peterdown = ImageIO.read(new File(
					"/Users/MWaldman/Desktop/hungrypeter/peterdown.png"));
			wound = ImageIO
					.read(new File("wound.png"));


			currentImage = image1;

		} catch (Exception e) {
			System.out.println("could not load image");
		}

	}

	KeyListener kw = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			int k = e.getKeyCode();
			if (k == KeyEvent.VK_UP) {
				try {
					currentImage8 = ImageIO.read(new File(
							"/Users/MWaldman/Desktop/hungrypeter/peterdown.png"));
				} catch (Exception e1) {
					System.out.println("Down img not received");
				}
				bool3 = !bool3;
				currentImage = (bool3) ? peterdown : currentImage8;
				petery = petery - 15;
				resetIt();
				repaint();
			}
			if (k == KeyEvent.VK_DOWN) {
				try {
					currentImage8 = ImageIO.read(new File(
							"/Users/MWaldman/Desktop/hungrypeter/peterdown.png"));
				} catch (Exception e1) {
					System.out.println("Down img not received");
				}
				bool3 = !bool3;
				currentImage = (bool3) ? peterdown : currentImage8;
				petery = petery + 15;
				resetIt();
				repaint();
			}
			if (k == KeyEvent.VK_LEFT) {
				try {
					currentImage5 = ImageIO.read(new File(
							"/Users/MWaldman/Desktop/hungrypeter/petergriffinleft.png"));
				} catch (IOException e1) {
					System.out.print("did not receive image");
					e1.printStackTrace();
				}
				bool2 = !bool2;
				currentImage = (bool2) ? currentImage5 : leftwalk;
				peterx = peterx - 15;
				resetIt();
				repaint();
			}
			if (k == KeyEvent.VK_RIGHT) {

				bool = !bool;
				currentImage = (bool) ? image1 : image6;
				peterx = peterx + 15;
				resetIt();
				repaint();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	};

	public void step() {
		resetIt();
		ballX += ballXSpeed;
		if (ballX < 0 || ballX > getWidth() - ballDiameter) {
			ballXSpeed *= -1;
		}

		ballY += ballYSpeed;
		if (ballY < 0 || ballY > getHeight() - ballDiameter) {
			ballYSpeed *= -1;
		}

		// tell this JPanel to repaint itself since the ball has moved
		repaint();
	}

	// paint the ball
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image5, 0, 0, null);
		g.drawString("MW Games", 520, 595);
		g.setColor(Color.white);
		g.drawString("Score:" + score, 50, 20);
		g.setColor(Color.white);
		g.drawString("lives:" + Integer.toString(life), 575, 20);
		g.drawString("Time:" + Integer.toString(time / 30), 415, 20);
		g.setColor(Color.white);
		g.drawImage(currentImage, peterx, petery, null);
		if (life <= 2) {
			g.drawImage(wound, peterx + 40, petery + 55, null);
		}
		if (life <= 1) {
			g.drawImage(wound, peterx + 55, petery + 60, null);
		}
		if (life <= 0) {
			g.drawImage(wound, peterx + 45, petery + 80, null);
		}
		g.drawImage(image2, hamx, hamy, null);
		g.drawImage(image3, ballX, ballY, null);

		repaint();

	}

}
