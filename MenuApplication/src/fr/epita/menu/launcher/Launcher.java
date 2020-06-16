package fr.epita.menu.launcher;

import java.util.Scanner;

public class Launcher {

	private static final String HARDCODED_LOGIN = "admin";
	private static final String HARDCODED_PASSWORD = "1234";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hi, please enter your user name :");
		String userName = scanner.nextLine();
		System.out.println("please enter your password :");
		String password = scanner.nextLine();

		if (HARDCODED_LOGIN.equals(userName) && HARDCODED_PASSWORD.equals(password)) {
			// authenticated
			String answer = "";
			System.out.println("Thanks, welcome");
			do {
				
				System.out.println("Menu, please choose one action (Create = c, Update = u, Delete = d, Quit = q)");
				System.out.println("what is your choice ? (c|u|d|q)");
				answer = scanner.nextLine();
				scanner.nextDouble();
				switch (answer) {
				case "c":
					System.out.println("welcome to create");
					// TODO complete with real implementation
					break;
				case "u":
					System.out.println("welcome to update");
					// TODO complete with real implementation
					break;
				case "d":
					System.out.println("welcome to delete");
					// TODO complete with real implementation
					break;
					
				case "q":
					System.out.println("exiting...");
					break;
				default:
					System.out.println("The option is not valid");
					break;
				}
			} while (!"q".equals(answer) );

		} else {
			System.out.println("wrong credentials, exiting...");
		}

		scanner.close();

	}

}
