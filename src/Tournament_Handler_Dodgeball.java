import javax.swing.JOptionPane;

public class Tournament_Handler_Dodgeball {
	
	Team_Manager team_manager = new Team_Manager();
	int number_of_matches;
	int number_of_teams;
	//int i = 0, j, k = 1;
	int[][] tab = new int[team_manager.teamSize()][team_manager.teamSize()];//tablica zeby kazdy
																		  //zagral z kazdym
	for(int i = 0; i < team_manager.teamSize(); i++) 						
		for(int j = 0; j < team_manager.teamSize(); j++) //najpierw cala zerami
			tab[i][j] = 0;
							
	for(i = 0, k = 1; i < team_manager.teamSize(); i++, k++) 
		for(j = k; j < team_manager.teamSize(); j++)  //pozniej jedynkami w opowiednich miejscach
			tab[i][j] = 1;
		
		
		
	
	
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
