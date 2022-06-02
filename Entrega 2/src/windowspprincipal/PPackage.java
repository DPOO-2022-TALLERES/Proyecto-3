package windowspprincipal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import vista.FPrincipal;

public class PPackage implements ActionListener{
	
		JFrame frame = new JFrame();
		JLabel txtName = new JLabel("Name:");
		JTextField name = new JTextField();
		
		JLabel txtDescription = new JLabel("Description:");
	    JTextField description = new JTextField();
	    
	    JButton create =  new JButton("Create");
	    
	    String selection;
	    
	    FPrincipal principal;
	    

	    
		PPackage(String selection, FPrincipal principal) {

		this.selection = selection;
		this.principal = principal;
		frame.setLocationRelativeTo(null);
		frame.setSize(300,300);
		frame.setTitle("Package");
		frame.setLayout(new GridLayout(4,1));
		frame.setResizable(false);
		
		
		frame.add(txtName);
		frame.add(name);
		frame.add(txtDescription);
		frame.add(description);
		frame.add(create);
		create.addActionListener(this);
		
		
		frame.setVisible(true);
		
	}



		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == create) {
				this.principal.getAplicacion().addWorkPackage(selection, name.getText(), description.getText());
				JOptionPane.showMessageDialog(principal, "Succesfuly created package project.");
			}
			
		}
	

}
