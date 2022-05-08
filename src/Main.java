import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Sawicki chuj");
		Referee_Menager referee_menager = new Referee_Menager();
		File refereeFile = new File("referee.txt");
		Scanner fileScanner = new Scanner(refereeFile);
		while(fileScanner.hasNext())
		{
			String first_name = fileScanner.next();
			String last_name = fileScanner.next();
			int age = Integer.parseInt(fileScanner.next());
			referee_menager.add_referee(first_name, last_name, age);
		}
		fileScanner.close();
		new MainMenu();
	}

}
