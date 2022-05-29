package vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class PStart extends JPanel implements ActionListener{
     GridBagConstraints constraints = new GridBagConstraints();
     PPrincipal pPrincipal;
     JButton crearActividad;
     JButton modificarActividad;
     JButton crearProyecto;
     JButton crearParticipante;
     JButton participantInfo;
     FPrincipal principal;
	
     PStart(PPrincipal pPrincipal, FPrincipal principal){
    	 
    	this.principal = principal;
    	this.pPrincipal = pPrincipal;
		this.setLayout(new GridBagLayout());
		
		JLabel text = new JLabel("            Select  an  option");
		modifyLabel(text,1,0,text);
		
		crearActividad = new JButton("Create Activity");
		addButton(crearActividad,1,1,crearActividad);
		crearActividad.addActionListener(this);
		
		modificarActividad = new JButton("Modify Activity");
		addButton(modificarActividad ,1,2,modificarActividad);
		modificarActividad.addActionListener(this);
		
		crearProyecto = new JButton("Create Project");
		addButton(crearProyecto,1,3,crearProyecto);
		crearProyecto.addActionListener(this);
		
		crearParticipante = new JButton("Create Participant");
		addButton(crearParticipante,1,4,crearParticipante);
		crearParticipante.addActionListener(this);
		
		participantInfo = new JButton("Participant Information ");
		addButton(participantInfo,1,5,participantInfo);
		participantInfo.addActionListener(this);
			
	}
	
	void addButton(Component component, int x, int y,JButton button) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.insets = new Insets(17, 0, 17, 0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        button.setAlignmentX(this.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(200,200));
        add(component, constraints);
      }
	
	void modifyLabel(Component component, int x, int y, JLabel text) {
		constraints.gridx = x;
        constraints.gridy = y;
        constraints.insets = new Insets(20, 0, 20, 0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        text.setAlignmentX(this.CENTER_ALIGNMENT);
        add(component, constraints);
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == crearActividad) {
			if (!this.principal.getAplicacion().verificarProyectoActivo()) {
				JOptionPane.showMessageDialog(this.principal, "The current hour is the start date for this activity, if you want to modify that: when finalize the process of create this activity go to 'Modify Activity'!");
				this.pPrincipal.getCreateActivity().reload();
				this.pPrincipal.changetoCreateActivity();
			}else {
				JOptionPane.showMessageDialog(this.principal, "For create an activity, you must have an active project!");
			}
			

		}
		if (e.getSource() == modificarActividad) {
			if (!this.principal.getAplicacion().verificarParticipanteActivo()) {
				JOptionPane.showMessageDialog(this.principal, "Remember: You only can modify your own activitys! (Active Participant)");
				this.pPrincipal.getModifyActivity().loadActivitys();
				this.pPrincipal.changetoModifyActivity();
			}else {
				JOptionPane.showMessageDialog(this.principal, "For modify an activity, you must have an active participant!");
			}

		}
		if (e.getSource() == crearProyecto) {
			JOptionPane.showMessageDialog(this.principal, "Remember: If you want to put a date to complete information, please use the format yyyy- mm - dd. Example: 2022-05-09");
			if (!this.principal.getAplicacion().verificarParticipanteActivo()) {
			this.pPrincipal.changetoCreateProject();
			}else {
				JOptionPane.showMessageDialog(this.principal, "For create an project, you must have an active participant!");
			}
		}
		if (e.getSource() == crearParticipante) {
			this.pPrincipal.changetoCreateParticipant();
		}
		if (e.getSource() == participantInfo) {
			this.pPrincipal.changetoParticipantInformation();
		}
		
	}

}
