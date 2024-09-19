import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputData inputData = new InputData();
        List<Car> carList = CarFactory.createCars(inputData.getCarNames());

        Race race = new Race(inputData.getAttempts(), carList);
        race.play();
    }

}
