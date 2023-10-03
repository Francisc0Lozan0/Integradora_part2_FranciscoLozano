package model;

import java.util.*;
import ui.Executable;
import model.Galaxy;
import model.Planet;
import model.Black_Hole;
import model.TypeBlack_Hole;
import model.Photo;
import model.Telescope;

public class Controller {

	private Scanner reader;
	private Executable ex;
	private Galaxy galaxy;
	private Black_Hole blackHole;
	private TypeBlack_Hole typeHole;
	private Photo photo;

	private int count;
	private String name_galaxy, type_galaxy, message, type_Hole;
	private Double distance_galaxy;
	private Galaxy[] num_Galaxies;
	private Black_Hole[] numBlack_Holes;
	private Planet[] numPlanets;
	private String[] types = { "None", "Elliptical", "Spiral", "Lenticular", "Irregular" };

	/*
	 * Constructor: Initialize a new Controller instance.
	 * 
	 * Preconditions: None.
	 * 
	 * Postconditions:
	 * - Creates a new Controller object.
	 * - Initializes a Scanner object named 'reader' to read user input from the
	 * console.
	 * - Creates an array of Galaxy objects named 'num_Galaxies' with a maximum
	 * capacity of 50.
	 * - Initializes the 'name_galaxy' variable as an empty string.
	 * - Initializes the 'type_galaxy' variable as an empty string.
	 * - Initializes the 'distance_galaxy' variable to 0.0.
	 * - Initializes the 'message' variable as an empty string.
	 * 
	 * Returns: None.
	 */

	public Controller() {
		reader = new Scanner(System.in);
		num_Galaxies = new Galaxy[50];
		numBlack_Holes = new Black_Hole[50];
		numPlanets = new Planet[50];
		name_galaxy = "";
		type_galaxy = "";
		distance_galaxy = 0.0;
		message = "";
	}

	/*
	 * Method: Create a new galaxy and add it to the list of galaxies.
	 * the method type is analizer
	 * Preconditions: None.
	 * 
	 * Postconditions:
	 * - Creates a new Galaxy object named 'newGalaxies' with the provided
	 * 'name_galaxy', 'type_galaxy', and 'distance_galaxy'.
	 * - Iterates through the list of galaxies 'num_Galaxies'.
	 * - If an empty slot is found in the list, adds the 'newGalaxies' object to
	 * that slot and returns true to indicate a successful creation.
	 * - If there are no empty slots in the list, returns false to indicate that the
	 * memory is full, and the galaxy couldn't be created.
	 * 
	 * @param name_galaxy - The name of the galaxy to be created.
	 * 
	 * @param distance_galaxy - The distance of the galaxy to Earth.
	 * 
	 * @param type_galaxy - The type of the galaxy (e.g., "Elliptical",
	 * "Spiral").
	 * 
	 * Returns: True if the galaxy is successfully created and added, false if the
	 * memory is full and the galaxy
	 * couldn't be created.
	 */

	public boolean createGalaxyWithPhoto(String nameGalaxy, Double distanceGalaxy, String typeGalaxy, String url,
			String nameTelescope) {
		if (!galaxyRepeat(nameGalaxy)) {
			Galaxy newGalaxy = new Galaxy(nameGalaxy, typeGalaxy, distanceGalaxy);

			for (int i = 0; i < num_Galaxies.length; i++) {
				if (num_Galaxies[i] == null) {
					num_Galaxies[i] = newGalaxy;
					break;

				}
			}
		}
		for (int i = 0; i < num_Galaxies.length; i++) {
			if (num_Galaxies[i] != null && num_Galaxies[i].getname_Galaxy().equals(nameGalaxy)) {

				Photo photoGalaxy = new Photo(url, nameTelescope);
				num_Galaxies[i].addPhoto(photoGalaxy);
				return true;
			}
		}

		return false;

	}

