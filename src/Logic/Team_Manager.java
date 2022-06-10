package Logic;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Team_Manager {
	private String first_name;
	private String last_name;
	private int number;

	public Team_Manager() 
	{
		
	}
	
	private static ArrayList<Team> team_list = new ArrayList<Team>();
	
	public void add_team()
	{
		String name = JOptionPane.showInputDialog("Enter name of team");
		first_name = JOptionPane.showInputDialog("Enter first name of a first player");
		last_name = JOptionPane.showInputDialog("Enter last name of a first player");
		number = Integer.parseInt(JOptionPane.showInputDialog("Enter id-number of a first player"));
		Player player1 = new Player(first_name, last_name, number);
		
		first_name = JOptionPane.showInputDialog("Enter first name of a second player");
		last_name = JOptionPane.showInputDialog("Enter last name of a second player");
		while(true)
		{
			Boolean ok = true;
			number = Integer.parseInt(JOptionPane.showInputDialog("Enter id-number of second player"));
			if(player1.getNumber() == number)
			{
				ok = false;
			}
			if(ok == true)
			{
				break;
			}
			JOptionPane.showMessageDialog(null, "Players can't have same numbers!", "Warning", JOptionPane.PLAIN_MESSAGE);
		}
		Player player2 = new Player(first_name, last_name, number);
		
		first_name = JOptionPane.showInputDialog("Enter first name of a third player");
		last_name = JOptionPane.showInputDialog("Enter last name of a third player");
		while(true)
		{
			Boolean ok = true;
			number = Integer.parseInt(JOptionPane.showInputDialog("Enter id-number of third player"));
			if(player1.getNumber() == number)
			{
				ok = false;
			}
			if(player2.getNumber() == number)
			{
				ok = false;
			}
			if(ok == true)
			{
				break;
			}
			JOptionPane.showMessageDialog(null, "Players can't have same numbers!", "Warning", JOptionPane.PLAIN_MESSAGE);
		}
		Player player3 = new Player(first_name, last_name, number);
		
		first_name = JOptionPane.showInputDialog("Enter first name of a fourth player");
		last_name = JOptionPane.showInputDialog("Enter last name of a fourth player");
		while(true)
		{
			Boolean ok = true;
			number = Integer.parseInt(JOptionPane.showInputDialog("Enter id-number of fourth player"));
			if(player1.getNumber() == number)
			{
				ok = false;
			}
			if(player2.getNumber() == number)
			{
				ok = false;
			}
			if(player3.getNumber() == number)
			{
				ok = false;
			}
			if(ok == true)
			{
				break;
			}
			JOptionPane.showMessageDialog(null, "Players can't have same numbers!", "Warning", JOptionPane.PLAIN_MESSAGE);
		}
		Player player4 = new Player(first_name, last_name, number);
		
		first_name = JOptionPane.showInputDialog("Enter first name of a fifth player");
		last_name = JOptionPane.showInputDialog("Enter last name of a fifth player");
		while(true)
		{
			Boolean ok = true;
			number = Integer.parseInt(JOptionPane.showInputDialog("Enter id-number of fifth player"));
			if(player1.getNumber() == number)
			{
				ok = false;
			}
			if(player2.getNumber() == number)
			{
				ok = false;
			}
			if(player3.getNumber() == number)
			{
				ok = false;
			}
			if(player4.getNumber() == number)
			{
				ok = false;
			}
			if(ok == true)
			{
				break;
			}
			JOptionPane.showMessageDialog(null, "Players can't have same numbers!", "Warning", JOptionPane.PLAIN_MESSAGE);
		}
		Player player5 = new Player(first_name, last_name, number);
		
		first_name = JOptionPane.showInputDialog("Enter first name of a sixth player");
		last_name = JOptionPane.showInputDialog("Enter last name of a sixth player");
		while(true)
		{
			Boolean ok = true;
			number = Integer.parseInt(JOptionPane.showInputDialog("Enter id-number of sixth player"));
			if(player1.getNumber() == number)
			{
				ok = false;
			}
			if(player2.getNumber() == number)
			{
				ok = false;
			}
			if(player3.getNumber() == number)
			{
				ok = false;
			}
			if(player4.getNumber() == number)
			{
				ok = false;
			}
			if(player5.getNumber() == number)
			{
				ok = false;
			}
			if(ok == true)
			{
				break;
			}
			JOptionPane.showMessageDialog(null, "Players can't have same numbers!", "Warning", JOptionPane.PLAIN_MESSAGE);
		}
		Player player6 = new Player(first_name, last_name, number);
		
		team_list.add(new Team(name, player1, player2, player3, player4, player5, player6));

	}
	
	public void add_team(String name, Player player1, Player player2, Player player3, Player player4, Player player5, Player player6,
			int wins, int dodgeball_wins, int volleyball_wins, int tugOfWar_wins, int trophies)
	{
		team_list.add(new Team(name, player1, player2, player3, player4, player5, player6,
				wins, dodgeball_wins, volleyball_wins, tugOfWar_wins, trophies));
	}
	
	public void remove_team()
	{
		StringBuilder list = new StringBuilder();
		for(int i = 0; i < team_list.size(); i++)
		{
			list.append(i+1 + ". " + team_list.get(i).getName() + "\n");
		}
		int choice = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of a team you want to remove: \n" + list));
		team_list.remove(choice - 1);
	}
	
	public ArrayList<Team> getCopy()
	{
		ArrayList<Team> team_list_copy = new ArrayList<Team>();
		for(int i = 0; i < team_list.size(); i++)
		{
			team_list_copy.add(team_list.get(i).getCopy());
		}
		return team_list_copy;
	}
	
	public int teamSize()
	{
		return team_list.size();
	}
	
	public Team getTeam(int index)
	{
		return team_list.get(index);
	}
}
