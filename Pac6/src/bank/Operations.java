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

	// DISTRIBUIDOR

	public static void actionReturn(Scanner reader, String command) {

		if (command.equalsIgnoreCase("saldo")) {
			Operations.printSummary();

		} else if (command.equalsIgnoreCase("ingres")) {
			double amount = askAmount(reader, "Quina quantitat vols ingressar? ");
			returnAccount(askAccount(reader, "De quin compte bancari? 1, 2 o 3? ")).deposit(amount);
			Operations.printSummary();

		} else if (command.equalsIgnoreCase("retirada")) {
			double amount = askAmount(reader, "Quina quantitat vols retirar? ");
			int accountNumber = askAccount(reader, "De quin compte bancari? 1, 2 o 3? ");
			if (enoughBalance(returnAccount(accountNumber), amount)) {
				returnAccount(accountNumber).withdrawal(amount);
			}
			Operations.printSummary();

		} else if (command.equalsIgnoreCase("transferir")) {
			double amount = askAmount(reader, "Quina quantitat vols transferir? ");
			int origin = askAccount(reader, "De quin compte d'origen? 1, 2 o 3? ");
			if (enoughBalance(returnAccount(origin), amount)) {
			} else {
				origin = askAccount(reader,
						" De quin compte d'origen? 1, 2 o 3?");
			}
			int destination = askAccount(reader, "A quin compte de destí? 1, 2 o 3?");
			transfer(returnAccount(origin), returnAccount(destination), amount);
			Operations.printSummary();

		} else if (command.equalsIgnoreCase("credit")) {
			double amount = askAmount(reader, "Quina quantitat vols sol·licitar com a crèdit? ");
			int accountNumber = askAccount(reader, "De quin compte d'origen? 1, 2 o 3? ");
			personalCredit (returnAccount(accountNumber), amount);
			Operations.printSummary();

		} else if (command.equalsIgnoreCase("fi")) {
			System.out.print("Gràcies per la teva visita.");
			System.exit(0);

		} else {
			System.out.println("Comanda no identificada.");
		}
	}

	// OPERACIONS MONETARIES

	public static void transfer(Account from, Account to, double amount) {
		from.withdrawal(amount);
		to.deposit(amount);
	}

	public static boolean enoughBalance(Account account, double amount) {
		if (account.getBalance() > amount) {
			return true;
		} else {
			System.out.print("No hi ha suficients fons per retirar " + amount + "€.");
			return false;
		}
	}

	public static void personalCredit(Account account, double amount) {
		if (account.getBalance() > amount * 4) {
			System.out.println("El crèdit de " + amount + " ha estat concedit!");
			System.out.println("");
			account.deposit(amount);

		} else {
			System.out.println("El crèdit de " + amount + " no pot ser concedit!");
			System.out.println("És necessari tenir uns fons superiors.");
		}
	}

	// METODES DE PREGUNTES COMPTES

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
		if (input > (accountList.size()) || (input < 0)) {
			return null;
		} else {
			return accountList.get(input - 1);
		}
	}

	// METODES MENUS

	public static void printMenu() {
		System.out.println("CAIXER AUTOMÀTIC del BANC");
		System.out.println("Accions possibles: saldo, ingres, retirada, transferir, credit, fi.");
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
