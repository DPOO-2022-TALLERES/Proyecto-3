package windowspprincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vista.FPrincipal;
import vista.JDSelect;
	
public class PParticipantInformation extends JPanel implements ActionListener{
	FPrincipal principal;
	private JButton select;
	public PParticipantInformation(FPrincipal principal) {
	
		//Define general atributes
		this.principal = principal;
		this.setLayout(null);
		this.setBackground(Color.white);
		
		//Now, create the title label
		JLabel title = new JLabel("Search and consult");
		title.setBounds(316,200,200,100);
		title.setFont(new Font("Serif", Font.BOLD, 20));
		this.add(title);
		
		//Now, create the button for search and consult an participant
		select = new JButton("Search");
		select.setBounds(340, 280, 100,30);
		select.addActionListener(this);
		this.add(select);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == select) {
        	JDSelect jdSelect = new JDSelect("participantsearch", this.principal);
		}
		
	}
}
