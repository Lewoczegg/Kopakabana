package Logic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Referee_Menager {

	public Referee_Menager() {}

	private static ArrayList<Referee> referee_list = new ArrayList<Referee>();
	
	public void add_referee(){
		String first_name = JOptionPane.showInputDialog("Enter first name of a referee");
		String last_name = JOptionPane.showInputDialog("Enter last name of a referee");
		int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age of a referee"));
		referee_list.add(new Referee(first_name, last_name, age));
	}
	
	public void add_referee(String first_name, String last_name, int age){
		referee_list.add(new Referee(first_name, last_name, age));
	}
	
	public void show_referee()
	{
		StringBuilder list = new StringBuilder();
		for(int i = 0; i < referee_list.size(); i++)
		{
			list.append(i+1 + ". "
						+ referee_list.get(i).getFirst_name()
						+ " " + referee_list.get(i).getLast_name()
						+ " " + referee_list.get(i).getAge() + "\n");
		}
		JOptionPane.showMessageDialog(null, list, "List", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void remove_referee()
	{
			StringBuilder list = new StringBuilder();
			for(int i = 0; i < referee_list.size(); i++)
			{
				list.append(i+1 + ". "
							+ referee_list.get(i).getFirst_name()
							+ " " + referee_list.get(i).getLast_name()
							+ " " + referee_list.get(i).getAge() + "\n");
			}
			int choice = Integer.parseInt(JOptionPane.showInputDialog
						("Enter the number of a referee you want to remove: \n" + list));
			referee_list.remove(choice - 1);
	}
	
	public int number_of_referees(){ return referee_list.size(); }
	
	public String RandomReferee(){
		Random random = new Random();
		int x = random.nextInt(referee_list.size());
		String random_ref;
		random_ref = referee_list.get(x).getFirst_name() + " " + referee_list.get(x).getLast_name();
		return random_ref;
	}
	
	public ArrayList<Referee> getList(){ return referee_list; }
	
}
