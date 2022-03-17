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

    int hits = 1;
     static int maxHits = 5;
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
    private Text instructionTxt4;

    @FXML
    private Text instructionTxt5;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instructionTxt1.setText(" Begin - Enter your letter");
        guessBoxInput.requestFocus();
        guessBoxInput.setPrefWidth(30);
        guessBoxInput.clear();
        guessBoxInput.setVisible(false);
        hitsBox.setText(String.valueOf(1));
        hitBox2.setText(String.valueOf(maxHits));


    }


    @FXML
    void startTheGame() {
        wordToGuess = "CAT";


        guessBoxInput.requestFocus();
        hits = 1;
        hitsBox.setText(String.valueOf(hits));

        instructionTxt1.setText("Enter a letter");
        chars = wordToGuess.toCharArray();
        guessBoxInput.setVisible(true);
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

        //convert the word to guess to an array of chars
        astrikGuess = wordToGuess.toCharArray();

        while (hits < maxHits) {
            /* ----------------------------------------------------------------------*/
            instructionTxt1.setText("Enter a letter");

            guessFromUser = Character.toUpperCase(guessBoxInput.getCharacters().charAt(0));
            instructionTxt2.setText("You chose " + guessFromUser);
            instructionTxt3.setText("");

            for (int i = 0; i < guessesList.size(); i++)
                if (guessFromUser == guessesList.get(i)) {

                    instructionTxt5.setText("Already used .  try again");
                    guessBoxInput.clear();
                    guessFromUser = Character.toUpperCase(guessBoxInput.getCharacters().charAt(0));
                }

            for (int i = 0; i < astrikGuess.length; i++) {
                if (guessFromUser == astrikGuess[i]) {
                    foundLetter = true;
                }
            }

            if (foundLetter) {
                instructionTxt5.setText("Hit!");
                instructionTxt3.setText("Well done");
                //reset the flag
                foundLetter = false;
            } else {
                instructionTxt5.setText("Not found");
                instructionTxt3.setText("Try again");
            }

            guessBoxInput.clear();
            guessesList.add(guessFromUser);
            guessBoxInput.clear();
            hits++;
            hitsBox.setText(String.valueOf(hits));
        }





    /* ___________________________________________________________*/
        instructionTxt1.setText("GAME OVER");
        guessBoxInput.setVisible(false);
    }



    @FXML
    void quitApp() {
        Platform.exit();
    }
}

















