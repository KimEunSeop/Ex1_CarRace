import java.util.List;
import java.util.stream.IntStream;

public class Race {

    private static final int CONDITION = 4;
    private final int rounds;
    private final List<Car> carList;
    private final WinnerFinder winnerFinder = new WinnerFinder();

    public Race(int rounds, List<Car> carList) {
        this.rounds = rounds;
        this.carList = carList;
    }

    public void play() {
        System.out.println("실행 결과");
        IntStream.range(0, rounds)
                .forEach(i -> runRound());
        finishRace();
    }

    private void runRound() {
        carList.forEach(car -> {
            if (RandomNumberGenerator.generateRandomInt() >= CONDITION) { // 주사위 굴리기
                car.go();
            }
            drawRace(car);
        });
        finishRound();
    }

    private void finishRound() {
        System.out.println();
    }

    private void finishRace() {
        List<String> winners = winnerFinder.findWinners(carList);  // 우승자 찾기
        winnerFinder.printWinners(winners);  // 우승자 출력
    }

    private void drawRace(Car car) {
        System.out.print(car.getName() + " : ");
        IntStream.range(0, car.getState())
                .forEach(i -> System.out.print("-"));
        System.out.println();
    }
}
