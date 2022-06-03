package windowspprincipal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import vista.FPrincipal;

public class PTask extends JFrame implements ActionListener{
	
	
	JLabel txtName = new JLabel("Name:");
	JTextField name = new JTextField();
	
	JLabel txtDescription = new JLabel("Description:");
    JTextField description = new JTextField();
    
    JLabel txtType = new JLabel("Type:");
    JTextField type = new JTextField();
    
    JLabel txtTime = new JLabel("Time:");
    JTextField time  = new JTextField();
    
    JLabel txtDate = new JLabel("Finish Date: (yyyy-mm-dd)");
    JTextField date  = new JTextField();
    
    
    JButton create =  new JButton("Create");
    
    String selection;
    FPrincipal principal;

	

	
	PTask(String selection, FPrincipal principal) {
		this.selection = selection;
		this.principal = principal;
		
		this.setLocationRelativeTo(null);
		this.setSize(340,300);
		this.setTitle("Task");
	    this.setLayout(new GridLayout(6,1));
		this.setResizable(false);
		
		
		this.add(txtName);
		this.add(name);
		this.add(txtDescription);
		this.add(description);
		this.add(txtType);
		this.add(type);
		this.add(txtTime);
		this.add(time);
		this.add(txtDate);
		this.add(date);
		this.add(create);
		create.addActionListener(this);
		
		this.setVisible(true);
	
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == create) {
			if (time.getText().equals("") || date.getText().equals("")) {
				this.principal.getAplicacion().addTask(selection, name.getText(), description.getText(), type.getText().strip());
				JOptionPane.showMessageDialog(this, "Created Task Succesfully!. Remember you can add time and date later!");
	
			}
			else {
				this.principal.getAplicacion().addTask(selection, name.getText(), description.getText(), type.getText().strip());
				this.principal.getAplicacion().setEFTTask(name.getText(), time.getText());
				this.principal.getAplicacion().setEFDTask(name.getText(), date.getText());
				JOptionPane.showMessageDialog(this, "Created Task Succesfully!");
				
			}
				
			
		}
		
	}
	
	

}
