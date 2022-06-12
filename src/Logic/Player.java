package Logic;

public class Player {
	private String first_name;
	private String last_name;
	private int number;
	
	Player(String first_name, String last_name, int number){
		this.first_name = first_name;
		this.last_name = last_name;
		this.number = number;
	}
	
	public String getFirst_name() { return first_name; }

	public String getLast_name() { return last_name; }

	public int getNumber() { return number; }

}
