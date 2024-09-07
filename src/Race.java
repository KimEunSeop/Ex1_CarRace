import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    private int rounds;
    private CarManager carManager;

    public Race(int rounds, CarManager carManager) {
        this.rounds = rounds;
        this.carManager = carManager;
    }

    public void playRound() {
        System.out.println("실행 결과");
        Random random = new Random();
        List<Car> cars = carManager.getCars();

        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                int var = random.nextInt(10);
                if (var >= 4) {
                    car.go();
                }
                System.out.print(car.getName() + " : ");
                for (int j = 0; j < car.getState(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        List<String> winners = findWinners();
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }

    private List<String> findWinners() {
        int maxDistance = 0;
        List<String> winners = new ArrayList<>();
        List<Car> cars = carManager.getCars();

        for (Car car : cars) {
            int distance = car.getState();
            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(car.getName());
            } else if (distance == maxDistance) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
