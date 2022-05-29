package windowspprincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import vista.FPrincipal;
import vista.JDSelect;

public class PCreateParticipant extends JPanel implements ActionListener{
	
	FPrincipal principal;
	private JTextField name,email;
	private JLabel labelname;
	private JLabel labelemail;
	private JLabel title;
	private JButton create; 
	
	
	public PCreateParticipant(FPrincipal principal) {
		
		this.principal = principal;
		
		this.setLayout(null);
		this.setBackground(Color.white);
		
		// Label Title
		
		title = new JLabel("Create Participant");
		
		title.setBounds(316,20,200,100);
		title.setFont(new Font("Serif", Font.BOLD, 20));
		this.add(title);
			
		
		// Label Nombre
		
		labelname = new JLabel("Name");
		
		labelname.setBounds(105,150, 100,30);
		
		labelname.setFont(new Font("Serif", Font.PLAIN, 15));
		
	    // Now we add the JTextField
		
		name =  new JTextField();
		
		name.setBounds(160, 150, 200, 30);
		
		this.add(name);
		
		
		// Label correo
		
		labelemail = new JLabel("Email");
		
		labelemail.setBounds(420,150, 100,30);
		
		labelemail.setFont(new Font("Serif", Font.PLAIN, 15));
		
		//  Now we add the JTextField
		
		email = new JTextField();
	    email.setBounds(470, 150, 200, 30);
		
		// We add the button to create the participant
		
		create = new JButton("Create");
		create.setBounds(340, 230, 100,30);
		create.addActionListener(this);
		this.add(email);
		this.add(create);
		this.add(labelemail);
		this.add(labelname);
		
		
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == create) {
			
			if (name.getText().equals("") || email.getText().equals("") ) {
				
				JOptionPane.showMessageDialog(this, "Please enter all the data");
				
			}
			else {
				
				// Verifies if the user alredy exist, if not create a new one.
				switch (this.principal.getAplicacion().verificarParticipante(name.getText())) {
				case 0: {
					this.principal.getAplicacion().crearParticipante(email.getText(),name.getText());
					JOptionPane.showMessageDialog(this, "Created a user successfully!");
					if(!this.principal.getAplicacion().verificarProyectoActivo()) {
						JOptionPane.showMessageDialog(this, "Your new participant has been added to the active project! ");
						this.principal.getAplicacion().agregarParticipanteProyecto();
					}
					else {
						JOptionPane.showMessageDialog(this, "Your new participant has not been added to anyone proyect because you don't select some yet. If you want add your new participant to a existing proyect please in the next window select some proyect. If you don't want to add that participant to a existing proyect close the window which will open.!");
				    	JDSelect jdSelect = new JDSelect("project", this.principal);
					}
					break;
				}
				case 1: {
					JOptionPane.showMessageDialog(this, "That user is alredy created");
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + this.principal.getAplicacion().verificarParticipante(name.getText()));
				}
				
				
			
			}
			
			
			
		}
		
	}


	}
