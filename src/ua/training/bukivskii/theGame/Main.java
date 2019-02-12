package ua.training.bukivskii.theGame;

public class Main {

    public static void main(String[] args) {
        View view = new View();
        Model model = new Model(); //TODO check args for user specified game range
        Controller controller = new Controller(model, view);
        controller.startGame();
    }
}
