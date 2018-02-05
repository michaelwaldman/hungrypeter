
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Main extends BallPanel{

	
    public static void main(String[] args) {
    	Object[] possibleValues = { "Enter Game", "Quit" };
		Object selectedValue = JOptionPane.showInputDialog(null,
				"Press arrow keys to start. Get to the burger and avoid the spiked ball", "Game Instructions",
				JOptionPane.INFORMATION_MESSAGE, null, possibleValues,
				possibleValues[0]);
		if (selectedValue == possibleValues[0]) {
		}
		if (selectedValue == possibleValues[1]) {
        System.exit(0);
		}
    	JFrame frame = new JFrame("Hungry Peter");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLayout(new BorderLayout());
    	BallPanel ballPanel = new BallPanel();
    	frame.add(ballPanel, BorderLayout.CENTER);
    	frame.addKeyListener(ballPanel.kw);
    	//pass the BallPanel instance into the MyListener constructor
    	MyListener listener = new MyListener(ballPanel);
    	//the timer fires 30 times a second
    	Timer timer = new Timer(1000/30, listener);
    	timer.start();
    	frame.setSize(650, 565);
    	frame.setLocationRelativeTo(null);
    	frame.setBackground(Color.white);
    	frame.setResizable(false);
    	frame.repaint();
    	frame.setVisible(true);
    }
    
	
}
