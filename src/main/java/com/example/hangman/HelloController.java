package com.example.hangman;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController implements Initializable {

    @FXML
    private TextField guessBoxInput;

    @FXML
    private Text testOutTxt;
    @FXML
    private Text instructionText1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void grabAnswer() {
        int hits = 0;

        ArrayList<Character> guessesList = new ArrayList<>();
        String wordToGuess = "CAT";
        char guessFromUser;
        char[] astrikGuess = wordToGuess.toCharArray();
        guessesList.add('.');

        while (hits <= 3) {
            instructionText1.setText("Enter a letter :");

            guessFromUser = guessBoxInput.getCharacters().charAt(0);
            guessFromUser = Character.toUpperCase(guessFromUser);
            instructionText1.setText("you chose " + guessFromUser);

            //check if previously used

            for (int i = 0; i < guessesList.size(); i++) {
                while (guessFromUser == guessesList.get(i)) {
                    testOutTxt.setText("You already used " + guessFromUser + ", try again");

                    instructionText1.setText("Enter a letter :");
                    guessFromUser = guessBoxInput.getCharacters().charAt(0);
                    guessFromUser = Character.toUpperCase(guessFromUser);
                    testOutTxt.setText("you chose " + guessFromUser);
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
            System.out.println("You have used " + hits + " of 20");
        }

    }

    @FXML
    void quitApp() {
        Platform.exit();
    }
}

















