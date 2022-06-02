package windowspprincipal;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class PMTask {
	
	JFrame frame = new JFrame();
	
	PMTask() {
		frame.setSize(300,300);
		frame.setTitle("Modify Task");
		frame.setLayout(new GridLayout(2,1));
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
