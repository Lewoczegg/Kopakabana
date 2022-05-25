import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

public class Tournament_Handler_Dodgeball {
	
	Team_Manager team_manager = new Team_Manager();
	private ArrayList<Team> scorelist = new ArrayList<Team>();
	private int number_of_matches;
	private int number_of_teams;
	private int i, j;
	
	
	Tournament_Handler_Dodgeball()
	{
		number_of_matches = (team_manager.teamSize() * (team_manager.teamSize() - 1)) / 2;
		number_of_teams = team_manager.teamSize();
		i = 0;
		j = 1;
		for(int k = 0; k < team_manager.teamSize(); k++)
		{
			scorelist.add(team_manager.getTeam(k));
		}
	}
	
	void nextMatch()
	{
		if(j >= number_of_teams)
		{
			i++;
			j = i + 1;
		}
		String[] responses = {team_manager.getTeam(i).getName(), team_manager.getTeam(j).getName()};
		int choice = JOptionPane.showOptionDialog(null, "Choose team to win", "Match", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses, 0);
		if(choice == 0)
		{
			team_manager.getTeam(i).addWin();
		}
		else
		{
			team_manager.getTeam(j).addWin();
		}
		System.out.println(choice);
		j++;
		number_of_matches--;
	}
	void scoreboard()
	{
		Collections.sort(scorelist, new Comparator<Team>()
				{
					public int compare(Team t1, Team t2)
					{
						return Integer.valueOf((t2.getWins()).compareTo(t1.getWins()));
					}
				});
		StringBuilder list = new StringBuilder();
		for(int i = 0; i < scorelist.size(); i++)
		{
			list.append(i+1 + ". " + scorelist.get(i).getName() + " Wins: " + scorelist.get(i).getWins() + "\n");
		}
		JOptionPane.showMessageDialog(null, list, "Scoreboard", JOptionPane.PLAIN_MESSAGE);
	}
	
}
