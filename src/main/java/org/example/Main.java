package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PQList list = new PQList();
        try {
            FileReader fr = new FileReader("players.txt");
            Scanner infile = new Scanner(fr);
            String line;
            String line2;
            int score;


            while (infile.hasNextLine()) {
                line = infile.nextLine();
                line2 = infile.nextLine();
                score = Integer.parseInt(line2);
                Player player = new Player(line, score);
                list.add(player);
            }

            infile.close();

            PQList list1 = list.createClone(); //Creates a PQList clone
            System.out.println("Size: " + list.getSize());
            System.out.println("Is Empty: " + list.isEmpty());

            while (list.isEmpty() == false){ //Prints Highest scored players to least
                Player player = list.getHighestScorePlayer();
                System.out.println("List1: " + player.getName() + ": " + player.getScore());
                System.out.println("Size: " + list.getSize());
            }
            System.out.println("List Is Empty: " + list.isEmpty());
            System.out.println("List1 Is Empty: " + list1.isEmpty());
            Player player1 = list1.getHighestScorePlayer();
            System.out.println("List1: " + player1.getName() + ": " + player1.getScore());
            list1.clear();
            System.out.println("List1 Is Empty: " + list1.isEmpty());



        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}