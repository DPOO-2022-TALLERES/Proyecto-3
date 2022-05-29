package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import windowspprincipal.*;

public class PPrincipal extends JPanel implements MouseListener{
	
	CardLayout cardLayout = new CardLayout();
	
	PCreateActivity pCreateActivity;
	PCreateParticipant pCreateParticipant;
	PCreateProject pCreateProject;
	PModifyActivity pModifyActivity;
	PParticipantInformation pParticipantInformation;
	
	JPanel panelInformation;
	JPanel panelCreateActivity;
	FPrincipal principal;
	
	
	public PPrincipal (FPrincipal principal) {
		
		this.principal = principal;
		
		this.setLayout(cardLayout);
		
		pCreateActivity = new PCreateActivity(principal);
		this.add(pCreateActivity, "pCreateActivity");
		
		pCreateParticipant = new PCreateParticipant(principal);
		this.add(pCreateParticipant, "pCreateParticipant");
		
		pCreateProject = new PCreateProject(principal);
		this.add(pCreateProject, "pCreateProject");
		
		
		pModifyActivity = new PModifyActivity(principal);
		this.add(pModifyActivity, "pModifyActivity");
		
		pParticipantInformation = new PParticipantInformation(principal);
		this.add(pParticipantInformation, "pParticipantInformation");
		
		panelInformation = new JPanel();
		panelInformation.setBackground(Color.gray);
		panelInformation.addMouseListener(this);
		panelInformation.setLayout(null);
		
		// Added Image 
		JLabel puki = new JLabel();
		puki.setBounds(0,0,804,642);
		puki.setIcon(new ImageIcon(getClass().getResource("puki.png")));

		panelInformation.add(puki);
		this.add(panelInformation, "panelInformation");

		

	
		cardLayout.show(this, "panelInformation");

	}
	
	public void changetoCreateActivity() {
		cardLayout.show(this, "pCreateActivity");
	}
	
	public void changetoCreateParticipant() {
		cardLayout.show(this, "pCreateParticipant");
	}
	
	public void changetoCreateProject() {
		cardLayout.show(this, "pCreateProject");
	}
	public void changetoModifyActivity() {
		cardLayout.show(this, "pModifyActivity");
	}
	public void changetoParticipantInformation() {
		cardLayout.show(this, "pParticipantInformation");
	}
	
	public PModifyActivity getModifyActivity(){
		return this.pModifyActivity;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX() + "," + e.getY());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public PCreateActivity getCreateActivity() {
		return this.pCreateActivity;
	}

}
