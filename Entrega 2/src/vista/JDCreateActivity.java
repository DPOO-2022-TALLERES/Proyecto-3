package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import modelo.Actividad;

public class JDCreateActivity extends JDialog implements ActionListener {
	
	FPrincipal principal;
	JTextField name,description,type;
	JLabel namelbl,descriptionlbl,typelbl;
	JButton stopreanude, stopfinish;
	boolean stop = false;
	ArrayList<Integer> tiempos;
	String [] options;
	JComboBox <String>selectedTask;
	long tiempo1;
	long tiempo2;
	String fechainicioactividad;
	String horainicioactividad;
	JRadioButton check;
	boolean ifcheck;
	JRadioButton nocheck;
	
	public JDCreateActivity(FPrincipal principal){
		this.setLayout(null);
		this.principal = principal;
		this.setSize(800, 600);
		this.setResizable(false);
		this.setTitle("Create Activity");
		this.setLocationRelativeTo(null);
		JOptionPane.showMessageDialog(this.principal,"The cronometer of this activity has started just now!");
		
		// First take the machine date
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		fechainicioactividad = dtf.format(LocalDateTime.now());
		// Now take the hour
		horainicioactividad = fechainicioactividad.substring(11,19);
		
		//Initialize cronometer
		tiempos = new ArrayList<Integer>();
		Calendar ahora1 = Calendar.getInstance();
		tiempo1 = ahora1.getTimeInMillis();
		
		//Name
		namelbl = new JLabel("Name of the activity: ");
		namelbl.setBounds(20, 20, 250, 20);
		this.add(namelbl);
		name = new JTextField();
		name.setBounds(20, 60, 250, 30);
		this.add(name);
		
		//Type
		typelbl = new JLabel("Type of the activity: ");
		typelbl.setBounds(450, 20, 250, 20);
		this.add(typelbl);
		type = new JTextField();
		type.setBounds(450, 60, 250, 30);
		this.add(type);
		
		//Description
		descriptionlbl = new JLabel("Description of the activity: ");
		descriptionlbl.setBounds(20, 100, 250, 20);
		this.add(descriptionlbl);
		description = new JTextField();
		description.setBounds(20, 140, 700, 80);
		this.add(description);
		
		
		JLabel txtlabel = new JLabel("Add activity to task:");
		txtlabel.setBounds(230, 240, 300, 30);
		this.add(txtlabel);
		
		this.options = principal.getAplicacion().getProyectoActivoObject().giveTaskstoActivity();
		selectedTask = new JComboBox<>(this.options);
		selectedTask.setBounds(230, 280, 300, 30);
		this.add(selectedTask);
		
		
		
		
		
		nocheck =  new JRadioButton("This activity does not complete the task!");
        nocheck.setBounds(230, 330, 300, 30);
        this.add(nocheck);
		
		
		check = new JRadioButton("This activity completes the task!");
		check.setBounds(230, 350, 300, 30);
		this.add(check);
		
		
	
		//Buttons
		
		stopreanude = new JButton("Pause cronometer / Reanude cronometer");
		stopreanude.setBounds(230, 400, 300, 30);
		this.add(stopreanude);
		stopreanude.addActionListener(this);
		
		stopfinish = new JButton("Finish activity/ Stop cronometer");
		stopfinish.setBounds(230, 450, 300, 30);
		this.add(stopfinish);
		stopfinish.addActionListener(this);
		
		
		
		
		JOptionPane.showMessageDialog(this,"Please pause the cronometer before finish/stop the activity");
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == stopreanude) {
			
			//If the cronometer is running
			if (this.stop == false) {
				Calendar ahora2 = Calendar.getInstance();
				tiempo2 = ahora2.getTimeInMillis();
				long diferencia = tiempo2 - tiempo1;
				Integer diferenciasegundos = Math.toIntExact(diferencia/1000);
				tiempos.add(diferenciasegundos);
				this.stop = true;
				JOptionPane.showMessageDialog(this,"Cronometer paused succesfuly");
				}
			//If the cronometer are paused
			else if (this.stop = true) {
				Calendar ahora1 = Calendar.getInstance();
				tiempo1 = ahora1.getTimeInMillis();
				this.stop = false;
				JOptionPane.showMessageDialog(this,"Cronometer reanude succesfuly.");
			}
		}
		
		
		if (e.getSource() == stopfinish) {
			String totalminutes = consultarCronometro(this.tiempos);
			JOptionPane.showMessageDialog(this,"The total minutes was taken in this activity was: " + totalminutes);
			String selection = this.selectedTask.getSelectedItem().toString();
			
			if (check.isSelected()) {
				
				ifcheck = true;
			}
			
			else if (nocheck.isSelected()) {
				
				ifcheck = false;
			}

			// Fin de la actividaaad
			DateTimeFormatter dtfin = DateTimeFormatter.ofPattern("HH:mm:ss");
			String horaFin = dtfin.format(LocalDateTime.now());
			String tituloguardar = name.getText() + " de " + this.fechainicioactividad;
			Actividad act = this.principal.getAplicacion().crearActividad(name.getText(), description.getText(), this.fechainicioactividad, this.horainicioactividad, horaFin, type.getText(), totalminutes, tituloguardar);
			this.principal.getAplicacion().setTasktoActivity(act, ifcheck, selection);
		}
		
	}
	
	private String consultarCronometro(ArrayList<Integer> array) {
			Integer total = 0;
			for (Integer sumar : array) {
				total = total + sumar;
			}
			Integer tiempominutos = total/60;
			String retorno = String.valueOf(tiempominutos);
			return retorno;

	}

}
