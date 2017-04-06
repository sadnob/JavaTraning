package interpret;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class InterpretMain extends JFrame{

	int frameWidth = 700;
	int frameHeight = 700;

	public InterpretMain() {
		super();
		setMinimumSize(new Dimension(frameHeight, frameWidth));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(new MainPanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
	}

	public static void main(String[] args) {
		InterpretMain mp =new InterpretMain();


	}

}
