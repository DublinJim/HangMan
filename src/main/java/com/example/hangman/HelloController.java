package com.example.hangman;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.Initializable;

public class HelloController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int hits = 0;
        char guessFromUser;
        ArrayList<Character> guesses = new ArrayList<Character>();

        Scanner scanner = new Scanner(System.in);

        //input the char

        //convert the string to a char array
        String wordToGuess = "CAT";
        char[] astrikGuess = wordToGuess.toCharArray();


        while (hits <= 3) {
            System.out.println("Enter a letter :");
            guessFromUser = scanner.next(".").charAt(0);
            guessFromUser = Character.toUpperCase(guessFromUser);
            System.out.println("you chose " + guessFromUser);
            guesses.add(guessFromUser);


            for (int i = 0; i < astrikGuess.length; i++) {
                System.out.println(astrikGuess[i]);
                //cycle through the array for a match
                if (guessFromUser == astrikGuess[i]) {
                    System.out.println("Hit");
                    hits++;
                } else {
                    System.out.println("Miss");
                }
            }
        }

        System.out.println("game over");
        System.out.println("Hits =" + hits);

    }
}
