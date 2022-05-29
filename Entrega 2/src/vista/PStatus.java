package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import procesamiento.Aplicacion;

public class PStatus extends JPanel implements Observer{
	private JLabel lblParticipant;
	private JLabel lblSelectedParticipant;

	private JLabel lblProject;
	private JLabel lblSelectedProject;
	

	public PStatus() {
		
		// Define layout
		this.setLayout(new GridLayout(1,4));
		
		// Add Participant Info
		this.lblParticipant = new JLabel ("Participante: ");
		this.lblSelectedParticipant = new JLabel("Not selected");
		lblSelectedParticipant.setForeground(Color.red);
		this.add(lblParticipant);
		this.add(lblSelectedParticipant);		
			
		// Add Project Info
		this.lblProject = new JLabel ("Project: ");
		this.lblSelectedProject = new JLabel ("Not selected");
		lblSelectedProject.setForeground(Color.red);
		this.add(lblProject);
		this.add(lblSelectedProject);
	}





	@Override
	public void update(Observable o, Object arg) {
		Aplicacion aplicacion = (Aplicacion) arg;
		try {
			lblSelectedProject.setText(aplicacion.getProyectoActivo());
			lblSelectedProject.setForeground(Color.blue);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			lblSelectedParticipant.setText(aplicacion.getParticipanteActivo());
			lblSelectedParticipant.setForeground(Color.blue);
		} catch (Exception e) {
			// TODO: handle exception
		}
				
	}
}
