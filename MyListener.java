
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener extends BallPanel implements ActionListener{
		
	private BallPanel ballPanel;
	
	public MyListener(BallPanel ballPanel){
		this.ballPanel = ballPanel;
	}

	public void actionPerformed(ActionEvent e) {
        ballPanel.time++;
		ballPanel.step();
	}
}
