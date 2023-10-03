package model;

import java.util.Arrays;

public class Galaxy {

    private String name_galaxy, type_galaxy;
    private Double distance_galaxy;
    private Photo[] photosGalaxy;

    Galaxy(String name_galaxy, String type_galaxy, Double distance_galaxy) {
        this.name_galaxy = name_galaxy;
        this.type_galaxy = type_galaxy;
        this.distance_galaxy = distance_galaxy;
        // this.name_telescope = name_telescope;
        this.photosGalaxy = new Photo[30];
    }

    /*
     * Method: Get the name of the galaxy. the method type is analizer
     * 
     * Preconditions: None.
     * 
     * Postconditions:
     * - Returns the name of the galaxy.
     * 
     * Returns: The name of the galaxy as a string.
     */
    public String getname_Galaxy() {
        return name_galaxy;
    }

    /*
     * Method: Get the type of the galaxy.the method type is analizer
     * 
     * Preconditions: None.
     * 
     * Postconditions:
     * - Returns the type of the galaxy.
     * 
     * Returns: The type of the galaxy as a string.
     */
    public String gettype_Galaxy() {
        return type_galaxy;
    }

    /*
     * Method: Get the distance of the galaxy from Earth in light years.
     * the method type is analizer
     * Preconditions: None.
     * 
     * Postconditions:
     * - Returns the distance of the galaxy from Earth.
     * 
     * Returns: The distance of the galaxy from Earth as a decimal number (double).
     */
    public double getdistance_Galaxy() {
        return distance_galaxy;
    }

    public void addPhoto(Photo photo) {
        for (int i = 0; i < photosGalaxy.length; i++) {
            if (photosGalaxy[i] == null) {
                photosGalaxy[i] = photo;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Galaxy [name_galaxy=" + name_galaxy + ", type_galaxy=" + type_galaxy + ", distance_galaxy="
                + distance_galaxy + ", photos=" + Arrays.toString(photosGalaxy) + "]";
    }

    /*
     * Method: Generate a string representation of the galaxy.
     * the method type is analizer
     * Preconditions: None.
     * 
     * Postconditions:
     * - Constructs a string that describes the galaxy, including its name, type,
     * and distance from Earth.
     * 
     * Returns: A string representation of the galaxy's information.
     */

    // @Override
    // public String toString() {
    // return "The galaxy " + name_galaxy + " is of type " + type_galaxy + " and its
    // "
    // + distance_galaxy + " light years ";
    // }

}
