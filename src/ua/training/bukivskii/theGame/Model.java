package ua.training.bukivskii.theGame;

import java.util.concurrent.ThreadLocalRandom;

public class Model {
    private int secretNumber;
    private int gameRangeMin;
    private int gameRangeMax;
    private View view; // I`m definately the one who makes my life harder!
    private int turnsMade = 0;
    private int[] turnsHistory;


    public Model(View view){
        secretNumber = ThreadLocalRandom.current().nextInt(Controller.DEFAULT_GAME_RANGE_MIN, Controller.DEFAULT_GAME_RANGE_MAX + 1);
        gameRangeMin = Controller.DEFAULT_GAME_RANGE_MIN;
        gameRangeMax = Controller.DEFAULT_GAME_RANGE_MAX;
        this.view = view;
        turnsHistory = new int[gameRangeMax-gameRangeMin];
    }

    public Model(View view, int rangeMin, int rangeMax){
        secretNumber = ThreadLocalRandom.current().nextInt(rangeMin, rangeMax + 1);
        gameRangeMin = rangeMin;
        gameRangeMax = rangeMax;
        this.view = view;
        turnsHistory = new int[gameRangeMax-gameRangeMin];
    }

    public Model(View view, int rangeMin, int rangeMax, int magickNumber){  //Seems I am the one who make my own life harder ;)
        secretNumber = magickNumber;
        gameRangeMin = rangeMin;
        gameRangeMax = rangeMax;
        this.view = view;
        turnsHistory = new int[gameRangeMax-gameRangeMin];
    }

    public boolean validateValueForRange(int userVal){
        if(userVal <= gameRangeMin || userVal >= gameRangeMax) {
            return false;
        }
        return true;
    }

    private void updateRange(int newRangeMin, int newRangeMax){
        gameRangeMin = newRangeMin;
        gameRangeMax = newRangeMax;
    }

    public boolean processUserNumber(int userVal){
        turnsHistory[turnsMade]=userVal;
        view.printLastTurn(turnsHistory[turnsMade]);
        turnsMade++;
        if(userVal<secretNumber){
            updateRange(userVal,gameRangeMax);
            view.printMessage(View.BIGGER_MESSAGE);
            return false;
        }else if(userVal>secretNumber){
            updateRange(gameRangeMin,userVal);
            view.printMessage(view.SMALLLER_MESSAGE);
            return false;
        }
        return true;
    }

    public void printCurrentRange(){
        view.printCurrentRange(gameRangeMin,gameRangeMax);
    }

    public void printWrongRange(){
        view.printMessage(View.WRONG_RANGE_MESSAGE);
        view.printCurrentRange(gameRangeMin,gameRangeMax);
    }

    public void gameWon(){
        view.printGameWon(turnsMade, turnsHistory);
    }
}
