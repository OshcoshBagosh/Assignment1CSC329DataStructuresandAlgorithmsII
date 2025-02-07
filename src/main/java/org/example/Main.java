package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("John", 27);
        Player player2 = new Player(player1);

        System.out.println(player1.getName());
        System.out.println(player2.getName());
        System.out.println(player1.equals(player2));
    }
}