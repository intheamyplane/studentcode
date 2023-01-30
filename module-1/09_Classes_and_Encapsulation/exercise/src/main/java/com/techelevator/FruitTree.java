package com.techelevator;

public class FruitTree {
    private String typeOfFruit;
    private int piecesOfFruitLeft;

    public String getTypeOfFruit(){
        return this.typeOfFruit;
    }

    public int getPiecesOfFruitLeft(){
        return this.piecesOfFruitLeft;
    }

    public FruitTree(String typeOfFruit, int piecesOfFruitLeft){
        this.typeOfFruit= typeOfFruit;
        this.piecesOfFruitLeft=piecesOfFruitLeft;
    }

    public boolean pickFruit(int numberOfPiecesToRemove) {
        if(numberOfPiecesToRemove<=piecesOfFruitLeft){
            piecesOfFruitLeft-=numberOfPiecesToRemove;
            return true;
        }
        return false;
    }


}
