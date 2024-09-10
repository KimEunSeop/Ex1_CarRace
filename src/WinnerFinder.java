import java.util.List;
import java.util.stream.Collectors;

public class WinnerFinder {

    public int getMaxDistance(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getState)
                .max()
                .orElse(0);  // 최대값이 없으면 0 반환
    }

    public List<String> findWinners(List<Car> carList) {
        int maxDistance = getMaxDistance(carList);  // 최대 거리 함수 호출
        return carList.stream()
                .filter(car -> car.getState() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}
