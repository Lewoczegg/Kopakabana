import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu extends JFrame implements ActionListener{
	
	MainMenu() {
		refeere_button = new JButton();
		refeere_button.setBounds(250, 75, 300, 50);
		refeere_button.addActionListener(this);
		refeere_button.setText("MENAGEMENT OF REFEREES");
		refeere_button.setFocusable(false);
		refeere_button.setFont(new Font("Comic Sans", Font.BOLD, 15));
		
		this.setLayout(null);
		this.setTitle("Kopakabana"); //sets title of frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
		this.setResizable(false); //prevent frame from being resized
		this.setSize(800, 600); //sets the x-dimension and y-dimension of frame
		this.setVisible(true); //make frame visible
		this.setIconImage(logo.getImage()); //change icon of frame
		this.getContentPane().setBackground(new Color(141, 132, 227)); //change color of background
		this.add(refeere_button);
		this.add(referee_panel);
	}
	
	Referee_panel referee_panel = new Referee_panel();
	ImageIcon logo = new ImageIcon("logo.jpg");
	JButton refeere_button;
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == refeere_button)
		{
			System.out.println("Button clicked");
			referee_panel.setVisible(true);
		}
		
	}
	
	


}
