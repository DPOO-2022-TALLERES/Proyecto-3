package windowspprincipal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import modelo.Actividad;
import vista.FPrincipal;
import vista.JDModifyActivity;

public class PModifyActivity extends JPanel implements ActionListener{
	FPrincipal principal;

	String []options;
	JComboBox<String> selected;
	JButton modify;
	
	public PModifyActivity(FPrincipal principal) {
		
		// Define general atributes
		this.setLayout(null);
		this.setBackground(Color.white);
		this.principal = principal;
		
		
		//Add button
		modify = new JButton("Modify");
		modify.addActionListener(this);
		modify.setBounds(300, 300, 125, 50);
		this.add(modify);
		
	}
	
	public void loadActivitys() {
		options = principal.getAplicacion().optionsModify();
		if (selected != null) {
			this.remove(selected);
		}
		selected = new JComboBox<>(this.options);
		selected.setBounds(187, 225, 350, 30);	
		this.add(selected);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == modify) {
			Actividad actividadmodificar = this.principal.getAplicacion().getActividad(selected.getSelectedItem().toString());
			JDModifyActivity m = new JDModifyActivity(principal, actividadmodificar);
		}
		
	}
}
