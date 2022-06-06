package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logic.Team_Manager;

public class Team_panel extends JPanel implements ActionListener{
	
	Team_Manager team_Manager = new Team_Manager();
	JButton add_team_button;
	JButton remove_team_button;
	JButton show_team_button;
	JButton back_button;
	JButton back_button2;
	JLabel label_left;
	JLabel label_center;
	JComboBox<String> teams_ComboBox;
	String name, player1, player2, player3, player4, player5, player6;
	int dwins, vwins, twins, total_wins, trophies;
	
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
		
		back_button2 = new JButton();
		back_button2.setBounds(600, 500, 150, 50);
		back_button2.addActionListener(this);
		back_button2.setText("BACK");
		back_button2.setFocusable(false);
		back_button2.setFont(new Font("Comic Sans", Font.BOLD, 15));
		back_button2.setVisible(false);
		
		label_left = new JLabel();
		label_left.setBounds(20,0, 200, 600);
		label_left.setVisible(false);
		label_left.setText("<html>Name: <br/><br/>"
				+ "Player1: <br/><br/>"
				+ "Player2: <br/><br/>"
				+ "Player3: <br/><br/>"
				+ "Player4: <br/><br/>"
				+ "Player5: <br/><br/>"
				+ "Player6: <br/><br/>"
				+ "Volleyball wins: <br/><br/>"
				+ "Dodgeball wins: <br/><br/>"
				+ "Tug of war wins: <br/><br/>"
				+ "Total wins: <br/><br/>"
				+ "Trophies won: </html>");
		label_left.setForeground(Color.BLACK);
		label_left.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		label_center = new JLabel();
		label_center.setBounds(220, 10, 300, 600);
		label_center.setForeground(Color.BLACK);
		label_center.setFont(new Font("Comic Sans", Font.BOLD, 15));
		label_center.setVisible(false);
		
		teams_ComboBox = new JComboBox<String>();
		teams_ComboBox.addActionListener(this);
		teams_ComboBox.setVisible(false);
		teams_ComboBox.setBounds(250, 20, 150, 20);
		
		this.setBackground(new Color(141, 132, 227));
		this.setBounds(0, 0, 800, 600);
		this.setVisible(false);
		this.setLayout(null);
		this.add(add_team_button);
		this.add(remove_team_button);
		this.add(show_team_button);
		this.add(back_button);
		this.add(back_button2);
		this.add(label_left);
		this.add(label_center);
		this.add(teams_ComboBox);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == teams_ComboBox)
		{
			for(int i = 0; i < team_Manager.teamSize(); i++)
			{
				if(team_Manager.getTeam(i).getName() == teams_ComboBox.getSelectedItem())
				{
					name = team_Manager.getTeam(i).getName();
					player1 = team_Manager.getTeam(i).getPlayer1().getFirst_name() + " " + team_Manager.getTeam(i).getPlayer1().getLast_name();
					player2 = team_Manager.getTeam(i).getPlayer2().getFirst_name() + " " + team_Manager.getTeam(i).getPlayer2().getLast_name();
					player3 = team_Manager.getTeam(i).getPlayer3().getFirst_name() + " " + team_Manager.getTeam(i).getPlayer3().getLast_name();
					player4 = team_Manager.getTeam(i).getPlayer4().getFirst_name() + " " + team_Manager.getTeam(i).getPlayer4().getLast_name();
					player5 = team_Manager.getTeam(i).getPlayer5().getFirst_name() + " " + team_Manager.getTeam(i).getPlayer5().getLast_name();
					player6 = team_Manager.getTeam(i).getPlayer6().getFirst_name() + " " + team_Manager.getTeam(i).getPlayer6().getLast_name();
					vwins = team_Manager.getTeam(i).VolleyballWins();
					dwins = team_Manager.getTeam(i).DodgeballWins();
					twins = team_Manager.getTeam(i).TugOfWarWins();
					total_wins = team_Manager.getTeam(i).getWins();
					trophies = team_Manager.getTeam(i).Trophies();
					
					label_center.setText("<html>" + name + "<br/><br/>"
							+ player1 + "<br/><br/>"
							+ player2 + "<br/><br/>"
							+ player3 + "<br/><br/>"
							+ player4 + "<br/><br/>"
							+ player5 + "<br/><br/>"
							+ player6 + "<br/><br/>"
							+ vwins + "<br/><br/>"
							+ dwins + "<br/><br/>"
							+ twins + "<br/><br/>"
							+ total_wins + "<br/><br/>"
							+ trophies + "<br/><br/>"
							+ "</html>");
				}
			}

		}
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
			//team_Manager.show_team();
			back_button.setVisible(false);
			add_team_button.setVisible(false);
			show_team_button.setVisible(false);
			remove_team_button.setVisible(false);
			teams_ComboBox.removeAllItems();
			for(int i = 0; i < team_Manager.teamSize(); i++)
			{
				teams_ComboBox.addItem(team_Manager.getTeam(i).getName());
			}
			back_button2.setVisible(true);
			label_left.setVisible(true);
			label_center.setVisible(true);
			teams_ComboBox.setVisible(true);
			
			
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
		if(e.getSource() == back_button2)
		{
			back_button2.setVisible(false);
			label_left.setVisible(false);
			label_center.setVisible(false);
			teams_ComboBox.setVisible(false);
			add_team_button.setVisible(true);
			remove_team_button.setVisible(true);
			show_team_button.setVisible(true);
			back_button.setVisible(true);
		}
		
		
	}
}
