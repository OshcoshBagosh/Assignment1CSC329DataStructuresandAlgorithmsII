package org.example;

import java.util.Objects;

public class Player {
    private int score;
    private String name;

    public Player(){
        this.name = "";
        this.score = 0;
    }

    public Player(String name, int score){
        this.name =  name;
        this.score = score;
    }
    public Player(Player other){
        this.name = other.name;
        this.score = other.score;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

   public Player createClone(){
        Player clone = new Player(this);
        return clone;
   }


}
