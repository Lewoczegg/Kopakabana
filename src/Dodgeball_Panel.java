import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dodgeball_Panel extends JPanel implements ActionListener{
	
	JButton next_match_button;
	JButton scoreboard_button;
	JButton start_finals_button;
	JButton final_button;
	JLabel team1, team2, team3, team4;
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
		
		team1.setVisible(false);
		team2.setVisible(false);
		team3.setVisible(false);
		team4.setVisible(false);
		
		team1.setBounds(80, 100, 300, 100);
		team2.setBounds(80, 325, 300, 100);
		team3.setBounds(550, 100, 300, 100);
		team4.setBounds(550, 325, 300, 100);
		
		team1.setForeground(Color.GREEN);
		team2.setForeground(Color.GREEN);
		team3.setForeground(Color.GREEN);
		team4.setForeground(Color.GREEN);
		
		team1.setFont(new Font("Comic Sans", Font.BOLD, 25));
		team2.setFont(new Font("Comic Sans", Font.BOLD, 25));
		team3.setFont(new Font("Comic Sans", Font.BOLD, 25));
		team4.setFont(new Font("Comic Sans", Font.BOLD, 25));
		
		
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
			team2.setText(tournament_handler.getSecond());
			team3.setText(tournament_handler.getThird());
			team4.setText(tournament_handler.getFourth());
			team1.setVisible(true);
			team2.setVisible(true);
			team3.setVisible(true);
			team4.setVisible(true);
			final_button.setVisible(true);

		}
	}
}
