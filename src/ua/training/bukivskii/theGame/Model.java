package ua.training.bukivskii.theGame;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Model {
    private int secretNumber;
    private int gameRangeMin;
    private int gameRangeMax;
    private ArrayList<Integer> turnsHistory = new ArrayList<>();


    public Model(){
        gameRangeMin = Constants.DEFAULT_GAME_RANGE_MIN;
        gameRangeMax = Constants.DEFAULT_GAME_RANGE_MAX;
        secretNumber = generateRandomSecretNumber();
    }

    public Model(int rangeMin, int rangeMax){
        gameRangeMin = rangeMin;
        gameRangeMax = rangeMax;
        secretNumber = generateRandomSecretNumber();
    }

    public Model(int rangeMin, int rangeMax, int magickNumber){  //Seems I am the one who make my own life harder ;)
        gameRangeMin = rangeMin;
        gameRangeMax = rangeMax;
        secretNumber = magickNumber;
    }

    public boolean validateValueForRange(int userVal){
        return !(userVal <= gameRangeMin || userVal >= gameRangeMax);
    }

    private void updateRange(int newRangeMin, int newRangeMax){
        gameRangeMin = newRangeMin;
        gameRangeMax = newRangeMax;
    }

    public int processUserNumber(int userVal){
        turnsHistory.add(userVal);
        if(userVal<secretNumber){
            updateRange(userVal,gameRangeMax);
            return -1;
        }else if(userVal>secretNumber){
            updateRange(gameRangeMin,userVal);
            return 1;
        }
        return 0;
    }

    public int getGameRangeMin(){
        return  this.gameRangeMin;
    }
    public int getGameRangeMax(){
        return  this.gameRangeMax;
    }
    public ArrayList getTurnsHistory(){
        return turnsHistory;
    }
    public int generateRandomSecretNumber() {
        return ThreadLocalRandom.current().nextInt(gameRangeMin+1, gameRangeMax);
    }
}
