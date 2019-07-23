package bank;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Account account1 = new Account("Account One", 1000);
		Account account2 = new Account("Account Two", 500);
		Scanner reader = new Scanner(System.in);

		while (true) {
			printMenu();
			String command = reader.nextLine();
			int inputAccount = 0;
			double amount = 0;

			if (command.contentEquals("saldo")) {
				printSummary(account1, account2);

			} else if (command.contentEquals("diposit")) {
				System.out.print("Quina quantitat? ");
				amount = Double.parseDouble(reader.nextLine());
				System.out.print("De quin compte bancari? 1 o 2? ");
				inputAccount = Integer.parseInt(reader.nextLine());
				if (inputAccount == 1) {
					account1.deposit(amount);
				} else if (inputAccount == 2) {
					account2.deposit(amount);
				} else if ((inputAccount != 0) && (inputAccount != 1) && (inputAccount != 2)) {
					System.out.println("Compte no identificat.");
				}
				printSummary(account1, account2);

			} else if (command.contentEquals("retirada")) {
				System.out.print("Quina quantitat? ");
				amount = Double.parseDouble(reader.nextLine());
				System.out.print("De quin compte bancari? 1 o 2? ");
				inputAccount = Integer.parseInt(reader.nextLine());
				if (inputAccount == 1) {
					if (account1.getBalance() < amount) {
						System.out.println("No hi ha suficients fons per retirar " + amount + ".");
					} else {
						account1.withdrawal(amount);
					}
				} else if (inputAccount == 2) {
					if (account2.getBalance() < amount) {
						System.out.println("No hi ha suficients fons per retirar " + amount + ".");
					} else {
						account2.withdrawal(amount);
					}
				} else if ((inputAccount != 0) && (inputAccount != 1) && (inputAccount != 2)) {
					System.out.println("Compte no identificat.");
				}
				printSummary(account1, account2);

			} else if (command.contentEquals("transferir")) {
				System.out.print("Quina quantitat? ");
				amount = Double.parseDouble(reader.nextLine());
				System.out.print("De quin compte d'origen? 1 o 2? ");
				inputAccount = Integer.parseInt(reader.nextLine());
				if (inputAccount == 1) {
					if (account1.getBalance() < amount) {
						System.out.println("No hi ha suficients fons per transferir " + amount + ".");
					} else {
						transfer(account1, account2, amount);
					}
				} else if (inputAccount == 2) {
					if (account1.getBalance() < amount) {
						System.out.println("No hi ha suficients fons per transferir " + amount + ".");
					} else {
						transfer(account2, account1, amount);
					}
				} else if ((inputAccount != 0) && (inputAccount != 1) && (inputAccount != 2)) {
					System.out.println("Compte no identificat.");
				}
				printSummary(account1, account2);

			} else if (command.contentEquals("credit")) {
				System.out.print("Quina quantitat vols sol·licitar? ");
				amount = Double.parseDouble(reader.nextLine());
				System.out.print("Amb quin compte bancari el vols sol·licitar? 1 o 2? ");
				inputAccount = Integer.parseInt(reader.nextLine());
				if (inputAccount == 1) {
					personalCredit(account1, amount);
				} else if (inputAccount == 2) {
					personalCredit(account2, amount);
				} else if ((inputAccount != 0) && (inputAccount != 1) && (inputAccount != 2)) {
					System.out.println("Compte no identificat.");
				}
				printSummary(account1, account2);

			} else if (command.contentEquals("fi")) {
				System.out.print("Gràcies per la teva visita.");
				break;
			} else {
				System.out.println("Comanda no identificada.");
			}
		}
	}


	public static void transfer(Account from, Account to, double amount) {
		from.withdrawal(amount);
		to.deposit(amount);
	}


	public static void personalCredit(Account one, double amount) {
		if (one.getBalance() > amount * 4) {
			System.out.println("El crèdit de " + amount + " ha estat concedit!");
			System.out.println("");
			one.deposit(amount);

		} else {
			System.out.println("El crèdit de " + amount + " no pot ser concedit!");
			System.out.println("És necessari tenir uns fons superior.");
			System.out.println("");

		}

	}

	public static void printMenu() {
		System.out.println("CAIXER AUTOMÀTIC del BANC");
		System.out.println("Accions possibles: saldo,  diposit, retirada, transferir, credit, fi.");
		System.out.println("Comanda: ");
	}

	public static void printSummary(Account one, Account two) {
		System.out.println("\nSaldo dels comptes bancaris: ");
		System.out.println(one.toString());
		System.out.println(two.toString());
		System.out.println("");
	}

	public static Account accountReturn (int opcio) {
		if (opcio == 1) {
			return account1;
		} else if (opcio == 2) {
			account2.deposit(quantitat);
		} else if ((opcio != 0) && (opcio != 1) && (opcio != 2)) {
			System.out.println("Compte no identificat.");
		}
	}
	
	public static boolean checkAccountStatus (Account account1) {
		
		return true;
	}
	
}
