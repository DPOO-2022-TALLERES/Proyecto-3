package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Actividad;

public class JDModifyActivity extends JDialog implements ActionListener{

	FPrincipal principal;
	Actividad actividadmodificar;
	private JTextField startDate, finalHour, totalMinutes;
	private JLabel title, infoStartDate, infoFinalHour, infoTotalMinutes;
	JButton modify;
	
	public JDModifyActivity(FPrincipal principal, Actividad actividadmodificar){
		
		this.setLayout(null);
		this.setSize(800,600);
		this.setBackground(Color.white);
		setLocationRelativeTo(null);
		this.actividadmodificar = actividadmodificar;
		this.principal = principal;
		
		//Title
		title = new JLabel("Modify activity '" + actividadmodificar.getnombreguardar() + "'");
		title.setBounds(110,20,600,100);
		title.setFont(new Font("Serif", Font.BOLD, 20));
		this.add(title);
		
		//Start date label to compare
		infoStartDate = new JLabel();
		infoStartDate.setBounds(20, 110, 600, 20);
		String infoStartDates = "Your start date are: " + actividadmodificar.getFechaRealizado() + ", write the new start date in the same format.";
		infoStartDate.setText(infoStartDates);
		this.add(infoStartDate);
		//TextField Start Date
		startDate = new JTextField();
		startDate.setBounds(25, 150, 190, 30);
		this.add(startDate);


		
		//Final hour label to compare
		infoFinalHour = new JLabel();
		infoFinalHour.setBounds(20, 210, 600, 20);
		String infoFinalHours = "Your final hour are: " + actividadmodificar.getHoraFin() + ", write the new final hour in the same format.";
		infoFinalHour.setText(infoFinalHours);
		this.add(infoFinalHour);
		//TextField Final Hour
		finalHour = new JTextField();
		finalHour.setBounds(25, 250, 190, 30);
		this.add(finalHour);

		
		
		//Final minutes label to compare
		infoTotalMinutes = new JLabel();
		infoTotalMinutes.setBounds(20, 310, 900, 20);
		String infoTotalMinutess = "The total minutes was taken make this activity were: " + actividadmodificar.getMinutos() + ", wirte the new total minutes it took you do this activity.";
		infoTotalMinutes.setText(infoTotalMinutess);
		this.add(infoTotalMinutes);
		//TextField Total Minutes
		totalMinutes = new JTextField();
		totalMinutes.setBounds(20, 350, 190, 30);
		this.add(totalMinutes);

		
		//Button Modify
		modify = new JButton("Modify");
		modify.setBounds(330, 450, 80, 30);
		this.add(modify);
		modify.addActionListener(this);
		
    	JOptionPane.showMessageDialog(principal, "Remember: If you don't want to change some information, left the white space.");
		this.setVisible(true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == modify) {
			String fecha = actividadmodificar.getFechaRealizado();
			String horaFin = actividadmodificar.getHoraFin();
			String minutos = actividadmodificar.getMinutos(); 
			if (!startDate.getText().equals("")) {
				fecha = startDate.getText();
			}
			if (!finalHour.getText().equals("")) {
				horaFin = finalHour.getText();
			}
			if (!totalMinutes.getText().equals("")) {
				minutos = totalMinutes.getText();
			}
				
		principal.getAplicacion().modificarActividad(actividadmodificar, fecha, horaFin, minutos);
    	JOptionPane.showMessageDialog(principal, "Activity modified succesfuly!");
		}
		
	}
	
	
}
