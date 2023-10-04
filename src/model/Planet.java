package model;

import java.util.Arrays;

public class Planet {
    private String name;
    private double satellites_Number, radium, mass, volume, density;
    private Photo[] photosPlanets;

    public Planet(String name, double satellites_Number, double mass, double radium, double volume, double density) {
        this.name = name;
        this.satellites_Number = satellites_Number;
        this.radium = radium;
        this.mass = mass;
        this.volume = volume;
        this.density = density;
        this.photosPlanets = new Photo[50];

    }

    public String getName() {
        return name;
    }

    public double getsatellites_Number() {
        return satellites_Number;
    }

    public double getRadium() {
        return radium;
    }

    public double getMass() {
        return mass;
    }

    public double getDensity() {
        return density;
    }

    public void addPhoto(Photo photo) {
        for (int i = 0; i < photosPlanets.length; i++) {
            if (photosPlanets[i] == null) {
                photosPlanets[i] = photo;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Planet [name=" + name + ", satellites_Number=" + satellites_Number + ", radium=" + radium + ", mass="
                + mass + ", volume=" + volume + ", density=" + density + ", photosPlanets="
                + Arrays.toString(photosPlanets) + "]";
    }

}
