package com.example.hangman;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController implements Initializable {

    boolean foundLetter;
    int hits = 1;
    int maxHits = 5;
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

    @FXML
    private Button playBtn;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instructionTxt1.setText(" Begin - Enter your letter");

        guessBoxInput.setPrefWidth(30);
        guessBoxInput.clear();
        hitsBox.setText(String.valueOf(1));
        hitBox2.setText(String.valueOf(maxHits));

    }

    @FXML
    void grabAnswer() {

        String wordToGuess = "CAT";
        char[] chars = wordToGuess.toCharArray();
        //hide the word to be guessed
        for (int i = 0; i < wordToGuess.length(); i++) {

            chars[i] = 'X';

        }

        String maskedWord = String.valueOf(chars);

        guessWord.setText(maskedWord);
        hitBox2.setText(String.valueOf(maxHits));
        ArrayList<Character> guessesList = new ArrayList<>();

        //get a single char from the user
        System.out.println(" input box size before = " + guessBoxInput.getLength());
        char guessFromUser = guessBoxInput.getCharacters().charAt(0);
        System.out.println(" input box size = " + guessBoxInput.getLength());
        //convert the word to guess to an array of chars
        char[] astrikGuess = wordToGuess.toCharArray();

        testOutTxt.setText(String.valueOf(guessFromUser));

        while (hits < maxHits) {
            instructionTxt1.setText("Enter a letter");

            guessFromUser = Character.toUpperCase(guessBoxInput.getCharacters().charAt(0));
            instructionTxt2.setText("You chose " + guessFromUser);

            // TODO: 3/7/2022 check the letter was not previously used

            //Check for a correct letter
            for (int i = 0; i < astrikGuess.length; i++) {

                if (guessFromUser == astrikGuess[i]) {
                    foundLetter = true;
                    break;
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
            }

            guessesList.add(guessFromUser);

            guessBoxInput.clear();
            System.out.println(" input box size after clear = " + guessBoxInput.getLength());
            hits++;
            hitsBox.setText(String.valueOf(hits));

        }
        instructionTxt1.setText("GAME OVER");
    }


    @FXML
    void quitApp() {
        Platform.exit();
    }
}

















