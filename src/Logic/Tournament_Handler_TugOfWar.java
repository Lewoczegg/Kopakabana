package Logic;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

public class Tournament_Handler_TugOfWar {
	
	Team_Manager team_manager = new Team_Manager();
	Referee_Menager referee_manager = new Referee_Menager();
	private ArrayList<Team> scorelist;
	private int number_of_matches;
	private int number_of_teams;
	private int i, j;
	String semi1;
	String semi2;
	
	
	public Tournament_Handler_TugOfWar()
	{
		number_of_matches = (team_manager.teamSize() * (team_manager.teamSize() - 1)) / 2;
		number_of_teams = team_manager.teamSize();
		i = 0;
		j = 1;
	}
	
	public void nextMatch()
	{
		if(j >= number_of_teams)
		{
			i++;
			j = i + 1;
		}
		String[] responses = {team_manager.getTeam(i).getName(), team_manager.getTeam(j).getName()};
		int choice = JOptionPane.showOptionDialog(null, "Referee: " + referee_manager.RandomReferee() + "\nChoose team to win", "Match", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses, 0);
		if(choice == 0)
		{
			team_manager.getTeam(i).addWin();
			team_manager.getTeam(i).addtugofwarWin();
			for(int k = 0; k < scorelist.size(); k++)
			{
				if(team_manager.getTeam(i).getName() == scorelist.get(k).getName())
				{
					scorelist.get(k).addWin();
					break;
				}
			}
		}
		else
		{
			team_manager.getTeam(j).addWin();
			team_manager.getTeam(j).addtugofwarWin();
			for(int k = 0; k < scorelist.size(); k++)
			{
				if(team_manager.getTeam(j).getName() == scorelist.get(k).getName())
				{
					scorelist.get(k).addWin();
					break;
				}
			}
		}
		j++;
		number_of_matches--;
		Collections.sort(scorelist, new Comparator<Team>()
		{
			public int compare(Team t1, Team t2)
			{
				return Integer.valueOf((t2.getWins()).compareTo(t1.getWins()));
			}
		});
	}
	public void scoreboard()
	{
		StringBuilder list = new StringBuilder();
		for(int i = 0; i < scorelist.size(); i++)
		{
			list.append(i+1 + ". " + scorelist.get(i).getName() + " Wins: " + scorelist.get(i).getWins() + "\n");
		}
		JOptionPane.showMessageDialog(null, list, "Scoreboard", JOptionPane.PLAIN_MESSAGE);
	}
	
	public int first_semifinal()
	{
		String[] responses = {getFirst(), getThird()};
		int choice = JOptionPane.showOptionDialog(null, "Referee: " + referee_manager.RandomReferee() + "\nChoose team to win", "Match", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses, 0);
		if(choice == 0)
		{
			semi1 = getFirst();
			for(int i = 0; i < team_manager.teamSize(); i++)
			{
				if(team_manager.getTeam(i).getName() == semi1)
				{
					team_manager.getTeam(i).addWin();
					team_manager.getTeam(i).addtugofwarWin();
					break;
				}
			}
		}
		else
		{
			semi1 = getThird();
			for(int i = 0; i < team_manager.teamSize(); i++)
			{
				if(team_manager.getTeam(i).getName() == semi1)
				{
					team_manager.getTeam(i).addWin();
					team_manager.getTeam(i).addtugofwarWin();
					break;
				}
			}
		}
		return choice;
	}
	public int second_semifinal()
	{
		String[] responses = {getSecond(), getFourth()};
		int choice = JOptionPane.showOptionDialog(null, "Referee: " + referee_manager.RandomReferee() + "\nChoose team to win", "Match", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses, 0);
		if(choice == 0)
		{
			semi2 = getSecond();
			for(int i = 0; i < team_manager.teamSize(); i++)
			{
				if(team_manager.getTeam(i).getName() == semi2)
				{
					team_manager.getTeam(i).addWin();
					team_manager.getTeam(i).addtugofwarWin();
					break;
				}
			}
		}
		else
		{
			semi2 = getFourth();
			for(int i = 0; i < team_manager.teamSize(); i++)
			{
				if(team_manager.getTeam(i).getName() == semi2)
				{
					team_manager.getTeam(i).addWin();
					team_manager.getTeam(i).addtugofwarWin();
					break;
				}
			}
		}
		return choice;
	}
	public String finale()
	{
		String[] responses = {semi1, semi2};
		int choice = JOptionPane.showOptionDialog(null, "Referee: " + referee_manager.RandomReferee() + "\nChoose team to win", "Match", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses, 0);
		if(choice == 0)
		{
			for(int i = 0; i < team_manager.teamSize(); i++)
			{
				if(team_manager.getTeam(i).getName() == semi1)
				{
					team_manager.getTeam(i).addWin();
					team_manager.getTeam(i).addtugofwarWin();
					team_manager.getTeam(i).addtrophyWin();
					break;
				}
			}
			return semi1;
		}
		else
		{
			for(int i = 0; i < team_manager.teamSize(); i++)
			{
				if(team_manager.getTeam(i).getName() == semi2)
				{
					team_manager.getTeam(i).addWin();
					team_manager.getTeam(i).addtugofwarWin();
					team_manager.getTeam(i).addtrophyWin();
					break;
				}
			}
			return semi2;
		}
	}
	public void reset()
	{
		number_of_matches = (team_manager.teamSize() * (team_manager.teamSize() - 1)) / 2;
		i = 0;
		j = 1;
		scorelist = new ArrayList<Team>(team_manager.getCopy());
	}
	public int matches_left()
	{
		return number_of_matches;
	}
	public String getFirst()
	{
		return scorelist.get(0).getName();
	}
	public String getSecond()
	{
		return scorelist.get(1).getName();
	}
	public String getThird()
	{
		return scorelist.get(2).getName();
	}
	public String getFourth()
	{
		return scorelist.get(3).getName();
	}
	
}
