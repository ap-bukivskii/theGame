package ua.training.bukivskii.theGame;

import java.util.Scanner;

public class Controller {

    public static final int DEFAULT_GAME_RANGE_MIN = 0;
    public static final int DEFAULT_GAME_RANGE_MAX = 100;

    private Model model;
    private View view;
    private boolean gameIsWon = false;
    private int userValue;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame(){
        Scanner scan = new Scanner(System.in);
        view.printMessage(view.HELP_MESSAGE);
        while (!gameIsWon){
            model.printCurrentRange();
            view.printMessage(view.ASK_FOR_INPUT_MESSAGE);
            userValue = inputAndVerify(scan);
            gameIsWon = model.processUserNumber(userValue);
        }
        model.gameWon();
    }

    public int inputAndVerify(Scanner scan) {

        boolean dataIsValidated = false; // TODO do...while
        int bufferData=0;
        while(!dataIsValidated) {
            bufferData = inputInt(scan);
            dataIsValidated = isCorrectRange(bufferData);
            if(!dataIsValidated){
                model.printWrongRange();
                view.printMessage(View.ASK_FOR_INPUT_MESSAGE);
            }
        }
        return bufferData;
    }

    private int inputInt(Scanner scan){
        while (!scan.hasNextInt()) { //TODO fix input like "some words 1"
            view.printMessage(view.WRONG_TYPE_MESSAGE);
            view.printMessage(View.ASK_FOR_INPUT_MESSAGE);
            scan.next();
        }
        return scan.nextInt();
    }

    private boolean isCorrectRange(int userVal){
        return model.validateValueForRange(userVal);
    }
}
