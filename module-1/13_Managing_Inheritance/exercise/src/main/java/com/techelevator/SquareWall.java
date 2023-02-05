package com.techelevator;

public class SquareWall extends RectangleWall{



    public SquareWall(String name, String color, int side) {
        super(name, color, side, side);



    }

    public int getSide() {
        return this.getLength();
    }

    @Override
    public String toString(){return String.format("%s (%dx%d) square", this.getName(), this.getSide(), this.getSide());

    };


    }

