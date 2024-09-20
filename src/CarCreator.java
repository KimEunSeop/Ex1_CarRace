import java.util.ArrayList;
import java.util.List;

public class CarManager{

    private List<Car> carList = new ArrayList<>();
    public CarManager(List<String> carNames) {
        createCars(carNames);
    }
    private void createCars(List<String> carNames) {
        carNames.stream()
                .map(Car::new)          // 각 문자열을 Car 객체로 변환
                .forEach(carList::add);  // carList에 각 Car 객체를 추가
    }

    public List<Car> getCarList() {
        return carList;
    }
}
