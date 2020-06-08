import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class Window extends JFrame implements ActionListener {
	
	JButton bFirst,bSecond;
	JLabel lData;
	JTextField tpole;
	JCheckBox jbox;
	
	double tempA;
	double tempB;

	public Window() {
		 setSize(400,200);
		 setTitle("Moje okno");
		 setLayout(null);
		 
		 bFirst = new JButton("TempF");
		 bFirst.setBounds(100, 50, 100, 20);
		 add(bFirst);
		 bFirst.addActionListener(this);
		 
		 bSecond = new JButton("Exit");
		 bSecond.setBounds(200, 50, 100, 20);
		 add(bSecond);
		 bSecond.addActionListener(this);
		 
		 lData= new JLabel("Data");
		 lData.setBounds(100, 70, 200, 20);
		 lData.setForeground(new Color(0,200,200));
		 lData.setFont(new Font("SansSerif",Font.BOLD, 8));
		 add(lData);
		 
		 tpole = new JTextField();
		 tpole.setBounds(100, 90, 100, 20);
		 add(tpole);
		 tpole.addActionListener(this);
		 
		 jbox = new JCheckBox("Lol");
		 jbox.setBounds(210, 90, 100, 20);
		 add(jbox);
		 jbox.addActionListener(this);
		 
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		if (source == bFirst || source ==tpole) {
			tempA= Double.parseDouble(tpole.getText());
			tempB=2*tempA;
			tpole.setText(String.valueOf(tempB));
		} else if(source==jbox) {
			if(jbox.isSelected()==true) {
				 tpole.setFont(new Font("SansSerif",Font.BOLD, 12));	
			}
			else {
				 tpole.setFont(new Font("SansSerif",Font.BOLD, 8));
			}
		}
		else if (source == bSecond) {
			dispose();
		}
	}
		
}
