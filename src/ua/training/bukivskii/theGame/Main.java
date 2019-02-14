package ua.training.bukivskii.theGame;

import org.apache.commons.cli.*;

public class Main {

    public static void main(String[] args) {
        int rangeMax = Constants.DEFAULT_GAME_RANGE_MAX;
        int rangeMin = Constants.DEFAULT_GAME_RANGE_MIN;

        View view = new View();
        Model model;

        Option minRange = new Option("s","start", true, "Range low bound");
        minRange.setArgs(1);
        minRange.setOptionalArg(false);
        minRange.setArgName("Range low bound");

        Option maxRange = new Option("e","end", true, "Range high bound");
        minRange.setArgs(1);
        minRange.setOptionalArg(false);
        minRange.setArgName("Range high bound");

        Options posixOptions = new Options();
        posixOptions.addOption(minRange);
        posixOptions.addOption(maxRange);

        CommandLineParser cmdLinePosixParser = new DefaultParser();
        try {
            CommandLine commandLine = cmdLinePosixParser.parse(posixOptions, args);
            if(commandLine.hasOption('s')){
                rangeMin = Integer.parseInt(commandLine.getOptionValue('s'));
            }
            if(commandLine.hasOption('e')){
                rangeMax = Integer.parseInt(commandLine.getOptionValue('e'));
            }
        }catch (org.apache.commons.cli.ParseException commandLineParseException){
            view.printMessage(Strings.OPTIONS_ERROR_MESSAGE);
            }
        //TODO create --help
        model = new Model(rangeMin,rangeMax);
        Controller controller = new Controller(model, view);
        controller.startGame();
    }
}
