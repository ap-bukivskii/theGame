package ua.training.bukivskii.theGame;

import java.util.ArrayList;

public class View {

    public void printGameWon(ArrayList history){
        printMessage(Strings.YOU_WON_MESSAGE);
        printMessage("You have beat the game in " + history.size() + " turns.\nYour guesses were: " + history.toString());
    }

    public void askForInput(int rangeMin, int rangeMax){
        printMessage(Strings.ASK_FOR_INPUT_MESSAGE + (rangeMin+1) + " to " + (rangeMax-1) + ":\n");
    }

    public void printLastTurn(int lastTurn){
        printMessage(Strings.LAST_TURN_MESSAGE+lastTurn+"\n");
    }

    public void printMessage(String message) {
        System.out.print(message);
    }
}
