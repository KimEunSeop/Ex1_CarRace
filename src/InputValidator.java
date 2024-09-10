import java.util.List;

public class InputValidator {

    static final int MAX_CAR_NAME = 5;
    static final int MIN_ATTEMPTS = 1;
    public void checkCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > MAX_CAR_NAME) {
                throw new IllegalArgumentException("자동차 이름은 5자 이내여야 합니다.");
            }
        }
    }

    public void checkNumberOfAttempts(int attempts) {
        if (attempts<= MIN_ATTEMPTS) {
            throw new IllegalArgumentException("시도할 횟수는 1보다 큰 숫자여야 합니다.");
        }
    }
}
