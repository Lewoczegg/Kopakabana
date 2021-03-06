package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import Logic.SaveFiles;
import Logic.Team_Manager;

public class MainMenu extends JFrame implements ActionListener{
	
	public MainMenu() {
		refeere_button = new JButton();
		refeere_button.setBounds(250, 75, 300, 50); 					//x , y, width, height
		refeere_button.addActionListener(this);							//adds ActionListener to the button
		refeere_button.setText("MENAGEMENT OF REFEREES");				//sets text of a button
		refeere_button.setFocusable(false);								//removes border from the button's text					
		refeere_button.setFont(new Font("Comic Sans", Font.BOLD, 15));  //sets font of a text
		
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
		
		save_and_exit_button = new JButton();
		save_and_exit_button.setBounds(250, 300, 300, 50);
		save_and_exit_button.addActionListener(this);
		save_and_exit_button.setText("SAVE AND EXIT");
		save_and_exit_button.setFocusable(false);
		save_and_exit_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		layeredPane.setBounds(0, 0, 800, 600);
		layeredPane.add(refeere_button, Integer.valueOf(0));       
		layeredPane.add(team_button, Integer.valueOf(0));
		layeredPane.add(tournament_button, Integer.valueOf(0));
		layeredPane.add(save_and_exit_button, Integer.valueOf(0));
		layeredPane.add(referee_panel, Integer.valueOf(1));
		layeredPane.add(team_panel, Integer.valueOf(1));
		layeredPane.add(tournament_panel, Integer.valueOf(1));		//the higher Integer.valueOf(x) the higher it is in the hierarchy
		
		this.add(layeredPane);
		this.setLayout(null); //using fixed positions
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
	JButton refeere_button, team_button, tournament_button, save_and_exit_button;
	Team_Manager team_manager = new Team_Manager();
	SaveFiles saver = new SaveFiles();
	
	public void actionPerformed(ActionEvent e){
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
				JOptionPane.showMessageDialog(null,
						"There must be at least 4 teams to start a tournament",
						"Info",
						JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				tournament_panel.setVisible(true);
			}
		}
		if(e.getSource() == save_and_exit_button)
		{
			try {
				saver.save();
				System.exit(ABORT);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}	
	}
}
