import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Dodgeball_Panel extends JPanel implements ActionListener{
	
	JButton next_match_button;
	JButton scoreboard_button;
	
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
		
		this.setBackground(new Color(141, 132, 227));
		this.setBounds(0, 0, 800, 600);
		this.setVisible(false);
		this.setLayout(null);
		this.add(next_match_button);
		this.add(scoreboard_button);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
