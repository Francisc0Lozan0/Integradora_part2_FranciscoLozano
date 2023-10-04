package ui;

import java.util.*;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller cont;
	private int decision;
	private String name_galaxy, type_galaxy, url, name_telescope;
	private Double distance_galaxy;
	private boolean result, charge, rotates;;

	/*
	 * method Constructor: Initializes an Executable object.
	 * 
	 * Precondition: None.
	 * 
	 * Postcondition:
	 * - A new Executable object is created with the following attributes
	 * initialized:
	 * - reader is set to a new Scanner object using System.in as input.
	 * - cont is set to a new Controller object.
	 * - decision is set to 5.
	 * - name_galaxy is an empty string.
	 * - type_galaxy is an empty string.
	 * - distance_galaxy is set to 0.0.
	 * - result is set to false.
	 * 
	 * Returns: None.
	 */

	private Executable() {
		reader = new Scanner(System.in);
		cont = new Controller();
		decision = 5;
		name_galaxy = "";
		type_galaxy = "";
		distance_galaxy = 0.0;
		result = false;
	}

	/*
	 * Method: Run the executable program.
	 * 
	 * Precondition: None.
	 * 
	 * Postcondition:
	 * - The program begins execution.
	 * - A welcome message is printed to the console.
	 * - A loop is started, allowing the user to select various options until the
	 * decision
	 * variable becomes 0.
	 * - The selected option is read from user input.
	 * - Depending on the option selected, various actions are taken, which may
	 * include
	 * creating a galaxy, displaying registered galaxies sorted by distance,
	 * consulting a specific galaxy, deleting a galaxy, or exiting the program.
	 * 
	 * Returns: None.
	 */

	public void run() {
		System.out.println(
				"	                                                                           WELCOME\n");
		while (decision != 0) {
			System.out.println(
					"select an option\n1. create galaxy\n2. see registered galaxies\n3. consult specific galaxy\n4. delete galaxy\n0. Exit");
			decision = reader.nextInt();

			switch (decision) {
				case 1:
					create_galaxy();
					dataCreateBlack_Hole();
					dataCreate_Planet();

					break;
				case 2:
					System.out.println("The galaxies registered so far are:");
					cont.sortGalaxiesByDistance();
					System.out.println(cont.generateGalaxyListMessage());
					break;

				case 3:
					System.out.println("The galaxies registered so far are:");
					cont.sortGalaxiesByDistance();
					System.out.println(cont.generateGalaxyListMessage());
					see_specificGalaxy();
					break;

				case 4:
					System.out.println("The galaxies registered so far are:");
					cont.sortGalaxiesByDistance();
					System.out.println(cont.generateGalaxyListMessage());
					galaxyDeletion();
					break;
				case 0:
					System.out.println("exiting...");

				default:
					break;

			}
		}

	}

	/*
	 * Method: Create a galaxy with user-specified attributes.the method type is
	 * modifier
	 * 
	 * Precondition: None.
	 * 
	 * Postcondition:
	 * - Prompts the user to enter a name for the galaxy.
	 * - Prompts the user to enter a distance for the galaxy.
	 * - Prompts the user to choose a type for the galaxy.
	 * - Calls the 'cont.create_galaxy' method with the provided galaxy attributes.
	 * - If the 'cont.create_galaxy' method returns true, a success message is
	 * printed to the console.
	 * - If the 'cont.create_galaxy' method returns false, an error message
	 * indicating that memory is full is printed.
	 * 
	 * @param name_galaxy - The variable to store the name of the galaxy.
	 * 
	 * @param distance_galaxy - The variable to store the distance of the galaxy.
	 * 
	 * @param type_galaxr - The variable to store the type of the galaxy.
	 * 
	 * Returns: None.
	 */

	private void create_galaxy() {
		name_galaxy = enterGalaxyName();

		distance_galaxy = enterGalaxyDistance();

		type_galaxy = chooseGalaxyType();

		boolean cut = false;
		while (cut == false) {
			System.out.println("Do you want add a photo? \n No \n Yes");
			String add = reader.nextLine();
			switch (add) {
				case "No":
					cut = true;
					break;

				default:
					System.out.println("URL");
					url = reader.nextLine();
					System.out.println("name of the telescope");
					name_telescope = reader.nextLine();
					cont.createGalaxyWithPhoto(name_galaxy, distance_galaxy, type_galaxy, url, name_telescope);

			}
		}
		if (cont.createGalaxyWithPhoto(name_galaxy, distance_galaxy, type_galaxy, url, name_telescope)) {
			System.out.println("Galaxy information saved successfully.");
		} else {
			System.out.println("Error, memory is full.");
		}

	}

	/*
	 * Method: Prompt the user to enter a unique name for a galaxy.the method type
	 * is modifier
	 * 
	 * Precondition: None.
	 * 
	 * Postcondition:
	 * - Displays a prompt to the user to enter a galaxy name.
	 * - Reads the user input for the galaxy name.
	 * - Checks if the entered galaxy name is already registered using
	 * 'cont.galaxyRepeat'.
	 * - If the entered galaxy name is already registered, displays an error message
	 * and prompts the user to enter a new name.
	 * - Repeats the input process until a unique galaxy name is provided.
	 * 
	 * Returns: The unique name of the galaxy entered by the user.
	 */
	private String enterGalaxyName() {
		do {
			System.out.println("Enter the Galaxy name:");
			reader.nextLine();
			name_galaxy = reader.nextLine();
			if (cont.galaxyRepeat(name_galaxy)) {
				System.out.println("Galaxy name is already registered.");
			}
		} while (cont.galaxyRepeat(name_galaxy));
		return name_galaxy;
	}

	/*
	 * Method: Ask the user to enter the distance of a galaxy from Earth in light
	 * years. the method type is modifier
	 * 
	 * Preconditions: None.
	 * 
	 * Postconditions:
	 * - Show a message to the user to input the galaxy's distance.
	 * - Read the user's input as a decimal number representing the distance in
	 * light years.
	 * - Check if the input is a valid numeric value.
	 * - If the input is valid, return the entered distance as a decimal number
	 * (double).
	 * - If the input is not valid (e.g., not a number), display an error message
	 * and ask the user to input a valid numeric distance.
	 * - Repeat the input process until a valid numeric distance is provided.
	 * 
	 * Returns: The distance of the galaxy from Earth in light years (as a decimal
	 * number, double).
	 */

	private double enterGalaxyDistance() {
		boolean validInput = false;

		while (!validInput) {
			try {
				System.out.println("Enter the Galaxy distance to earth in light years:");
				distance_galaxy = reader.nextDouble();
				validInput = true;
			} catch (Exception e) {
				System.out.println("Error: Enter a valid numeric distance.");
				reader.nextLine();
			}
		}

		return distance_galaxy;
	}

	/*
	 * Method: Let the user choose the type of the galaxy.the method type is
	 * modifier
	 * 
	 * Preconditions: None.
	 * 
	 * Postconditions:
	 * - Displays a menu for the user to choose the type of galaxy.
	 * - Reads the user's choice as a string input.
	 * - Checks if the input is a valid choice (1-4) for galaxy type.
	 * - If the input is valid, sets the galaxy type accordingly.
	 * - If the input is not valid, displays an error message and asks the user to
	 * enter a valid type (1-4).
	 * - Repeats the input process until a valid type is selected.
	 * 
	 * Returns: The selected type of the galaxy as a string (e.g., "Elliptical",
	 * "Spiral", "Lenticular", or "Irregular").
	 */

	private String chooseGalaxyType() {
		boolean validInput = false;
		reader.nextLine();

		while (!validInput) {
			System.out.println("Enter the type of the Galaxy:\n1. Elliptical\n2. Spiral\n3. Lenticular\n4. Irregular");
			String input = reader.nextLine();

			switch (input) {
				case "1":
					type_galaxy = "Elliptical";
					validInput = true;
					break;
				case "2":
					type_galaxy = "Spiral";
					validInput = true;
					break;
				case "3":
					type_galaxy = "Lenticular";
					validInput = true;
					break;
				case "4":
					type_galaxy = "Irregular";
					validInput = true;
					break;
				default:
					System.out.println("Error: Enter a valid type (1-4).");
					break;
			}
		}

		return type_galaxy;
	}

	/*
	 * Method: Allow the user to view specific information about a galaxy.
	 * the method type is modifier
	 * Preconditions: None.
	 * 
	 * Postconditions:
	 * - Prompts the user to enter the name of the galaxy they want to view.
	 * - Reads the user's input as the name of the galaxy.
	 * - Calls the 'cont.specific_galaxy' method to retrieve information about the
	 * specified galaxy.
	 * - If the result is empty, displays an error message indicating that the
	 * galaxy was not found.
	 * - If the result is not empty, displays the information about the galaxy to
	 * the user.
	 * 
	 * Returns: None.
	 */

	public void see_specificGalaxy() {
		reader.nextLine();
		System.out.println("Enter the name of the galaxy to evaluate: \n");
		name_galaxy = reader.nextLine();
		String result = cont.specific_galaxy(name_galaxy);

		if (result.isEmpty()) {
			System.out.println("Error: Galaxy not found. \n ");
		} else {
			System.out.println("\n" + result + "\n");
		}
	}

	/*
	 * Method: Allows the user to delete a galaxy.
	 * the method type is modifier
	 * Preconditions:
	 * - None.
	 * 
	 * Postconditions:
	 * - Prompts the user to enter the name of the galaxy they want to delete.
	 * - Reads the user's input as the name of the galaxy.
	 * - If the user enters 'close', the method exits.
	 * - Calls the 'cont.galaxyDeletion' method to attempt to delete the specified
	 * galaxy.
	 * - If the galaxy is not found, displays an error message indicating that the
	 * galaxy was not found and continues to prompt for a valid galaxy name.
	 * - Repeats the process until a valid galaxy is found and deleted or until the
	 * user enters 'close'.
	 * - Displays a success message after successfully deleting the galaxy.
	 * 
	 * Returns: None.
	 */

	public void galaxyDeletion() {
		boolean cut = false;
		reader.nextLine();

		do {
			System.out.println("Enter the name of the galaxy to delete, or type 'close' to exit: ");
			name_galaxy = reader.nextLine();

			if (name_galaxy.equalsIgnoreCase("close")) {
				cut = true;
				break;
			}

			cut = cont.galaxyDeletion(name_galaxy);

			if (!cut) {
				System.out.println("Error: Galaxy not found.");
				continue;
			} else {
				System.out.println("\nGalaxy deleted successfully.\n");
			}
		} while (!cut);
	}

	public void dataCreateBlack_Hole() {
		System.out.println("Enter the name of the black hole");
		String name = reader.nextLine();
		System.out.println("Enter name the mass of the black hole");
		double mass = reader.nextDouble();
		System.out.println("Enter name the distance of the Earth");
		double distance = reader.nextDouble();
		System.out.println("Does the Black Hole have charge?\n1. Yes\n2. No");
		int chargeDecision = reader.nextInt();
		boolean charge = (chargeDecision == 1);
		System.out.println("Does the Black Hole rotate?\n1. Yes\n2. No");
		int rotatesDecision = reader.nextInt();
		boolean rotates = (rotatesDecision == 1);

		boolean cut = false;
		while (cut == false) {
			System.out.println("Do you want add a photo? \n No \n Yes");
			String add = reader.nextLine();
			switch (add) {
				case "No":
					cut = true;
					break;

				default:
					System.out.println("URL");
					url = reader.nextLine();
					System.out.println("name of the telescope");
					name_telescope = reader.nextLine();
					cont.createBlack_Hole(name, mass, distance, charge, rotates, url, name_telescope);

			}
		}
		reader.next();
	}

	public void dataCreate_Planet() {

		System.out.println("Enter the name of the Planet");
		String name = reader.nextLine();
		System.out.println("Enter the number of satellites on the planet");
		double satellites_Number = reader.nextDouble();
		System.out.println("Enter the radium of the planet");
		double radium = reader.nextDouble();
		System.out.println("Enter the volume of the planet");
		double volume = reader.nextDouble();
		System.out.println("Enter the mass of the planet");
		double mass = reader.nextDouble();
		System.out.println("Enter the density of the planet");
		double density = reader.nextDouble();

		boolean cut = false;
		while (cut == false) {
			System.out.println("Do you want add a photo? \n No \n Yes");
			String add = reader.nextLine();
			switch (add) {
				case "No":
					cut = true;
					break;

				default:
					System.out.println("URL");
					url = reader.nextLine();
					System.out.println("name of the telescope");
					name_telescope = reader.nextLine();
					cont.create_Planet(name, satellites_Number, mass, radium, volume,
							density, url, name_telescope);

			}
		}
		reader.next();
	}

	/*
	 * Method: The main entry point of the application.
	 * 
	 * Preconditions: None.
	 * 
	 * Postconditions:
	 * - Creates an instance of the 'Executable' class named 'mainApp'.
	 * - Calls the 'run' method on the 'mainApp' instance to start the application.
	 * 
	 * Returns: None.
	 */
	public static void main(String[] args) {
		Executable mainApp = new Executable();
		mainApp.run();
	}

}
