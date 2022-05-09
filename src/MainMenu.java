import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class MainMenu extends JFrame implements ActionListener{
	
	MainMenu() {
		refeere_button = new JButton();
		refeere_button.setBounds(250, 75, 300, 50);
		refeere_button.addActionListener(this);
		refeere_button.setText("MENAGEMENT OF REFEREES");
		refeere_button.setFocusable(false);
		refeere_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		team_button = new JButton();
		team_button.setBounds(250, 150, 300, 50);
		team_button.addActionListener(this);
		team_button.setText("MENAGEMENT OF TEAMS");
		team_button.setFocusable(false);
		team_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		tournament_button = new JButton();
		tournament_button.setBounds(250, 225, 300, 50);
		tournament_button.addActionListener(this);
		tournament_button.setText("START TOURNAMENT");
		tournament_button.setFocusable(false);
		tournament_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		layeredPane.setBounds(0, 0, 800, 600);
		layeredPane.add(refeere_button, Integer.valueOf(0));
		layeredPane.add(team_button, Integer.valueOf(0));
		layeredPane.add(tournament_button, Integer.valueOf(0));
		layeredPane.add(referee_panel, Integer.valueOf(1));
		layeredPane.add(team_panel, Integer.valueOf(1));
		layeredPane.add(tournament_panel, Integer.valueOf(1));
		
		this.add(layeredPane);
		this.setLayout(null);
		this.setTitle("Kopakabana"); //sets title of frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
		this.setResizable(false); //prevent frame from being resized
		this.setSize(800, 600); //sets the x-dimension and y-dimension of frame
		this.setVisible(true); //make frame visible
		this.setIconImage(logo.getImage()); //change icon of frame
		this.getContentPane().setBackground(new Color(141, 132, 227)); //change color of background
	}
	JLayeredPane layeredPane = new JLayeredPane();
	Referee_panel referee_panel = new Referee_panel();
	Team_panel team_panel = new Team_panel();
	Tournament_Panel tournament_panel = new Tournament_Panel();
	ImageIcon logo = new ImageIcon("logo.jpg");
	JButton refeere_button, team_button, tournament_button;
	Team_Manager team_manager = new Team_Manager();
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == refeere_button)
		{
			referee_panel.setVisible(true);
		}
		
		if(e.getSource() == team_button)
		{
			team_panel.setVisible(true);
		}
		if(e.getSource() == tournament_button)
		{
			if(team_manager.teamSize() < 4)
			{
				JOptionPane.showMessageDialog(null, "There must be at least 4 teams to start a tournament", "Info", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				tournament_panel.setVisible(true);
			}
		}
		
	}
	
	


}
