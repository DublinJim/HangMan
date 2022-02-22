package com.example.hangman;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.Initializable;

public class HelloController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int hits = 0;
        char GuessFromUser;

        Scanner scanner = new Scanner(System.in);

        //input the char

        //convert the string to a char array
        String wordToGuess = "CAT";
        char[] astrikGuess = wordToGuess.toCharArray();


        while (hits <= 3) {
            System.out.println("Enter a letter :");
            GuessFromUser = scanner.next(".").charAt(0);
            GuessFromUser = Character.toUpperCase(GuessFromUser);
            System.out.println("you chose " + GuessFromUser);

            for (int i = 0; i < astrikGuess.length; i++) {
                System.out.println(astrikGuess[i]);
                //cycle through the array for a match
                if (GuessFromUser == astrikGuess[i]) {
                    System.out.println("Hit");
                    hits++;
                } else {
                    System.out.println("Miss");
                }
            }
        }

        System.out.println("game over");
        System.out.println("Hits ="+hits);

    }
}
