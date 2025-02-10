package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("John", 27);
        Player player2 = new Player("Steve", 39);
        Player player3 = new Player("Joe", 20);
        Player player4 = new Player("Mark", 87);
        Player player5 = new Player("Simon", 1);
        Player player6 = new Player("Logan", 100);

        PQList list = new PQList();
        list.add(player1);
        list.add(player2);
        list.add(player3);
        list.add(player4);
        list.add(player5);
        list.add(player6);

        System.out.println(list.getSize());
        System.out.println(list.getHighestScorePlayer().getName());
    }
}