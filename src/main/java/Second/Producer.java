package Second;

import java.util.Random;

public class Producer {
    Random ran = new Random();
    public int produce() {
        return ran.nextInt(1000);
    }
}
