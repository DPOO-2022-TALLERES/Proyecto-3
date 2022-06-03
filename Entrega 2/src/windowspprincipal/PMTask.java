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

public class PMTask extends JFrame implements ActionListener {
	
	
	JLabel txtName = new JLabel("Name:");
	JTextField name = new JTextField();
	
    JLabel txtTime = new JLabel("Time:");
    JTextField time  = new JTextField();
    
    JLabel txtDate = new JLabel("Finish Date: (yyyy-mm-dd)");
    JTextField date  = new JTextField();
    
    
    JButton modify =  new JButton("Modify");
	
	String selection;
    FPrincipal principal;


	PMTask(String selection, FPrincipal principal) {
		
		this.selection = selection;
		this.principal =  principal;
		
		
		this.setSize(340,300);
		this.setTitle("Modify Task");
		this.setLayout(new GridLayout(4,1));
		this.setResizable(false);
		
		this.add(txtName);
		this.add(name);
		this.add(txtTime);
		this.add(time);
		this.add(txtDate);
		this.add(date);
		this.add(modify);
		modify.addActionListener(this);
		
		
		
		
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == modify) {
			this.principal.getAplicacion().setEFTTask(name.getText(), time.getText());
			this.principal.getAplicacion().setEFDTask(name.getText(), date.getText());
			JOptionPane.showMessageDialog(this, "Modify Task:  " + name.getText() + " Succesfully!");
			
		}
		
	}


}
