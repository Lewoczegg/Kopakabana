
public class Team {
	private String name;
	private Player player1, player2, player3, player4, player5, player6;
	private int wins;
	
	Team(String name, Player player1, Player player2, Player player3, Player player4, Player player5, Player player6)
	{
		this.name=name;
		this.player1=player1;
		this.player2=player2;
		this.player3=player3;
		this.player4=player4;
		this.player5=player5;
		this.player6=player6;
		this.wins=0;
	}
	
	public String getName() {
		return name;
	}
	
	public Player getPlayer1() {
		return player1;
	}
	
	public Player getPlayer2() {
		return player2;
	}
	
	public Player getPlayer3() {
		return player3;
	}
	
	public Player getPlayer4() {
		return player4;
	}
	
	public Player getPlayer5() {
		return player5;
	}
	
	public Player getPlayer6() {
		return player6;
	}
	
	public Integer getWins() {
		return wins;
	}
	
	public void addWin()
	{
		this.wins++;
	}
	public void resetWin()
	{
		this.wins = 0;
	}
	public Team getCopy()
	{
		Player player1c = new Player(player1.getFirst_name(), player1.getLast_name(), player1.getNumber());
		Player player2c = new Player(player2.getFirst_name(), player2.getLast_name(), player2.getNumber());
		Player player3c = new Player(player3.getFirst_name(), player3.getLast_name(), player3.getNumber());
		Player player4c = new Player(player4.getFirst_name(), player4.getLast_name(), player4.getNumber());
		Player player5c = new Player(player5.getFirst_name(), player5.getLast_name(), player5.getNumber());
		Player player6c = new Player(player6.getFirst_name(), player6.getLast_name(), player6.getNumber());
		Team teamc = new Team(this.name, player1c, player2c, player3c, player4c, player5c, player6c);
		return teamc;
	}
	
}
