package bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Operations {

	static ArrayList<Account> accountList = new ArrayList<Account>();

	public static void createAccounts() {
		// ArrayList<Account> accountList = new ArrayList<Account>();
		Account account1 = new Account("Account One", 1000);
		Account account2 = new Account("Account Two", 500);
		Account account3 = new Account("Account Three", 2300);
		accountList.add(account1);
		accountList.add(account2);
		accountList.add(account3);
		getAccountList(accountList);
	}

	public static ArrayList<Account> getAccountList(ArrayList<Account> accountList) {
		return accountList;
	}

	public static void actionReturn(Scanner reader, String command) {

		if (command.contentEquals("saldo")) {
			Operations.printSummary();

		} else if (command.contentEquals("diposit")) {
			askAmount(reader, "Quina quantitat vols ingressar? ");
			askAccount(reader, "De quin compte bancari? 1, 2 o 3? ");

		} else if (command.contentEquals("retirada")) {
			double amount = askAmount(reader, "Quina quantitat vols retirar? ");
			int accountNumber = askAccount(reader, "De quin compte bancari? 1, 2 o 3? ");
			if (enoughBalance(returnAccount(accountNumber), amount)) {
				
			}

		} else if (command.contentEquals("transferir")) {
			askAmount(reader, "Quina quantitat vols transferir? ");
			askAccount(reader, "De quin compte d'origen? 1, 2 o 3? ");

		} else if (command.contentEquals("credit")) {
			askAmount(reader, "Quina quantitat vols sol·licitar com a crèdit? ");
			askAccount(reader, "De quin compte d'origen? 1, 2 o 3? ");

		} else if (command.contentEquals("fi")) {
			System.out.print("Gràcies per la teva visita.");

		} else {
			System.out.println("Comanda no identificada.");
		}
	}

	public static double askAmount(Scanner reader, String pregunta) {
		double amount = 0;
		System.out.print(pregunta);
		amount = Double.parseDouble(reader.nextLine());
		return amount;
	}

	public static int askAccount(Scanner reader, String pregunta) {
		int inputAccount = 0;
		System.out.print(pregunta);
		inputAccount = Integer.parseInt(reader.nextLine());
		return inputAccount;
	}

	public static Account returnAccount(int input) {
		int position = -1;
		if ((input > (accountList.size() + 1)) || (input < 0)) {
			return null;
		} else {
			return accountList.get(position + 1);
		}
	}
	
	public static boolean enoughBalance (Account account, double amount) {
		if (account.getBalance() > amount)
	}

	public static void printMenu() {
		System.out.println("CAIXER AUTOMÀTIC del BANC");
		System.out.println("Accions possibles: saldo, diposit, retirada, transferir, credit, fi.");
		System.out.println("Comanda: ");
	}

	public static void printSummary() {
		System.out.println("\nSaldo dels comptes bancaris: ");

		for (Account account : accountList) {
			System.out.println(account.toString());
		}
		System.out.println("");
	}

}
