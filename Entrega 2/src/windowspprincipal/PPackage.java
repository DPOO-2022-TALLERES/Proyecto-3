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

public class PPackage extends JFrame implements ActionListener{
	

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
		this.setLocationRelativeTo(null);
		this.setSize(300,300);
		this.setTitle("Package");
		this.setLayout(new GridLayout(4,1));
		this.setResizable(false);
		
		
		this.add(txtName);
		this.add(name);
		this.add(txtDescription);
		this.add(description);
		this.add(create);
		create.addActionListener(this);
		
		
		this.setVisible(true);
		
	}



		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == create) {
				this.principal.getAplicacion().addWorkPackage(selection, name.getText(), description.getText());
				JOptionPane.showMessageDialog(principal, "Succesfuly created package project.");
			}
			
		}
	

}
