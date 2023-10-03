package model;

public class Black_Hole {
    private String name, type;
    private double mass, distance;
    private boolean charge, rotation;
    private Photo[] photos;

    Black_Hole(String name, double mass, double distance, boolean charge, boolean rotation, String type) {
        this.name = name;
        this.mass = mass;
        this.distance = distance;
        this.charge = charge;
        this.rotation = rotation;
        this.type = type;
        this.photos = new Photo[5];
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
        return photos;
    }

    public void addPhoto(Photo photo) {
        for (int i = 0; i < photos.length; i++) {
            if (photos[i] == null) {
                photos[i] = photo;
                break;
            }
        }
    }

}
