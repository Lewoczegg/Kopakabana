import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Referee_panel extends JPanel implements ActionListener{
	
	private ArrayList<Referee> referee_list = new ArrayList<Referee>();
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
		
		System.out.println("ok");
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back_button)
		{
			this.setVisible(false);
		}
		if(e.getSource() == add_referee_button)
		{
			add_referee();
		}
		if(e.getSource() == remove_referee_button)
		{
			remove_referee();
		}
		if(e.getSource() == show_referee_button)
		{
			show_referee();
		}
		
	}
	private void add_referee()
	{
		String first_name = JOptionPane.showInputDialog("Enter first name of a referee");
		String last_name = JOptionPane.showInputDialog("Enter last name of a referee");
		int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age of a referee"));
		referee_list.add(new Referee(first_name, last_name, age));
	}
	private void show_referee()
	{
		StringBuilder list = new StringBuilder();
		for(int i = 0; i < referee_list.size(); i++)
		{
			list.append(i+1 + ". " + referee_list.get(i).getFirst_name() + " " + referee_list.get(i).getLast_name() + " " + referee_list.get(i).getAge() + "\n");
		}
		JOptionPane.showMessageDialog(null, list, "List", JOptionPane.PLAIN_MESSAGE);
	}
	private void remove_referee()
	{
		StringBuilder list = new StringBuilder();
		for(int i = 0; i < referee_list.size(); i++)
		{
			list.append(i+1 + ". " + referee_list.get(i).getFirst_name() + " " + referee_list.get(i).getLast_name() + " " + referee_list.get(i).getAge() + "\n");
		}
		int choice = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of a referee you want to remove: \n" + list));
		referee_list.remove(choice - 1);
	}
	
}