	/*
	 * Method: Check if a galaxy with the given name already exists.
	 * the method type is analizer
	 * Preconditions: None.
	 * 
	 * Postconditions:
	 * - Iterates through the list of galaxies 'num_Galaxies'.
	 * - Checks if each galaxy in the list is not null.
	 * - Compares the name of each galaxy with the provided 'name_galaxy'.
	 * - If a galaxy with the same name is found, returns true to indicate that the
	 * galaxy already exists.
	 * - If no matching galaxy is found, returns false to indicate that the galaxy
	 * does not exist.
	 * 
	 * @param name_galaxy - The name of the galaxy to check for existence.
	 * 
	 * Returns: True if a galaxy with the same name already exists, false otherwise.
	 */
	public boolean galaxyRepeat(String name_galaxy) {
		for (int i = 0; i < num_Galaxies.length; i++) {
			if (num_Galaxies[i] != null) {

				if (num_Galaxies[i].getname_Galaxy().equals(name_galaxy)) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * Method: Sort the list of galaxies by their distance from Earth.
	 * the method type is modifier
	 * Preconditions: None.
	 * 
	 * Postconditions:
	 * - Checks if there are any galaxies in the list.
	 * - If galaxies are found, sets 'foundGalaxies' to true.
	 * - Iterates through the list of galaxies 'num_Galaxies'.
	 * - Compares the distance of each galaxy to the distance of other galaxies.
	 * - If a galaxy has a greater distance than another galaxy, swaps their
	 * positions in the list.
	 * - Continues sorting until the list is sorted in ascending order by distance.
	 * 
	 * Returns: None.
	 */

	public void sortGalaxiesByDistance() {
		boolean foundGalaxies = false;

		for (int i = 0; i < num_Galaxies.length; i++) {
			if (num_Galaxies[i] != null) {
				foundGalaxies = true;

				for (int j = i + 1; j < num_Galaxies.length; j++) {
					if (num_Galaxies[j] != null
							&& num_Galaxies[i].getdistance_Galaxy() > num_Galaxies[j].getdistance_Galaxy()) {
						Galaxy temp = num_Galaxies[i];
						num_Galaxies[i] = num_Galaxies[j];
						num_Galaxies[j] = temp;
					}
				}
			}
		}
	}

	/*
	 * Method: Generate a message containing a list of registered galaxies and their
	 * details.
	 * the method type is analizer
	 * Preconditions: None.
	 * 
	 * Postconditions:
	 * - Initializes a StringBuilder named 'messageBuilder'.
	 * - Checks if there are any galaxies in the list.
	 * - If galaxies are found, sets 'foundGalaxies' to true.
	 * - Iterates through the list of galaxies 'num_Galaxies'.
	 * - Appends the index, name, and distance of each galaxy to 'messageBuilder'.
	 * - Separates each galaxy's information with a new line and two spaces for
	 * readability.
	 * - If no galaxies are found, appends a message indicating that there are no
	 * registered galaxies.
	 * - Returns the generated message as a string.
	 * 
	 * Returns: A message containing a list of registered galaxies and their
	 * details.
	 */
	public String generateGalaxyListMessage() {
		StringBuilder messageBuilder = new StringBuilder();
		boolean foundGalaxies = false;

		for (int i = 0; i < num_Galaxies.length; i++) {
			if (num_Galaxies[i] != null) {
				foundGalaxies = true;
				Galaxy temp = num_Galaxies[i];
				messageBuilder.append("\n \n")
						.append(" - ")
						.append(temp.getname_Galaxy())
						.append(" with distance to the Earth: ")
						.append(temp.getdistance_Galaxy())
						.append(" light years ").append("\n");
			}
		}

		if (!foundGalaxies) {
			messageBuilder.append("There are no galaxies registered so far.\n");
		}

		return messageBuilder.toString();
	}

	/*
	 * Method: Retrieve information about a specific galaxy by its name.
	 * the method type is analizer
	 * Preconditions: None.
	 * 
	 * Postconditions:
	 * - Initializes the 'message' variable as an empty string.
	 * - Iterates through the list of galaxies 'num_Galaxies'.
	 * - Checks if each galaxy is not null and if its name matches the provided
	 * 'name_galaxy'.
	 * - If a galaxy with a matching name is found, sets 'message' to the string
	 * representation of that galaxy using 'toString'.
	 * - Breaks out of the loop after finding the first matching galaxy.
	 * - Returns the information about the specific galaxy as a string.
	 * 
	 * @param name_galaxy - The name of the galaxy to retrieve information about.
	 * 
	 * Returns: Information about the specific galaxy as a
	 * string, or an empty string if the galaxy is not found.
	 */

	public String specific_galaxy(String name_galaxy) {
		message = "";
		for (int i = 0; i < num_Galaxies.length; i++) {
			if (num_Galaxies[i] != null && name_galaxy.equals(num_Galaxies[i].getname_Galaxy())) {
				message = num_Galaxies[i].toString();

				break;
			}
		}
		return message;
	}

	/*
	 * Method: Delete a galaxy from the list by its name.
	 * the method type is analizer
	 * Preconditions: None.
	 * 
	 * Postconditions:
	 * - Iterates through the list of galaxies 'num_Galaxies'.
	 * - Retrieves each galaxy and checks if it is not null and if its name matches
	 * the provided 'name_galaxy'.
	 * - If a galaxy with a matching name is found, sets that position in the list
	 * to null, effectively deleting the galaxy.
	 * - Returns true to indicate that the galaxy was successfully deleted.
	 * - If no matching galaxy is found, returns false to indicate that the galaxy
	 * was not found and could not be deleted.
	 * 
	 * @param name_galaxy - The name of the galaxy to delete.
	 * 
	 * Returns: True if the galaxy is successfully deleted, false
	 * if the galaxy is not found and cannot be deleted.
	 */
	public boolean galaxyDeletion(String name_galaxy) {

		for (int i = 0; i < num_Galaxies.length; i++) {
			Galaxy galaxy = num_Galaxies[i];
			if (galaxy != null && galaxy.getname_Galaxy().equals(name_galaxy)) {
				num_Galaxies[i] = null;
				return true;

			}
		}

		return false;
	}

	public boolean createBlack_Hole(String name, double mass, double distance, boolean charge, boolean rotates) {
		String type_Hole = typeBlack_Hole(charge, rotates);

		Black_Hole newBlack_Hole = new Black_Hole(name, mass, distance, charge, rotates, type_Hole);

		for (int i = 0; i < numBlack_Holes.length; i++) {
			if (numBlack_Holes[i] == null) {
				numBlack_Holes[i] = newBlack_Hole;
				return true;
			}
		}

		return false;
	}

	public void addPhoto(String url, String name_telescope) {
		Photo newPhoto = new Photo(url, name_telescope);
	}

	// public void addPhoto(Photo photo) {
	// for (int i = 0; i < photos.length; i++) {
	// if (photos[i] == null) {
	// photos[i] = photo;
	// break;
	// }
	// }
	// }

	public void addArrayPlanets() {

	}

	public void addArrayBlack_Hole() {

	}

	public String typeBlack_Hole(boolean charge, boolean rotates) {
		if (!charge && !rotates) {
			return TypeBlack_Hole.SCHWARZSCHILD.toString();
		} else if (charge && !rotates) {
			return TypeBlack_Hole.REISSER_NORDSTROM.toString();
		} else if (!charge && rotates) {
			return TypeBlack_Hole.KERR.toString();
		} else {
			return TypeBlack_Hole.KERR_NEWMAN.toString();
		}
	}

	public boolean create_Planet(String name, double satellites_Number, double mass, double radium, double volume,
			double density) {
		Planet new_planet = new Planet(name, satellites_Number, mass, radium, volume, density);
		for (int i = 0; i < numPlanets.length; i++) {
			if (numPlanets[i] == null) {
				numPlanets[i] = new_planet;
				return true;
			}
		}
		return false;
	}

}