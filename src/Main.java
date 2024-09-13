
public class Main {
    public static void main(String[] args) {
        InputData inputData = new InputData();
        CarManager carManager = new CarManager(inputData.getCarNames());

        Race race = new Race(inputData.getAttempts(), carManager.getCarList());
        race.play();
    }

}
