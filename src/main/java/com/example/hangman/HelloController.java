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
        instructionText1.setText(" Begin - Enter your letter");
    }

    @FXML
    void grabAnswer() {
        int hits = 0;

        ArrayList<Character> guessesList = new ArrayList<>();
        String wordToGuess = "CAT";
        char guessFromUser = guessBoxInput.getCharacters().charAt(0);
        char[] astrikGuess = wordToGuess.toCharArray();
        guessesList.add('.');

        testOutTxt.setText(String.valueOf(guessFromUser));

        while (hits <= 5) {
            instructionText1.setText("Enter a letter");

            guessFromUser = guessBoxInput.getCharacters().charAt(0);
            guessFromUser = Character.toUpperCase(guessFromUser);
            String toDisplayGuessChar = String.valueOf(guessFromUser);
            instructionText1.setText("You chose " + toDisplayGuessChar);

            for (int i = 0; i <guessesList.size() ; i++) {

            }
            hits++;


        }


    }

    @FXML
    void quitApp() {
        Platform.exit();
    }
}

















