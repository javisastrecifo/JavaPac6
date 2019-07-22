package Bank;

import java.util.Scanner;

public class Accounts {

	public static void main(String[] args) throws Exception {
		Account account1 = new Account("Account One", 1000);
		Account account2 = new Account("Account Two", 500);
		Scanner reader = new Scanner(System.in);

		while (true) {
			printMenu();
			String comanda = reader.nextLine();
			int compte = 0;
			double quantitat = 0;

			if (comanda.contentEquals("saldo")) {
				printSummary(account1, account2);

			} else if (comanda.contentEquals("diposit")) {
				System.out.print("Quina quantitat? ");
				quantitat = Double.parseDouble(reader.nextLine());
				System.out.print("De quin compte bancari? 1 o 2? ");
				compte = Integer.parseInt(reader.nextLine());
				if (compte == 1) {
					account1.deposit(quantitat);
				} else if (compte == 2) {
					account2.deposit(quantitat);
				} else if ((compte != 0) && (compte != 1) && (compte != 2)) {
					System.out.println("Compte no identificat.");
				}
				printSummary(account1, account2);

			} else if (comanda.contentEquals("retirada")) {
				System.out.print("Quina quantitat? ");
				quantitat = Double.parseDouble(reader.nextLine());
				System.out.print("De quin compte bancari? 1 o 2? ");
				compte = Integer.parseInt(reader.nextLine());
				if (compte == 1) {
					if (account1.getBalance() < quantitat) {
						System.out.println("No hi ha suficients fons per retirar " + quantitat + ".");
					} else {
						account1.withdrawal(quantitat);
					}
				} else if (compte == 2) {
					if (account2.getBalance() < quantitat) {
						System.out.println("No hi ha suficients fons per retirar " + quantitat + ".");
					} else {
						account2.withdrawal(quantitat);
					}
				} else if ((compte != 0) && (compte != 1) && (compte != 2)) {
					System.out.println("Compte no identificat.");
				}
				printSummary(account1, account2);

			} else if (comanda.contentEquals("transferir")) {
				System.out.print("Quina quantitat? ");
				quantitat = Double.parseDouble(reader.nextLine());
				System.out.print("De quin compte d'origen? 1 o 2? ");
				compte = Integer.parseInt(reader.nextLine());
				if (compte == 1) {
					if (account1.getBalance() < quantitat) {
						System.out.println("No hi ha suficients fons per transferir " + quantitat + ".");
					} else {
						transfer(account1, account2, quantitat);
					}
				} else if (compte == 2) {
					if (account1.getBalance() < quantitat) {
						System.out.println("No hi ha suficients fons per transferir " + quantitat + ".");
					} else {
						transfer(account2, account1, quantitat);
					}
				} else if ((compte != 0) && (compte != 1) && (compte != 2)) {
					System.out.println("Compte no identificat.");
				}
				printSummary(account1, account2);

			} else if (comanda.contentEquals("credit")) {
				System.out.print("Quina quantitat vols sol·licitar? ");
				quantitat = Double.parseDouble(reader.nextLine());
				System.out.print("Amb quin compte bancari el vols sol·licitar? 1 o 2? ");
				compte = Integer.parseInt(reader.nextLine());
				Thread.sleep(1000);
				System.out.println("Avaluant les seves dades...");
				Thread.sleep(1000);
				System.out.println("Avaluant les seves dades...");
				Thread.sleep(1000);
				if (compte == 1) {
					personalCredit(account1, quantitat);
				} else if (compte == 2) {
					personalCredit(account2, quantitat);
				} else if ((compte != 0) && (compte != 1) && (compte != 2)) {
					System.out.println("Compte no identificat.");
				}
				printSummary(account1, account2);

			} else if (comanda.contentEquals("fi")) {
				System.out.print("Gràcies per la teva visita.");
				break;
			} else {
				System.out.println("Comanda no identificada");
			}
		}
	}

	// transfereix un valor de un compte a un altre amb un return de //l’operació
	public static void transfer(Account from, Account to, double amount) {
		from.withdrawal(amount);
		to.deposit(amount);
	}

	// depèn del valor del compte decideix si es pot concedir un crèdit o //no a
	// l’usuari
	public static void personalCredit(Account one, double amount) {
		if (one.getBalance() > amount * 4) {
			System.out.println("El crèdit de " + amount + " ha estat concedit!");
			System.out.println("");
			one.deposit(amount);

		} else {
			System.out.println("El crèdit de " + amount + " no pot ser concedit!");
			System.out.println("És necessari tenir un dipòsit superior.");
			System.out.println("");

		}

	}

	// afegeix un mètode nou
	public static void printMenu() {
		System.out.println("CAIXER AUTOMÀTIC del BANC");
		System.out.println("Accions possibles: saldo,  diposit, retirada, transferir, credit, fi.");
		System.out.println("Comanda: ");
	}

	public static void printSummary(Account one, Account two) {
		System.out.println("\nSaldo dels comptes bandaris: ");
		System.out.println(one.toString());
		System.out.println(two.toString());
		System.out.println("");
	}

}
