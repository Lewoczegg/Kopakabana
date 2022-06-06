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
	
	public void add_team() throws IOException 
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
		
		FileWriter writer = new FileWriter("teams.txt", true);
		writer.write("\n" + name + " " + player1.getFirst_name() + " " + player1.getLast_name() + " " + player1.getNumber()
						  + " " + player2.getFirst_name() + " " + player2.getLast_name() + " " + player2.getNumber()
						  + " " + player3.getFirst_name() + " " + player3.getLast_name() + " " + player3.getNumber()
						  + " " + player4.getFirst_name() + " " + player4.getLast_name() + " " + player4.getNumber()
						  + " " + player5.getFirst_name() + " " + player5.getLast_name() + " " + player5.getNumber()
						  + " " + player6.getFirst_name() + " " + player6.getLast_name() + " " + player6.getNumber());
		writer.close();
	}
	
	public void add_team(String name, Player player1, Player player2, Player player3, Player player4, Player player5, Player player6)
	{
		team_list.add(new Team(name, player1, player2, player3, player4, player5, player6));
	}
	
	public void show_team()
	{
		StringBuilder list = new StringBuilder();
		for(int i = 0; i < team_list.size(); i++)
		{
			list.append(i+1 + ". " + team_list.get(i).getName() + team_list.get(i).getWins() +"\n");
		}
		JOptionPane.showMessageDialog(null, list, "List", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void remove_team() throws FileNotFoundException
	{
		PrintWriter write_to_file = new PrintWriter("teams.txt");
		StringBuilder list = new StringBuilder();
		for(int i = 0; i < team_list.size(); i++)
		{
			list.append(i+1 + ". " + team_list.get(i).getName() + "\n");
		}
		int choice = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of a team you want to remove: \n" + list));
		team_list.remove(choice - 1);
		for(int i = 0; i < team_list.size(); i++)
		{
			list.setLength(0);
			list.append(team_list.get(i).getName() + " " + team_list.get(i).getPlayer1().getFirst_name() + " " + team_list.get(i).getPlayer1().getLast_name() + " " + team_list.get(i).getPlayer1().getNumber()
												   + " " + team_list.get(i).getPlayer2().getFirst_name() + " " + team_list.get(i).getPlayer2().getLast_name() + " " + team_list.get(i).getPlayer2().getNumber()
												   + " " + team_list.get(i).getPlayer3().getFirst_name() + " " + team_list.get(i).getPlayer3().getLast_name() + " " + team_list.get(i).getPlayer3().getNumber()
												   + " " + team_list.get(i).getPlayer4().getFirst_name() + " " + team_list.get(i).getPlayer4().getLast_name() + " " + team_list.get(i).getPlayer4().getNumber()
												   + " " + team_list.get(i).getPlayer5().getFirst_name() + " " + team_list.get(i).getPlayer5().getLast_name() + " " + team_list.get(i).getPlayer5().getNumber()
												   + " " + team_list.get(i).getPlayer6().getFirst_name() + " " + team_list.get(i).getPlayer6().getLast_name() + " " + team_list.get(i).getPlayer6().getNumber());
			write_to_file.print(list);
		}
		write_to_file.close();
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
