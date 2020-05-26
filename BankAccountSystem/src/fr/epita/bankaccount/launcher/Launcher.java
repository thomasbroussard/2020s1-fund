package fr.epita.bankaccount.launcher;

import java.util.Scanner;

import fr.epita.bankaccount.datamodel.Customer;
import fr.epita.bankaccount.datamodel.SavingsAccount;

public class Launcher {

	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
		Customer customer = new Customer();
		System.out.println("please enter your customer name");
		String name = scanner.nextLine();
		customer.setName(name);

		System.out.println("please enter your customer address");
		String address = scanner.nextLine();
		customer.setAddress(address);

		System.out.println("please enter an initial balance for the savings account");
		String rawBalance = scanner.nextLine();
		Double balance = Double.valueOf(rawBalance);

		SavingsAccount account = new SavingsAccount();
		if (balance < 0) {
			System.out.println("The balance cannot be negative, please type another amount:");
			balance = Double.valueOf(scanner.nextLine());
		} else {
			System.out.println("balance is positive, proceeding");
		}
		
		String message = (balance < 0) ? "balance is negative" : "balance is positive";
		//equivalent to
		boolean negative = balance < 0;
		System.out.println(message);
			
		
		
		account.setBalance(balance);

		System.out.println(
				"My customer name is :" + customer.getName() + ", and he's living in " + customer.getAddress());

		System.out.println("My account has a balance of :" + account.getBalance() + " and an interrestRate of "
				+ account.getInterrestRate());

	}

}
