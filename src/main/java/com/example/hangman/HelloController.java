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

    static int maxHits = 5;
    int hits = 1;
    String wordToGuess;
    String maskedWord;
    char guessFromUser;
    char[] chars;
    char[] astrikGuess;
    int score;
    int maxScore;
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
    private Text instructionTxt4;

    @FXML
    private Text instructionTxt5;

    @FXML
    private Text bannerText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        guessBoxInput.requestFocus();
        guessBoxInput.clear();
        hitsBox.setText(String.valueOf(1));
        hitBox2.setText(String.valueOf(maxHits));

        bannerText.setText("Press 'Play' to begin.");

        guessWord.setVisible(false);
        guessBoxInput.setVisible(false);

        turnOffTexts();
    }

    private void turnOffTexts() {
        instructionTxt1.setVisible(false);
        instructionTxt2.setVisible(false);
        instructionTxt3.setVisible(false);
        instructionTxt4.setVisible(false);
        instructionTxt5.setVisible(false);
    }


    @FXML
    void startTheGame() {
        // TODO: 4/4/2022 get a better array of words 
        wordToGuess = "CAT";
        guessesList.clear();
        guessWord.setVisible(true);
        instructionTxt1.setVisible(true);
        instructionTxt1.setText(" Begin - Please enter your letter");
        bannerText.setText("The word to guess:");
        guessBoxInput.requestFocus();
        hits = 1;
        hitsBox.setText(String.valueOf(hits));

        chars = wordToGuess.toCharArray();
        guessBoxInput.setVisible(true);
        //hide the word to be guessed
        maxScore = wordToGuess.length();
        for (int i = 0; i < wordToGuess.length(); i++) {
            chars[i] = 'X';
        }
        maskedWord = String.valueOf(chars);
        guessWord.setText(maskedWord);

    }

    @FXML
    void mainGame() {

        hitBox2.setText(String.valueOf(maxHits));
        instructionTxt1.setText("Enter a letter");
        //convert the word to guess to an array of chars
        astrikGuess = wordToGuess.toCharArray();

        while (hits < maxHits) {
            /* ----------------------------------------------------------------------*/
            instructionTxt1.setText("Enter a letter");

            guessFromUser = Character.toUpperCase(guessBoxInput.getCharacters().charAt(0));

            guessFromUser = checkCharFromUser(guessFromUser);

            for (Character character : guessesList) {
                if (guessFromUser == character) {
                    instructionTxt5.setText("Already used .  try again");
                    guessBoxInput.clear();
                    guessFromUser = Character.toUpperCase(guessBoxInput.getCharacters().charAt(0));
                }
            }

            for (int i = 0; i < astrikGuess.length; i++) {
                if (guessFromUser == astrikGuess[i]) {
                    chars[i] = astrikGuess[i];
                    maskedWord = String.valueOf(chars);
                    guessWord.setText(maskedWord);
                    instructionTxt3.setVisible(true);
                    instructionTxt3.setText("Well done");
                    instructionTxt5.setVisible(true);
                    instructionTxt5.setText("You guessed correctly");
                    score++;
                    if (score == maxScore) {
                        bannerText.setText("YOU WIN");
                        turnOffTexts();
                    }
                    break;
                } else {
                    instructionTxt3.setVisible(true);
                    instructionTxt5.setVisible(true);
                    instructionTxt5.setText("Not found");
                    instructionTxt3.setText("Try again");
                }
            }
            guessBoxInput.clear();
            guessesList.add(guessFromUser);
            guessBoxInput.clear();
            hits++;
            hitsBox.setText(String.valueOf(hits));
        }

        /* ___________________________________________________________*/
        turnOffTexts();
        instructionTxt1.setVisible(true);
        instructionTxt1.setText("GAME OVER");
        guessBoxInput.setVisible(false);

    }

    private char checkCharFromUser(char guessFromUser) {
        if ((guessFromUser >= 'A' && guessFromUser <= 'Z')) {
            instructionTxt2.setVisible(true);
            instructionTxt2.setText("You chose " + guessFromUser);
            instructionTxt3.setText("");
        } else {
            instructionTxt3.setVisible(true);
            instructionTxt3.setText(guessFromUser + " is not a letter. try again");
            guessBoxInput.clear();
            guessFromUser = Character.toUpperCase(guessBoxInput.getCharacters().charAt(0));
            checkCharFromUser(guessFromUser);

        }
        return guessFromUser;
    }


    @FXML
    void quitApp() {
        Platform.exit();
    }
}

















