package vista;

import javax.swing.*;

import procesamiento.Aplicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PMenu extends JMenuBar implements ActionListener {

	private FPrincipal principal;
    final JMenuItem selectUser;
    final JMenuItem selectProject;
    final JMenuItem saveInformation;

    
    public PMenu(FPrincipal principal) {
    	
    	this.principal = principal;
    	
        // File //
        JMenu file = new JMenu("File");
        this.add(file);
        
        // Select Participant
        selectUser = new JMenuItem("Select user");
        selectUser.addActionListener(this);
        file.add(selectUser);
             
        // Select Project
        selectProject = new JMenuItem("Select project");
        selectProject.addActionListener(this);
        file.add(selectProject);
        
        //Save Information 
        saveInformation = new JMenuItem("Save Information");
        saveInformation.addActionListener(this);
        file.add(saveInformation);
        
        

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == selectUser){
        	JDSelect jdSelect = new JDSelect("participant", this.principal);
            
        }
        
        
        if (e.getSource() == selectProject) {
        	JDSelect jdSelect = new JDSelect("project", this.principal);
        	
        }
        
        if (e.getSource() == saveInformation) {
        	principal.getLoader(this.principal.getAplicacion()).guardarAplicacion(this.principal.getAplicacion());
        	JOptionPane.showMessageDialog(principal, "Your information has saved succesfuly");
        	
        }
        
        
    }
}






