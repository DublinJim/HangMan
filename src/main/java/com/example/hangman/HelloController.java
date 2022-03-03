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
        ArrayList<Character> guessesList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //convert the string to a char array
        String wordToGuess = "CAT";
        char[] astrikGuess = wordToGuess.toCharArray();
        guessesList.add('.');
//main loop
        while (hits <= 20) {
            System.out.println("Enter a letter :");

            guessFromUser = scanner.next(".").charAt(0);
            guessFromUser = Character.toUpperCase(guessFromUser);
            System.out.println("you chose " + guessFromUser);

            //check if previously used

            for (int i = 0; i < guessesList.size(); i++) {
                while (guessFromUser == guessesList.get(i)) {
                    System.out.println("You already used " + guessFromUser + ", try again");
                    System.out.println("Enter a letter :");
                    guessFromUser = scanner.next(".").charAt(0);
                    guessFromUser = Character.toUpperCase(guessFromUser);
                    System.out.println("you chose " + guessFromUser);
                }

            }

            for (char guess : astrikGuess) {
                System.out.println(guess);
                //cycle through the array for a match
                if (guessFromUser == guess) {
                    System.out.println("Hit");

                } else {
                    System.out.println("Miss");
                }

            }
            hits++;
            //add the char to the used list
            guessesList.add(guessFromUser);
            System.out.println("You have used " + hits+" of 20");
        }

        System.out.println("done");

    }


}


















