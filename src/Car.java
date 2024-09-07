import java.util.Random;

public class Car {

    private int state = 0;
    private String name;

    public int getState() {
        return state;
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void go (){
            state++;
    }
}
