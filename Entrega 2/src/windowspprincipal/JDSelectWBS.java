package windowspprincipal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import vista.FPrincipal;

public class JDSelectWBS extends JDialog implements ActionListener {
	
	FPrincipal principal;
	String tochange;
	String []options;
	String []options2;
	JButton selectButton;
	JComboBox<String> selected;
	
	public JDSelectWBS(String tochange, FPrincipal principal){
		
		this.principal = principal;
		this.tochange = tochange;
		
		this.setLayout(new GridLayout(2,1));
		this.setSize(200, 100);
		setLocationRelativeTo(null);
		
		if (tochange.equals("package")) {
			
			this.setTitle("Select Package");
			this.options = principal.getAplicacion().getProyectoActivoObject().giveOptionsWorkPackage();
			selected = new JComboBox<>(this.options);
			this.add(selected);
			
		}else if (tochange.equals("task")) {
			
			this.setTitle("Select Task");
			this.options = principal.getAplicacion().getProyectoActivoObject().giveOptionsTasks();
			selected = new JComboBox<>(this.options);
			this.add(selected);
		}
		
		else if (tochange.equals("modify")) {
			
			this.setTitle("Modify activity");
			this.options2 = principal.getAplicacion().getProyectoActivoObject().giveOptionsTasks();
			selected = new JComboBox<>(this.options2);
			this.add(selected);
		}
		
		selectButton = new JButton("Select");
		selectButton.addActionListener(this);
		
		this.add(selectButton);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == selectButton) {
			if (tochange.equals("package")) {
				
				String selection = this.selected.getSelectedItem().toString();
				PPackage pack =  new PPackage(selection, principal);
				
			}else if (tochange.equals("task")) {
				
				String selection = this.selected.getSelectedItem().toString();
				PTask task = new PTask(selection, principal);
			}
			
			else if (tochange.equals("modify")) {
				
				String selection = this.selected.getSelectedItem().toString();
				PMTask mtask = new PMTask(selection, principal);
			}
		}
		
	}

}
