package model;

import java.util.Arrays;

public class Black_Hole {
    private String name, type;
    private double mass, distance;
    private boolean charge, rotation;
    private Photo[] photosBlack_Hole;

    Black_Hole(String name, double mass, double distance, boolean charge, boolean rotation, String type) {
        this.name = name;
        this.mass = mass;
        this.distance = distance;
        this.charge = charge;
        this.rotation = rotation;
        this.type = type;
        this.photosBlack_Hole = new Photo[5];
    }

    public String getNameHole() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double getdistance() {
        return distance;
    }

    public boolean charge() {
        return charge;
    }

    public boolean rotation() {
        return rotation;
    }

    public String getTypeBlack_Hole() {
        return type;
    }

    public Photo[] getPhotos() {
        return photosBlack_Hole;
    }

    public void addPhoto(Photo photo) {
        for (int i = 0; i < photosBlack_Hole.length; i++) {
            if (photosBlack_Hole[i] == null) {
                photosBlack_Hole[i] = photo;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Black_Hole [name=" + name + ", type=" + type + ", mass=" + mass + ", distance=" + distance + ", charge="
                + charge + ", rotation=" + rotation + ", photosBlack_Hole=" + Arrays.toString(photosBlack_Hole) + "]";
    }

}
