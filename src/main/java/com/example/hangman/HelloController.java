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

    boolean foundLetter;
    int hits = 0;
    int maxHits = 5;
    @FXML
    private TextField guessBoxInput;
    @FXML
    private Text testOutTxt;
    @FXML
    private Text instructionText1;
    @FXML
    private Text hitBox2;
    @FXML
    private Text hitsBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instructionText1.setText(" Begin - Enter your letter");

        guessBoxInput.setPrefWidth(30);
        guessBoxInput.setMaxWidth(80);
        guessBoxInput.clear();
        hitsBox.setText(String.valueOf(0));
        hitBox2.setText(String.valueOf(maxHits));
    }

    @FXML
    void grabAnswer() {

        hitBox2.setText(String.valueOf(maxHits));
        ArrayList<Character> guessesList = new ArrayList<>();

        String wordToGuess = "CAT";

        //get a single char from the user
        System.out.println(" input box size before = " + guessBoxInput.getLength());
        char guessFromUser = guessBoxInput.getCharacters().charAt(0);
        System.out.println(" input box size = " + guessBoxInput.getLength());
        //convert the word to guess to an array of chars
        char[] astrikGuess = wordToGuess.toCharArray();

        //add a char to get a count (possible remove)
        guessesList.add('.');

        testOutTxt.setText(String.valueOf(guessFromUser));

        while (hits <= maxHits) {
            instructionText1.setText("Enter a letter");
            guessFromUser = guessBoxInput.getCharacters().charAt(0);
            guessFromUser = Character.toUpperCase(guessFromUser);
            String toDisplayGuessChar = String.valueOf(guessFromUser);
            testOutTxt.setText("You chose " + toDisplayGuessChar);

            //Check for a correct letter
            for (int i = 0; i < astrikGuess.length; i++) {

                if (guessFromUser == astrikGuess[i]) {
                    foundLetter = true;
                }
            }
            if (foundLetter) {
                testOutTxt.setText("Hit!");
            }else
            {
                testOutTxt.setText("Not found");
            }

            guessBoxInput.clear();
            System.out.println(" input box size after clear = " + guessBoxInput.getLength());
            guessesList.add(guessFromUser);

            hits++;
            hitsBox.setText(String.valueOf(hits));

        }

        instructionText1.setText("done");
    }

    @FXML
    void quitApp() {
        Platform.exit();
    }
}

















