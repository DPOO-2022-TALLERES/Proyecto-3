package windowspprincipal;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PTask {
	
	JFrame frame = new JFrame();
	
	JLabel txtName = new JLabel("Name:");
	JTextField name = new JTextField();
	
	JLabel txtDescription = new JLabel("Description:");
    JTextField description = new JTextField();
    
    JLabel txtType = new JLabel("Type:");
    JTextField type = new JTextField();
    
    JLabel txtTime = new JLabel("Time:");
    JTextField time  = new JTextField();
    
    JLabel txtDate = new JLabel("Finish Date:");
    JTextField date  = new JTextField();
    
    
    JButton create =  new JButton("Create");
    

	

	
	PTask() {
		frame.setSize(300,300);
		frame.setTitle("Task");
		frame.setLayout(new GridLayout(6,1));
		frame.setResizable(false);
		
		
		frame.add(txtName);
		frame.add(name);
		frame.add(txtDescription);
		frame.add(description);
		frame.add(txtType);
		frame.add(type);
		frame.add(txtTime);
		frame.add(time);
		frame.add(txtDate);
		frame.add(date);
		frame.add(create);
		
		frame.setVisible(true);
	
	}
	
	

}
