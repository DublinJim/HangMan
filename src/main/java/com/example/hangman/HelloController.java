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

    //regular variables
    boolean foundLetter;
    boolean gameOver;
    int hits = 1;
    int maxHits = 5;
    String wordToGuess;
    String maskedWord;
    char guessFromUser;
    char[] chars;
    char[] astrikGuess;
    ArrayList<Character> guessesList = new ArrayList<>();

    @FXML
    private TextField guessBoxInput;

    @FXML
    private Text guessWord;

    @FXML
    private Text hitBox2;

    @FXML
    private Text hitsBox;

    @FXML
    private Text instructionTxt1;

    @FXML
    private Text instructionTxt2;

    @FXML
    private Text instructionTxt3;

    @FXML
    private Text testOutTxt;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instructionTxt1.setText(" Begin - Enter your letter");
        guessBoxInput.requestFocus();
        guessBoxInput.setPrefWidth(30);
        guessBoxInput.clear();
        hitsBox.setText(String.valueOf(1));
        hitBox2.setText(String.valueOf(maxHits));
        guessBoxInput.setVisible(false);


    }


    @FXML
    void startTheGame() {
        wordToGuess = "CAT";
        guessBoxInput.setVisible(true);
        guessBoxInput.requestFocus();
        hits = 1;
        hitsBox.setText(String.valueOf(hits));
        instructionTxt1.setText("Enter a letter");

        chars = wordToGuess.toCharArray();
        //hide the word to be guessed
        for (int i = 0; i < wordToGuess.length(); i++) {
            chars[i] = 'X';
        }
        maskedWord = String.valueOf(chars);
        guessWord.setText(maskedWord);

    }

    @FXML
    void mainGame() {

        hitBox2.setText(String.valueOf(maxHits));

        //get a single char from the user

        guessFromUser = guessBoxInput.getCharacters().charAt(0);

        //convert the word to guess to an array of chars
        astrikGuess = wordToGuess.toCharArray();
        testOutTxt.setText(String.valueOf(guessFromUser));

        while (hits < maxHits) {
            instructionTxt1.setText("Enter a letter");

            guessFromUser = Character.toUpperCase(guessBoxInput.getCharacters().charAt(0));
            instructionTxt2.setText("You chose " + guessFromUser);

            // TODO: 3/7/2022 check the letter was not previously used

            for (int i = 0; i < guessesList.size(); i++) {
                if (guessFromUser == guessesList.get(i)) {

                    testOutTxt.setText("Already used .  try again");
                    guessFromUser = Character.toUpperCase(guessBoxInput.getCharacters().charAt(0));
                    instructionTxt2.setText("You chose " + guessFromUser);
                }
            }

            //Check for a correct letter

            for (int i = 0; i < astrikGuess.length; i++) {

                if (guessFromUser == astrikGuess[i]) {
                    foundLetter = true;

                }
            }
            if (foundLetter) {
                testOutTxt.setText("Hit!");
                instructionTxt3.setText("Well done");
                //reset the flag
                foundLetter = false;
            } else {
                testOutTxt.setText("Not found");
                instructionTxt3.setText("Try again");
                guessBoxInput.clear();
            }

            guessesList.add(guessFromUser);
            guessBoxInput.clear();
            hits++;
            hitsBox.setText(String.valueOf(hits));

        }
        instructionTxt1.setText("GAME OVER");
        guessBoxInput.setVisible(false);

    }


    @FXML
    void quitApp() {
        Platform.exit();
    }
}

















