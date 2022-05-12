import javax.swing.JOptionPane;

public class Tournament_Handler_Dodgeball {
	
	Team_Manager team_manager = new Team_Manager();
	int number_of_matches;
	int number_of_teams;
	int i = 0;
	
	Tournament_Handler_Dodgeball()
	{
		number_of_matches = (team_manager.teamSize() * (team_manager.teamSize() - 1)) / 2;
		number_of_teams = team_manager.teamSize();
	}
	
	void nextMatch()
	{
		String[] responses = {team_manager.getTeam(i).getName(), team_manager.getTeam(i+1).getName()};
		JOptionPane.showOptionDialog(null, "Choose team to win", "Match", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses, 0);
	}
	
}
