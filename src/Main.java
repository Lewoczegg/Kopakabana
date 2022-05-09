import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Kopakabana");
		Referee_Menager referee_menager = new Referee_Menager();
		Team_Manager team_manager = new Team_Manager();
		
		File refereeFile = new File("referee.txt");
		File teamsFile = new File("teams.txt");
		
		Scanner fileScanner = new Scanner(refereeFile);
		Scanner teamScanner = new Scanner(teamsFile);
		
		while(fileScanner.hasNext())
		{
			String first_name = fileScanner.next();
			String last_name = fileScanner.next();
			int age = Integer.parseInt(fileScanner.next());
			referee_menager.add_referee(first_name, last_name, age);
		}
		fileScanner.close();
		
		while(teamScanner.hasNext())
		{
			String team_name = teamScanner.next();
			Player player1 = new Player(teamScanner.next(), teamScanner.next(), Integer.parseInt(teamScanner.next()));
			Player player2 = new Player(teamScanner.next(), teamScanner.next(), Integer.parseInt(teamScanner.next()));
			Player player3 = new Player(teamScanner.next(), teamScanner.next(), Integer.parseInt(teamScanner.next()));
			Player player4 = new Player(teamScanner.next(), teamScanner.next(), Integer.parseInt(teamScanner.next()));
			Player player5 = new Player(teamScanner.next(), teamScanner.next(), Integer.parseInt(teamScanner.next()));
			Player player6 = new Player(teamScanner.next(), teamScanner.next(), Integer.parseInt(teamScanner.next()));
			team_manager.add_team(team_name, player1, player2, player3, player4, player5, player6);
		}
		teamScanner.close();
		new MainMenu();
	}

}
