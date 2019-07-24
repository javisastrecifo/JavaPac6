package bank;

import java.util.Scanner;

public class UI {

	public static void start() {
		Scanner reader = new Scanner(System.in);
		while (true) {
			Operations.printMenu();
			String command = reader.nextLine();
			Operations.actionReturn(reader, command);
		}
	}
	

}