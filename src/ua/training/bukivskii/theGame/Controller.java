package ua.training.bukivskii.theGame;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;
    private int userValue,gameState;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame(){
        Scanner scan = new Scanner(System.in);
        view.printMessage(Strings.HELP_MESSAGE);
        do{
            view.askForInput(model.getGameRangeMin(),model.getGameRangeMax());
            userValue = inputValidatedValue(scan);
            view.printLastTurn(userValue);
            gameState = model.processUserNumber(userValue);
            if(gameState>0){
                view.printMessage(Strings.SMALLLER_MESSAGE);
            }
            if(gameState<0){
                view.printMessage(Strings.BIGGER_MESSAGE);
            }
        }
        while (gameState!=0);
        view.printGameWon(model.getTurnsHistory());
    }

    private int inputValidatedValue(Scanner scan) {
        int bufferData;
        while(true) { //TODO while true :(
            bufferData = inputInt(scan);
            if(model.validateValueForRange(bufferData)){
                return bufferData;
            }
            view.printMessage(Strings.WRONG_RANGE_MESSAGE);
            view.askForInput(model.getGameRangeMin(),model.getGameRangeMax());
        }
    }

    private int inputInt(Scanner scan){ //checks input data for int type
        while (!scan.hasNextInt()) { //TODO fix input like "some words 1"
            view.printMessage(Strings.WRONG_TYPE_MESSAGE);
            view.askForInput(model.getGameRangeMin(),model.getGameRangeMax());
            scan.next();
        }
        return scan.nextInt();
    }
}
