package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import modelo.Participante;
import modelo.Proyecto;

public class JDSelect extends JDialog implements ActionListener{
	
	FPrincipal principal;
	String tochange;
	String []options;
	JButton selectButton;
	JComboBox<String> selected;

	
	public JDSelect(String tochange, FPrincipal principal){
		
		this.principal = principal;
		this.tochange = tochange;
		
		this.setLayout(new GridLayout(2,1));
		this.setSize(200, 100);
		setLocationRelativeTo(null);
		
		// If want change selected project
		if (tochange.equals("project")) {
			JOptionPane.showMessageDialog(this, "Your active participant will be adding to the project which you select! . If you don't have an active participant ignore that message.");
			this.setTitle("Select Project");
			HashMap<String,Proyecto> projects = principal.getAplicacion().getProyectos();
			Set<String> setProjects = projects.keySet();
			int size = setProjects.size();
			this.options = new String[size];
			
			int i = 0;
			
			for (String project : setProjects) {
				this.options[i] = project;
				i++;
			}
			
			selected = new JComboBox<>(this.options);
			this.add(selected);
			
			
		}
		
		
		// If want change selected participant
		else if (tochange.equals("participant")) {
			
			this.setTitle("Select Participant");
			
			HashMap<String,Participante> participants = principal.getAplicacion().getParticipantes();
			Set<String> setParticipants = participants.keySet();
			int size = setParticipants.size();
			this.options = new String[size];
			
			int i = 0;
			
			for (String participant: setParticipants) {
				this.options[i] = participant;
				i++;
			}
			
			selected = new JComboBox<>(this.options);
			this.add(selected);
		}
		
		// If want select an participant for see the information of that.
		else if(tochange.equals("participantsearch")) {
			HashMap<String,Participante> participants = principal.getAplicacion().getParticipantes();
			Set<String> setParticipants = participants.keySet();
			int size = setParticipants.size();
			this.options = new String[size];
			
			int i = 0;
			
			for (String participant: setParticipants) {
				this.options[i] = participant;
				i++;
			}
			
			selected = new JComboBox<>(this.options);
			this.add(selected);
		}
		selectButton = new JButton("Select");
		selectButton.addActionListener(this);
		
		this.add(selectButton);
		this.setVisible(true);

	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == selectButton) {

			// If want change selected project
			if (tochange.equals("project")) {
				String selection = this.selected.getSelectedItem().toString();
				principal.getAplicacion().elegirProyecto(selection);
	        	if(!this.principal.getAplicacion().verificarProyectoActivo()) {
					this.principal.getAplicacion().agregarParticipanteProyecto();

	        	}

	
			}
					
			// If want change selected participant
			else if (tochange.equals("participant")) {
				String selection = this.selected.getSelectedItem().toString();
				principal.getAplicacion().elegirParticipante(selection);

			}
			
			//If want select an participant for see the information of that.
			else if (tochange.equals("participantsearch")) {
				String selection = this.selected.getSelectedItem().toString();
				String[] informacion = principal.getAplicacion().informacionParticipante(selection);
				JOptionPane.showMessageDialog(this, "The total time worked of this participant are: " + informacion[0]);
				JOptionPane.showMessageDialog(this, "The average activity time of this participant are: " + informacion[1]);				
				JOptionPane.showMessageDialog(this, "The average day time of this participant are: " + informacion[2]);
	
			}
		}

	}
}
