import java.util.List;

public class InputData {
    private List<String> carNames;
    private int attempts;

    public InputData(List<String> carNames, int attempts) {
        this.carNames = carNames;
        this.attempts = attempts;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getAttempts() {
        return attempts;
    }
}
