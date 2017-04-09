package com.examples.williamyi.listviewtest;

/**
 * Created by williamyi on 17-4-8.
 *
 */

public class Fruit {

    private String name;

    private int imageId;

    public Fruit(String name, int ImageId) {
        this.name = name;
        this.imageId = ImageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
