package Second;

import java.util.*;

public class Controler {
    private Producer producer;
    private Consumer consumer;
    private Queue<Integer> qSum;
    private Random ran;
    public void start(){
        System.out.println("Bitte wähle zwischen 1.Fifo oder 2.Natürliche Reihenfolge");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 1) {
            qSum = new LinkedList<>();
        } else {
            qSum = new PriorityQueue<>();
        }
         producer = new Producer();
         consumer = new Consumer();
        for (int i = 0; i < 10000; i++) {
            if (ran.nextInt(2) > 0) {
                qSum.add(producer.produce());
            } else {
                if (qSum != null){
                    consumer.consume(qSum.poll());
                }
            }
        }
        System.out.println(consumer.numberOfDifferentResults());
        System.out.println(consumer.getTimestampsForResult(3));
        System.out.println(consumer.getCrossTotalsAscending());
        System.out.println(consumer.getCrossTotalsDescending());
    }
}
