
public class Team {
	private String name;
	private Player player1, player2, player3, player4, player5, player6;
	
	Team(String name, Player player1, Player player2, Player player3, Player player4, Player player5, Player player6)
	{
		this.name=name;
		this.player1=player1;
		this.player2=player2;
		this.player3=player3;
		this.player4=player4;
		this.player5=player5;
		this.player6=player6;
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
	
}
