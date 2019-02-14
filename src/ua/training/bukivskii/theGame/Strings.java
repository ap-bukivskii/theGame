package ua.training.bukivskii.theGame;

public interface Strings {
    String HELP_MESSAGE = "Hi there!\nYou are about to play the best game ever! ;)\nThere is a secret number that you have to guess.\nGood Luck!\n";
    String WRONG_TYPE_MESSAGE = "Wrong input!\nPlease enter only numbers!\n";
    String WRONG_RANGE_MESSAGE = "Value you entered is out of the game range!\n";
    String ASK_FOR_INPUT_MESSAGE = "Please input a number from ";
    String LAST_TURN_MESSAGE = "Number that you entered was: ";
    String BIGGER_MESSAGE = "The secret number is bigger than your guess!\n";
    String SMALLLER_MESSAGE = "The secret number is smaller than your guess!\n";
    String YOU_WON_MESSAGE = "You are the WINNER!\n";
    String OPTIONS_ERROR_MESSAGE = "Could not parse command line options.\nStartind the game with default range.\n";
}
