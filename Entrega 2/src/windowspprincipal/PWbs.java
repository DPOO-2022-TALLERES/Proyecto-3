package windowspprincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vista.FPrincipal;

public class PWbs extends JPanel implements ActionListener{
	
	FPrincipal principal;
	JLabel lbltext;
	JLabel title;
	JButton createTask;
	JButton createPackage;
	JButton modifyTask;
	JButton nodeTask;
	JButton nodePackage;
	
	
	
	
	public PWbs(FPrincipal principal) {
		
		this.principal = principal;
		this.setLayout(new GridLayout(6,1));
		
		
		this.setBackground(Color.white);
		
		
		// title
		title = new JLabel("WBS");
		title.setFont(new Font("Serif", Font.BOLD, 20));
		title.setBounds(316, 20, 250, 20);
		add(title);
			
						
		
		// Create Task
		createTask = new JButton("Create Task");
		createTask.setBounds(20, 88, 200, 25);
		createTask.addActionListener(this);
		add(createTask);
		
		// Create Package
		
		createPackage = new JButton("Create Package");
		createPackage.setBounds(250, 88, 200, 25);
		createPackage.addActionListener(this);
		add(createPackage);
		
		// Modify Task
		
		modifyTask =  new JButton("Modify task");
		modifyTask.setBounds(480, 88, 200, 25);
		modifyTask.addActionListener(this);
		add(modifyTask);
		
		
		
		
		
	
	
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == createTask) {
			
			JDSelectWBS i = new JDSelectWBS("task", principal);
			
			//
		}
		
		if (e.getSource() == createPackage) {
			
			JDSelectWBS i = new JDSelectWBS("package", principal);
			
		}
		
		if (e.getSource() == modifyTask) {
			
			PMTask modify = new PMTask();
		}
		
		
		
	}
}

