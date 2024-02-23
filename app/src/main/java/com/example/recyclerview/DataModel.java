package com.example.recyclerview;

public class DataModel {

    private String name;
    private String race;
    private int image; // Integer
    private int id_;

    private String description;

    public DataModel(String name, String race, int image, String description, int id_) {
        this.name = name;
        this.race = race;
        this.image = image;
        this.description=description;
        this.id_ = id_;
    }

    public void setDescription(String description){this.description=description;}
    public String getDescription(){return description;}

    public void setName(String name) {
        this.name = name;
    }

    public void setRace(String version) {
        this.race = race;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public int getId_() {
        return id_;
    }

    public int getImage() {
        return image;
    }
}








