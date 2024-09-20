import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)          // 각 문자열을 Car 객체로 변환
                .collect(Collectors.toList());  // 변환된 Car 객체들을 List로 수집
    }
}

