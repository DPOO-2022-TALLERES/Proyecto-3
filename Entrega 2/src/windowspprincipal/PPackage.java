package windowspprincipal;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PPackage {
	
		JFrame frame = new JFrame();
		JLabel txtName = new JLabel("Name:");
		JTextField name = new JTextField();
		
		JLabel txtDescription = new JLabel("Description:");
	    JTextField description = new JTextField();
	    
	    JButton create =  new JButton("Create");
	    
	    JRadioButton root = new JRadioButton("Root");
	    JRadioButton node  = new JRadioButton("Node");

		PPackage() {
		frame.setSize(300,300);
		frame.setTitle("Package");
		frame.setLayout(new GridLayout(4,1));
		frame.setResizable(false);
		
		
		frame.add(txtName);
		frame.add(name);
		frame.add(txtDescription);
		frame.add(description);
		frame.add(root);
		frame.add(node);
		frame.add(create);
		
		
		frame.setVisible(true);
		
	}
	

}
