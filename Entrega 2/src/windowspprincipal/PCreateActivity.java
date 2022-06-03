package windowspprincipal;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Set;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Participante;
import modelo.Task;
import vista.FPrincipal;
import vista.JDCreateActivity;

public class PCreateActivity extends JPanel implements ActionListener{
	String []options;
	JComboBox selected;
	JLabel instructions;
	JButton next;
	FPrincipal principal;
	public PCreateActivity(FPrincipal principal) {
		
		//General atributes
		this.setBackground(Color.white);
		this.setLayout(null);	
		this.principal = principal;
		
		
		//ComboBox information 1
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
		selected.setBounds(280, 300, 200, 30);
		this.add(selected);
		
	
		
		//JLabel instructions
		instructions = new JLabel("Please select the participant who will create the activity.");
		instructions.setBounds(215, 250, 380, 20);
		this.add(instructions);
		
		//JButton next
		next = new JButton("Next");
		next.setBounds(335, 350, 100, 30);
		this.add(next);
		next.addActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == next) {
			principal.getAplicacion().elegirParticipante(selected.getSelectedItem().toString());
			JDCreateActivity c = new JDCreateActivity(this.principal);
			
		}
		
		
	}
	
	
	public void reload() {
		this.remove(selected);
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
		selected.setBounds(280, 300, 200, 30);
		this.add(selected);
		
	}

}
