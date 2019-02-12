package ua.training.bukivskii.theGameTest;

import org.junit.*;
import ua.training.bukivskii.theGame.Model;

import static org.junit.Assert.*;

public class ModelTest {
    private static Model testModel;

    @BeforeClass
    public static void setUp(){
        testModel = new Model();
    }

    @Test
    public void validateValueForRange() {
    }

    @Test
    @Ignore
    public void validateRandomRangeLow() {
        boolean testPassed = false;
        for(int i = 0; i < 20000 * (testModel.getGameRangeMax()-testModel.getGameRangeMin()); i++) {
            if(testModel.generateRandomSecretNumber() == testModel.getGameRangeMin()+1){
                testPassed = true;
                break;
            }
        }
        Assert.assertTrue(testPassed);
    }

    @Test
    @Ignore
    public void validateRandomRangeOutOfRange() {
        boolean testPassed = true;
        int generatedNum;
        for(int i = 0; i < 20000 * (testModel.getGameRangeMax()-testModel.getGameRangeMin()); i++) {
            generatedNum = testModel.generateRandomSecretNumber();
            if( generatedNum < testModel.getGameRangeMin()+1 || generatedNum > testModel.getGameRangeMax()-1){
                testPassed = false;
                break;
            }
        }
        Assert.assertTrue(testPassed);
    }

    @Test
    @Ignore
    public void validateRandomRangeHi() {
        boolean testPassed = false;
        for(int i = 0; i < 20000 * (testModel.getGameRangeMax()-testModel.getGameRangeMin()); i++) {
            if(testModel.generateRandomSecretNumber() == testModel.getGameRangeMax()-1){
                testPassed = true;
                break;
            }
        }
        Assert.assertTrue(testPassed);
    }

    @Test
    public void processUserNumber() {
    }

    @Test
    public void getGameRangeMin() {
    }

    @Test
    public void getGameRangeMax() {
    }

    @Test
    public void getTurnsMade() {
    }

    @Test
    public void getTurnsHistory() {
    }
}