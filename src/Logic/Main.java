package Logic;

import java.io.FileNotFoundException;

import GUI.MainMenu;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		SaveFiles saver = new SaveFiles(); 
		saver.loadFiles(); //Loading data from files
		new MainMenu(); //Starting GUI
	}

}
