import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tournament_Panel extends JPanel implements ActionListener{
	
	JButton volleyball_button;
	JButton dodgeball_button;
	JButton tug_of_war_button;
	JButton back_button;
	JPanel volleyball_panel = new Volleyball_Panel();
	JPanel dodgeball_panel = new Dodgeball_Panel();
	JPanel tug_of_war_panel = new Tug_Of_War_Panel();
	JLayeredPane layeredPane = new JLayeredPane();
	Referee_Menager referee_menager = new Referee_Menager();
	
	Tournament_Panel()
	{
		back_button = new JButton();
		back_button.setBounds(250, 300, 300, 50);
		back_button.addActionListener(this);
		back_button.setText("BACK");
		back_button.setFocusable(false);
		back_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		volleyball_button = new JButton();
		volleyball_button.setBounds(250, 75, 300, 50);
		volleyball_button.addActionListener(this);
		volleyball_button.setText("VOLLEYBALL");
		volleyball_button.setFocusable(false);
		volleyball_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		dodgeball_button = new JButton();
		dodgeball_button.setBounds(250, 150, 300, 50);
		dodgeball_button.addActionListener(this);
		dodgeball_button.setText("DODGEBALL");
		dodgeball_button.setFocusable(false);
		dodgeball_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		tug_of_war_button = new JButton();
		tug_of_war_button.setBounds(250, 225, 300, 50);
		tug_of_war_button.addActionListener(this);
		tug_of_war_button.setText("TUG OF WAR");
		tug_of_war_button.setFocusable(false);
		tug_of_war_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		layeredPane.setBounds(0, 0, 800, 600);
		layeredPane.add(back_button, Integer.valueOf(0));
		layeredPane.add(volleyball_button, Integer.valueOf(0));
		layeredPane.add(dodgeball_button, Integer.valueOf(0));
		layeredPane.add(tug_of_war_button, Integer.valueOf(0));
		layeredPane.add(volleyball_panel, Integer.valueOf(1));
		layeredPane.add(dodgeball_panel, Integer.valueOf(1));
		layeredPane.add(tug_of_war_panel, Integer.valueOf(1));
		
		this.setBackground(new Color(141, 132, 227));
		this.setBounds(0, 0, 800, 600);
		this.setVisible(false);
		this.setLayout(null);
		this.add(layeredPane);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back_button)
		{
			this.setVisible(false);
		}
		if(e.getSource() == volleyball_button)
		{
			if(referee_menager.number_of_referees() < 3)
			{
				JOptionPane.showMessageDialog(null, "There must be at least 3 referees to start a volleyball tournament", "Info", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				volleyball_panel.setVisible(true);
				((Volleyball_Panel) volleyball_panel).reset();
			}
		}
		if(e.getSource() == dodgeball_button)
		{
			if(referee_menager.number_of_referees() < 1)
			{
				JOptionPane.showMessageDialog(null, "There must be at least one referee to start a dodgeball tournament", "Info", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				dodgeball_panel.setVisible(true);
				((Dodgeball_Panel) dodgeball_panel).reset();
			}
		}
		if(e.getSource() == tug_of_war_button)
		{
			if(referee_menager.number_of_referees() < 1)
			{
				JOptionPane.showMessageDialog(null, "There must be at least one referee to start a tug of war tournament", "Info", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				tug_of_war_panel.setVisible(true);	
				((Tug_Of_War_Panel) tug_of_war_panel).reset();
			}
		}
	}
}
