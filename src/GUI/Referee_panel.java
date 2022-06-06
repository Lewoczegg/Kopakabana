package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

import Logic.Referee_Menager;

public class Referee_panel extends JPanel implements ActionListener{
	
	Referee_Menager referee_Menager = new Referee_Menager();
	JButton add_referee_button;
	JButton remove_referee_button;
	JButton show_referee_button;
	JButton back_button;
	
	Referee_panel()
	{
		add_referee_button = new JButton();
		add_referee_button.setBounds(250, 75, 300, 50);
		add_referee_button.addActionListener(this);
		add_referee_button.setText("ADD REFEREE");
		add_referee_button.setFocusable(false);
		add_referee_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		remove_referee_button = new JButton();
		remove_referee_button.setBounds(250, 150, 300, 50);
		remove_referee_button.addActionListener(this);
		remove_referee_button.setText("REMOVE REFEREE");
		remove_referee_button.setFocusable(false);
		remove_referee_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		show_referee_button = new JButton();
		show_referee_button.setBounds(250, 225, 300, 50);
		show_referee_button.addActionListener(this);
		show_referee_button.setText("REFEREES OVERVIEW");
		show_referee_button.setFocusable(false);
		show_referee_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		back_button = new JButton();
		back_button.setBounds(250, 300, 300, 50);
		back_button.addActionListener(this);
		back_button.setText("BACK");
		back_button.setFocusable(false);
		back_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		
		this.setBackground(new Color(141, 132, 227));
		this.setBounds(0, 0, 800, 600);
		this.setVisible(false);
		this.setLayout(null);
		this.add(add_referee_button);
		this.add(remove_referee_button);
		this.add(show_referee_button);
		this.add(back_button);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back_button)
		{
			this.setVisible(false);
		}
		if(e.getSource() == add_referee_button)
		{
			try {
				referee_Menager.add_referee();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == remove_referee_button)
		{
			try {
				referee_Menager.remove_referee();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == show_referee_button)
		{
			referee_Menager.show_referee();
		}
		
	}
	
	
}
