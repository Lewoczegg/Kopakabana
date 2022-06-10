package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
			writer2.write(team_manager.getTeam(i).getName()
			  + " " + team_manager.getTeam(i).getPlayer1().getFirst_name() + " " + team_manager.getTeam(i).getPlayer1().getLast_name() + " " + team_manager.getTeam(i).getPlayer1().getNumber()
			  + " " + team_manager.getTeam(i).getPlayer2().getFirst_name() + " " + team_manager.getTeam(i).getPlayer2().getLast_name() + " " + team_manager.getTeam(i).getPlayer2().getNumber()
			  + " " + team_manager.getTeam(i).getPlayer3().getFirst_name() + " " + team_manager.getTeam(i).getPlayer3().getLast_name() + " " + team_manager.getTeam(i).getPlayer3().getNumber()
			  + " " + team_manager.getTeam(i).getPlayer4().getFirst_name() + " " + team_manager.getTeam(i).getPlayer4().getLast_name() + " " + team_manager.getTeam(i).getPlayer4().getNumber()
			  + " " + team_manager.getTeam(i).getPlayer5().getFirst_name() + " " + team_manager.getTeam(i).getPlayer5().getLast_name() + " " + team_manager.getTeam(i).getPlayer5().getNumber()
			  + " " + team_manager.getTeam(i).getPlayer6().getFirst_name() + " " + team_manager.getTeam(i).getPlayer6().getLast_name() + " " + team_manager.getTeam(i).getPlayer6().getNumber()
			  + " " + team_manager.getTeam(i).getWins() + " " + team_manager.getTeam(i).DodgeballWins() + " " + team_manager.getTeam(i).VolleyballWins() + " " + team_manager.getTeam(i).TugOfWarWins() + " " + team_manager.getTeam(i).Trophies() + "\n");
		}
		writer2.close();
		
		
	}
	
	public void loadFiles() throws FileNotFoundException
	{
		File refereeFile = new File("referee.txt");
		File teamsFile = new File("teams.txt");
		
		Scanner refereeScanner = new Scanner(refereeFile);
		Scanner teamScanner = new Scanner(teamsFile);
		
		while(refereeScanner.hasNext())
		{
			String first_name = refereeScanner.next();
			String last_name = refereeScanner.next();
			int age = Integer.parseInt(refereeScanner.next());
			referee_menager.add_referee(first_name, last_name, age);
		}
		refereeScanner.close();
		
		while(teamScanner.hasNext())
		{
			String team_name = teamScanner.next();
			Player player1 = new Player(teamScanner.next(), teamScanner.next(), Integer.parseInt(teamScanner.next()));
			Player player2 = new Player(teamScanner.next(), teamScanner.next(), Integer.parseInt(teamScanner.next()));
			Player player3 = new Player(teamScanner.next(), teamScanner.next(), Integer.parseInt(teamScanner.next()));
			Player player4 = new Player(teamScanner.next(), teamScanner.next(), Integer.parseInt(teamScanner.next()));
			Player player5 = new Player(teamScanner.next(), teamScanner.next(), Integer.parseInt(teamScanner.next()));
			Player player6 = new Player(teamScanner.next(), teamScanner.next(), Integer.parseInt(teamScanner.next()));
			int wins = Integer.parseInt(teamScanner.next());
			int dodgeball_wins = Integer.parseInt(teamScanner.next());
			int volleyball_wins = Integer.parseInt(teamScanner.next());
			int tugOfWar_wins = Integer.parseInt(teamScanner.next());
			int trophies = Integer.parseInt(teamScanner.next());
			team_manager.add_team(team_name, player1, player2, player3, player4, player5, player6,
					wins, dodgeball_wins, volleyball_wins, tugOfWar_wins, trophies);
		}
		teamScanner.close();
	}
	
	
}
