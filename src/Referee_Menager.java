
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Referee_Menager {

	Referee_Menager()
	{

	}
	private static ArrayList<Referee> referee_list = new ArrayList<Referee>();
	
	public void add_referee() throws IOException
	{
		String first_name = JOptionPane.showInputDialog("Enter first name of a referee");
		String last_name = JOptionPane.showInputDialog("Enter last name of a referee");
		int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age of a referee"));
		referee_list.add(new Referee(first_name, last_name, age));
		FileWriter writer = new FileWriter("referee.txt", true);
		writer.write("\n" + first_name + " " + last_name + " " + age);
		writer.close();
	}
	public void add_referee(String first_name, String last_name, int age)
	{
		referee_list.add(new Referee(first_name, last_name, age));
	}
	
	public void show_referee()
	{
		StringBuilder list = new StringBuilder();
		for(int i = 0; i < referee_list.size(); i++)
		{
			list.append(i+1 + ". " + referee_list.get(i).getFirst_name() + " " + referee_list.get(i).getLast_name() + " " + referee_list.get(i).getAge() + "\n");
		}
		JOptionPane.showMessageDialog(null, list, "List", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void remove_referee() throws FileNotFoundException
	{
		PrintWriter write_to_file = new PrintWriter("referee.txt");
		StringBuilder list = new StringBuilder();
		for(int i = 0; i < referee_list.size(); i++)
		{
			list.append(i+1 + ". " + referee_list.get(i).getFirst_name() + " " + referee_list.get(i).getLast_name() + " " + referee_list.get(i).getAge() + "\n");
		}
		int choice = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of a referee you want to remove: \n" + list));
		referee_list.remove(choice - 1);
		for(int i = 0; i < referee_list.size(); i++)
		{
			list.setLength(0);
			list.append(referee_list.get(i).getFirst_name() + " " + referee_list.get(i).getLast_name() + " " + referee_list.get(i).getAge() + "\n");
			write_to_file.print(list);
		}
		write_to_file.close();
	}
	
	public int number_of_referees()
	{
		return referee_list.size();
	}
}
