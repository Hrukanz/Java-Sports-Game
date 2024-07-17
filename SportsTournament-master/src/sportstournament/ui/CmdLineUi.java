package sportstournament.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import sportstournament.core.Athlete;
import sportstournament.core.Manager;
import sportstournament.core.Team;

/**
 * Main runner for the command line application housing all the text and works closely with the managerUI
 */
public class CmdLineUi implements ManagerUi {

	// The scanner used to read input from the console
	private final Scanner scanner;

	// The manager this ui interacts with
	private Manager manager;

	// Flag to indicate when this ui should finish
	private boolean finish = false;

	// An enum representing the various actions the user can perform
	/**
	 * Enum for basic game options
	 */
	private enum Option {
		MATCH("Match"), INVENTORY("Inventory"), STATS("Check Stats"), MARKET("Market"), SLEEP("Sleep"), QUIT("Quit");

		public final String name;

		Option(String name) {
			this.name = name;
		}
	}

	/**
	 * Starts main scanner
	 */
	public CmdLineUi() {
		this.scanner = new Scanner(System.in);
	}

	/**
	 * Setup for command line appliction
	 * @param manager of type Manager
	 */
	public void setup(Manager manager) {
		this.manager = manager;
		final String name = getName("Please enter your name: ");
		final int days = getWeeks();
		final String difficulty = getDifficulty();
		// choose athletets for start team
		Team team = new Team(name, days, manager.startMoney(difficulty), difficulty, starter,1,0);
		System.out.println("\nYour Adventure Begins!");
		manager.setup(team);

	}

	@Override
	/**
	 * Starts command line application
	 */
	public void start() {
		final Option[] options = Option.values();
		while (!finish) {
			if (manager.getAthletes().size()==0) {
				System.out.println("\nYour tournament has ended here are your stats:");
				stats();
				quit();
			}
			System.out.println("\nSelect an option:");

			printOptions();

			try {
				Option option = options[scanner.nextInt()];
				options(option);
			} catch (ArrayIndexOutOfBoundsException e) {
				// Ignore the bad input and continue
			} catch (Exception e) {
				// Discard the unacceptable input
				scanner.nextLine();
			}
		}
	}


	/**
	 * quits game
	 */
	public void quit() {
		finish = true;
	}
	
	/**
	 * confirms quitting of game
	 */
	public boolean confirmQuit() {
		while (true) {
			System.out.println("\nPlease confirm (Y or N)");

			try {
				String input = scanner.next("[yYnN]");
				return input.equalsIgnoreCase("y");
			} catch (Exception e) {
				// Discard the unacceptable input
				scanner.nextLine();
			}
		}
	}

	/**
	 * main options select for game
	 * @param option option
	 */
	private void options(Option option) {
		switch (option) {
		case MATCH:
			match();
			break;
		case STATS:
			stats();
			break;
		case INVENTORY:
			inventory();
			break;
		case MARKET:
			market();
			break;
		case SLEEP:
			sleep();
			break;
		case QUIT:
			manager.finish(confirmQuit());
			break;
		default:
			throw new IllegalStateException("Unexpected value: " + option);
		}
	}


	/**
	 * print options for player
	 */
	private void printOptions() {
		for (Option option : Option.values()) {
			System.out.println("(" + option.ordinal() + ") " + option.name);
		}
	}

	/**
	 * get name of player
	 * @param request line to request name
	 * @return
	 */
	private String getName(String request) {
		while (true) {
			System.out.println(request);

			try {
				String name = scanner.nextLine();
				if (name.matches(NAME_REGEX)) {
					return name;
				}
				System.out.println(NAME_REQUIREMENT);
			} catch (Exception e) {
				// Discard the unacceptable input
				scanner.nextLine();
			}
		}
	}
	
	/**
	 * confirm with user
	 */
	private boolean confirm(String request) {
		while (true) {
			System.out.println(request);

			try {
				String input = scanner.next("[yYnN]");
				return input.equalsIgnoreCase("y");
			} catch (Exception e) {
				// Discard the unacceptable input
				scanner.nextLine();
			}
		}
	}
	
	/**
	 * determine difficulty of player choice
	 * @return
	 */
	private String getDifficulty() {
		while (true) {
			System.out.println("Enter a difficulty: (Easy | Medium | Hard)");

			try {
				String difficulty = scanner.next();
				if (DIFFICULTIES.contains(difficulty)) {
					return difficulty.toLowerCase();
				} else {
					System.out.println("Please enter a valid difficulty");
				}
			} catch (Exception e) {
				// Discard the unacceptable input
				scanner.next();
			}
		}
	}
	
	/**
	 * get days of players choice
	 * @return
	 */
	private int getWeeks() {
		while (true) {
			System.out.println("How many weeks would you like play? ");

			try {
				int weeks = scanner.nextInt();
				if (weeks>=5 && weeks<=15) {
					return weeks;
				}
				System.out.println("Please enter between 5 to 15 weeks");
			} catch (Exception e) {
				// Discard the unacceptable input
				System.out.println("Please enter between 5 to 15 weeks");
				scanner.next();
			}
		}
	}
	
	/**
	 * print athletes in command line
	 * @param athletes
	 */
	private void printAthletes(ArrayList<Athlete> athletes) {
		int increment = 0;
		for (Athlete athlete : athletes) {
			System.out.println("(" + increment + ") " + athlete);
			increment++;
		}
	}

	/**
	 * error report for command line
	 */
	public void reportError(String error) {
		System.out.println("!!!!!!!! " + error + " !!!!!!!!");
	}

}
