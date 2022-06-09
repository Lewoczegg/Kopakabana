package Logic;

import java.io.FileWriter;
import java.io.IOException;

public class SaveFiles {
	public SaveFiles()
	{
		
	}
	Referee_Menager referee_menager = new Referee_Menager();
	Team_Manager team_manager = new Team_Manager();
	
	public void save() throws IOException
	{
		FileWriter writer = new FileWriter("referee.txt");
		FileWriter writer2 = new FileWriter("teams.txt");
		
		for(int i = 0; i < referee_menager.number_of_referees(); i++)
		{
			writer.write(referee_menager.getList().get(i).getFirst_name()
						 + " " + referee_menager.getList().get(i).getLast_name()
						 + " " + referee_menager.getList().get(i).getAge() + "\n");			
		}
		writer.close();
		
		for(int i = 0; i < team_manager.teamSize(); i++)
		{
			writer2.write("\n" + team_manager.getTeam(i).getName()
			  + " " + team_manager.getTeam(i).getPlayer1().getFirst_name() + " " + team_manager.getTeam(i).getPlayer1().getLast_name() + " " + team_manager.getTeam(i).getPlayer1().getNumber()
			  + " " + team_manager.getTeam(i).getPlayer2().getFirst_name() + " " + team_manager.getTeam(i).getPlayer2().getLast_name() + " " + team_manager.getTeam(i).getPlayer2().getNumber()
			  + " " + team_manager.getTeam(i).getPlayer3().getFirst_name() + " " + team_manager.getTeam(i).getPlayer3().getLast_name() + " " + team_manager.getTeam(i).getPlayer3().getNumber()
			  + " " + team_manager.getTeam(i).getPlayer4().getFirst_name() + " " + team_manager.getTeam(i).getPlayer4().getLast_name() + " " + team_manager.getTeam(i).getPlayer4().getNumber()
			  + " " + team_manager.getTeam(i).getPlayer5().getFirst_name() + " " + team_manager.getTeam(i).getPlayer5().getLast_name() + " " + team_manager.getTeam(i).getPlayer5().getNumber()
			  + " " + team_manager.getTeam(i).getPlayer6().getFirst_name() + " " + team_manager.getTeam(i).getPlayer6().getLast_name() + " " + team_manager.getTeam(i).getPlayer6().getNumber());
		}
		writer2.close();
	}
	
}
