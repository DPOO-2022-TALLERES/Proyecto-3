package windowspprincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

import vista.FPrincipal;


public class PCreateProject extends JPanel implements ActionListener{
	
	FPrincipal principal;
	
	private JLabel labelname,labeldescription,title, labelstartdate, labelenddate;
	private JTextField name,description,startdate,enddate;
	private JButton create;

	// Create ComboBox
	
	public PCreateProject(FPrincipal principal) {
		
		this.principal = principal;
		
		this.setBackground(Color.WHITE);
		
		
		this.setLayout(null);
		
		// Added Title
		
		title = new JLabel("Create Proyect");
		
		title.setBounds(316,20,200,100);
		title.setFont(new Font("Serif", Font.BOLD, 20));
		this.add(title);
		
		
		// Add Label Name 
		
		labelname = new JLabel("Name:");
		
        labelname.setBounds(105,150, 100,30);
		
		labelname.setFont(new Font("Serif", Font.PLAIN, 15));
		
		this.add(labelname);
		
        // Add TextField Name
		
        name =  new JTextField();
		
		name.setBounds(160, 150, 200, 30);
		
		this.add(name);
		
		
		// Add Label StartDate
		
		labelstartdate = new JLabel("Start Date:");
		
		labelstartdate.setBounds(400,150,100,30);
		
		labelstartdate.setFont(new Font("Serif", Font.PLAIN, 15));
		
		this.add(labelstartdate);
		
		
	    // Add JTextField StartDate
		
		startdate = new JTextField();
		
		startdate.setBounds(480, 150,200,30);
		
		this.add(startdate);
		
		
		// Add Label Description
		
		labeldescription =  new JLabel("Description:");
		
		labeldescription.setBounds(105,250, 100,30);
		
		labeldescription.setFont(new Font("Serif", Font.PLAIN, 15));
		
		this.add(labeldescription);
		
		// Add TextField
		
		description = new JTextField();
		
		description.setBounds(185, 250, 180, 100);
		
		this.add(description);
		
		
		// Add Label EndDate
		
		labelenddate = new JLabel("Endate: ");
		
		labelenddate.setBounds(400, 250, 100,30);
		
		labelenddate.setFont(new Font("Serif", Font.PLAIN, 15));
		
		this.add(labelenddate);
		
		// Add TextField EndDate
		
		enddate = new JTextField();
		
		enddate.setBounds(450, 250, 200,30);
		
		this.add(enddate);
		
		
		// Add JButton 
		
		create = new JButton("Create");
		
		create.setBounds(340,401,100,30);
		
		create.addActionListener(this);
		
		this.add(create);
		

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == create) {
			
		   if (name.getText().equals("") | description.getText().equals("") | enddate.getText().equals("")) {
			   
			   JOptionPane.showMessageDialog(this, "Please enter all the data");
			
		   }
		   
		   else {
				   if (startdate.getText().equals("")) {
				   
					   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					   String start = dtf.format(LocalDateTime.now());
			   
					   this.principal.getAplicacion().crearProyecto(name.getText(), description.getText(), start, enddate.getText());
				
			           }
				    else {
			   
				   	this.principal.getAplicacion().crearProyecto(name.getText(), description.getText(), startdate.getText(), enddate.getText());
			   }
				   principal.getAplicacion().elegirParticipante(name.getText());
			   
		   }
			
		}
		
	}
}