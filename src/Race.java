import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Race {
    private int rounds;
    private List<Car> carList = new ArrayList<>();

    public Race(int rounds, List<Car> carList) {
        this.rounds = rounds;
        this.carList = carList;
    }

    public void play(){
        System.out.println("실행 결과");
        IntStream.range(0, rounds)  // 0부터 rounds-1까지의 스트림 생성
                .forEach(i -> runRound());  // 각 반복마다 runRound() 실행
        findWinners();
    }

    private void runRound() {
        carList.forEach(car -> {
            if(checkToGo()) car.go();
            drawRace(car);
        });
        System.out.println();
    }

    private boolean checkToGo(){
        Random random = new Random();
        int var = random.nextInt(10);
        if (var >= 4) {
            return true;
        }
        return false;
    }

    private void drawRace(Car car) {
        System.out.print(car.getName() + " : ");
        IntStream.range(0, car.getState())
                .forEach(i -> System.out.print("-"));

        System.out.println();
    }

    private void findWinners() {
        int maxDistance = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : carList) {
            int distance = car.getState();
            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(car.getName());
                continue;
            }
            if (distance == maxDistance) {
                winners.add(car.getName());
            }
        }
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}
