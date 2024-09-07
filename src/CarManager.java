import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> carList = new ArrayList<>();

    public void createCars(List<String> carNames) {
        for (String name : carNames) {
            Car car = new Car(name);
            carList.add(car);
        }
    }

    public List<Car> getCars() {
        return carList;
    }
}
