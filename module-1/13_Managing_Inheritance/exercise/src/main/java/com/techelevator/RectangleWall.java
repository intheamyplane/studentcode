package com.techelevator;

public class RectangleWall extends Wall{
    private int length;
    private int height;

    public RectangleWall(String name, String color, int length, int height) {
        super(name, color);
        this.length=length;
        this.height=height;
    }
    public RectangleWall(String name, String color) {
        super(name, color);


    }



    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    @Override
    public int getArea() {
      return  this.length*this.height;


    }
    @Override
    public String toString() {return String.format("%s (%dx%d) rectangle", this.getName(), this.length, this.height);}
}
