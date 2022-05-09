import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Team_panel extends JPanel implements ActionListener{
	
	Team_Manager team_Manager = new Team_Manager();
	JButton add_team_button;
	JButton remove_team_button;
	JButton show_team_button;
	JButton back_button;
	
	Team_panel()
	{
		add_team_button = new JButton();
		add_team_button.setBounds(250, 75, 300, 50);
		add_team_button.addActionListener(this);
		add_team_button.setText("ADD TEAM");
		add_team_button.setFocusable(false);
		add_team_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		remove_team_button = new JButton();
		remove_team_button.setBounds(250, 150, 300, 50);
		remove_team_button.addActionListener(this);
		remove_team_button.setText("REMOVE TEAM");
		remove_team_button.setFocusable(false);
		remove_team_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		show_team_button = new JButton();
		show_team_button.setBounds(250, 225, 300, 50);
		show_team_button.addActionListener(this);
		show_team_button.setText("TEAMS OVERVIEW");
		show_team_button.setFocusable(false);
		show_team_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
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
		this.add(add_team_button);
		this.add(remove_team_button);
		this.add(show_team_button);
		this.add(back_button);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back_button)
		{
			this.setVisible(false);
		}
		if(e.getSource() == add_team_button)
		{
			try {
				team_Manager.add_team();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == show_team_button)
		{
			team_Manager.show_team();
		}
		if(e.getSource() == remove_team_button)
		{
			try {
				team_Manager.remove_team();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
