import java.util.List;

public class InputValidator {
    public void checkCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이내여야 합니다.");
            }
        }
    }

    public void checkNumberOfAttempts(int attempts) {
        if (attempts<= 1) {
            throw new IllegalArgumentException("시도할 횟수는 1보다 큰 숫자여야 합니다.");
        }
    }
}
