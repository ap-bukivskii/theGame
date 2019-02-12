package ua.training.bukivskii.theGame;

public class View {
    public static final String HELP_MESSAGE = "Hi there!\nYou are about to play the best game ever! ;)\nThere is a secret number that you have to guess.\nGood Luck!\n";
    public static final String WRONG_TYPE_MESSAGE = "Wrong input!\nPlease enter only numbers!\n";
    public static final String WRONG_RANGE_MESSAGE = "Value you entered is out of the game range!\n";
    public static final String ASK_FOR_INPUT_MESSAGE = "Please input a number:\n";
    public static final String LAST_TURN_MESSAGE = "Number that you entered was: ";
    public static final String BIGGER_MESSAGE = "The secret number is bigger than your guess!\n";
    public static final String SMALLLER_MESSAGE = "The secret number is smaller than your guess!\n";
    public static final String YOU_WON_MESSAGE = "You are the WINNER!\n";

    public void printCurrentRange(int rangeMin, int rangeMax){
        printMessage("Current game range is: "+rangeMin+" - "+rangeMax+".\n");
    }

    public void printGameWon(int turnsMade, int [] turnsHistory){
        printMessage(YOU_WON_MESSAGE);
        printMessage("You have beat the game in " + turnsMade + " turns.\nYour guesses were: ");
        for (int i = 0; i<turnsMade; i++){
            printMessage(turnsHistory[i]+", ");
        }
    }

    public void printLastTurn(int lastTurn){
        printMessage(LAST_TURN_MESSAGE+lastTurn+"\n");
    }

    public void printMessage(String message) {
        System.out.print(message);
    }
}
