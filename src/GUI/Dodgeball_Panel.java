package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logic.Tournament_Handler_Dodgeball;

public class Dodgeball_Panel extends JPanel implements ActionListener{
	
	JButton next_match_button;
	JButton scoreboard_button;
	JButton start_finals_button;
	JButton final_button;
	JLabel team1, team2, team3, team4, semi1, semi2, winner;
	int round = 1;
	Tournament_Handler_Dodgeball tournament_handler = new Tournament_Handler_Dodgeball();
	
	Dodgeball_Panel()
	{
		next_match_button = new JButton();
		next_match_button.setBounds(250, 75, 300, 50);
		next_match_button.addActionListener(this);
		next_match_button.setText("NEXT MATCH");
		next_match_button.setFocusable(false);
		next_match_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		scoreboard_button = new JButton();
		scoreboard_button.setBounds(250, 150, 300, 50);
		scoreboard_button.addActionListener(this);
		scoreboard_button.setText("SCOREBOARD");
		scoreboard_button.setFocusable(false);
		scoreboard_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		start_finals_button = new JButton();
		start_finals_button.setBounds(250, 225, 300, 50);
		start_finals_button.addActionListener(this);
		start_finals_button.setText("START FINALS");
		start_finals_button.setFocusable(false);
		start_finals_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		start_finals_button.setEnabled(false);
		
		final_button = new JButton();
		final_button.setBounds(250, 450, 300, 50);
		final_button.addActionListener(this);
		final_button.setText("SEMI-FINAL");
		final_button.setFocusable(false);
		final_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		final_button.setVisible(false);
		
		team1 = new JLabel();
		team2 = new JLabel();
		team3 = new JLabel();
		team4 = new JLabel();
		semi1 = new JLabel();
		semi2 = new JLabel();
		winner = new JLabel();
		
		team1.setVisible(false);
		team2.setVisible(false);
		team3.setVisible(false);
		team4.setVisible(false);
		semi1.setVisible(false);
		semi2.setVisible(false);
		winner.setVisible(false);
		
		team1.setBounds(80, 100, 300, 100);
		team2.setBounds(80, 325, 300, 100);
		team3.setBounds(550, 100, 300, 100);
		team4.setBounds(550, 325, 300, 100);
		semi1.setBounds(150, 212, 300, 100);
		semi2.setBounds(500, 212, 300, 100);
		winner.setBounds(225, 20, 500, 100);
		
		team1.setForeground(Color.BLACK);
		team2.setForeground(Color.BLACK);
		team3.setForeground(Color.BLACK);
		team4.setForeground(Color.BLACK);
		semi1.setForeground(Color.BLACK);
		semi2.setForeground(Color.BLACK);
		winner.setForeground(Color.BLACK);
		
		team1.setFont(new Font("Comic Sans", Font.BOLD, 25));
		team2.setFont(new Font("Comic Sans", Font.BOLD, 25));
		team3.setFont(new Font("Comic Sans", Font.BOLD, 25));
		team4.setFont(new Font("Comic Sans", Font.BOLD, 25));
		semi1.setFont(new Font("Comic Sans", Font.BOLD, 25));
		semi2.setFont(new Font("Comic Sans", Font.BOLD, 25));
		winner.setFont(new Font("Comic Sans", Font.BOLD, 25));
		
		
		this.setBackground(new Color(141, 132, 227));
		this.setBounds(0, 0, 800, 600);
		this.setVisible(false);
		this.setLayout(null);
		this.add(next_match_button);
		this.add(scoreboard_button);
		this.add(start_finals_button);
		this.add(final_button);
		this.add(team1);
		this.add(team2);
		this.add(team3);
		this.add(team4);
		this.add(semi1);
		this.add(semi2);
		this.add(winner);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == next_match_button)
		{
			tournament_handler.nextMatch();
			if(tournament_handler.matches_left() == 0)
			{
				start_finals_button.setEnabled(true);
				next_match_button.setEnabled(false);
			}
		}
		if(e.getSource() == scoreboard_button)
		{
			tournament_handler.scoreboard();
		}
		if(e.getSource() == start_finals_button)
		{
			next_match_button.setVisible(false);
			scoreboard_button.setVisible(false);
			start_finals_button.setVisible(false);
			team1.setText(tournament_handler.getFirst());
			team2.setText(tournament_handler.getThird());
			team3.setText(tournament_handler.getSecond());
			team4.setText(tournament_handler.getFourth());
			team1.setVisible(true);
			team2.setVisible(true);
			team3.setVisible(true);
			team4.setVisible(true);
			final_button.setVisible(true);
		}
		if(e.getSource() == final_button)
		{
			if(round == 4)
			{
				this.setVisible(false);
				round = 1;
				team1.setVisible(false);
				team2.setVisible(false);
				team3.setVisible(false);
				team4.setVisible(false);
				semi1.setVisible(false);
				semi2.setVisible(false);
				winner.setVisible(false);
				final_button.setText("SEMI-FINAL");
				final_button.setVisible(false);
				next_match_button.setVisible(true);
				scoreboard_button.setVisible(true);
				start_finals_button.setVisible(true);
				start_finals_button.setEnabled(false);
				next_match_button.setEnabled(true);
			}
			else if(round == 3)
			{
				winner.setText("Winner: " + tournament_handler.finale());
				winner.setVisible(true);
				final_button.setText("BACK");
				round++;
			}
			else if(round == 2)
			{
				if(tournament_handler.second_semifinal() == 0)
				{
					semi2.setText(tournament_handler.getSecond());
				}
				else
				{
					semi2.setText(tournament_handler.getFourth());
				}
				semi2.setVisible(true);
				round++;
				final_button.setText("Final");
			}
			else if(round == 1)
			{
				if(tournament_handler.first_semifinal() == 0)
				{
					semi1.setText(tournament_handler.getFirst());
				}
				else
				{
					semi1.setText(tournament_handler.getThird());
				}
				semi1.setVisible(true);
				round++;
			}	
		}
	}
	public void reset()
	{
		tournament_handler.reset();
	}
}
