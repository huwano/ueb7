package Second;

import java.util.*;

public class Controler {
    public void start(){
        System.out.println("Bitte wähle zwischen 1.Fifo oder 2.Natürliche Reihenfolge");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 1) {
            fifo();
        } else {
            nat();
        }
    }
    public void fifo() {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        Queue<Integer> queue = new LinkedList<>();
        Random ran = new Random();
        for (int i = 0; i < 10000; i++) {
            if (ran.nextInt(2) > 0) {
                queue.add(producer.produce());
            } else {
                try {
                    consumer.consume(queue.remove());
                } catch (NoSuchElementException ignored) {

                }
            }
        }
        System.out.println(consumer.numberOfDifferentResults());
        System.out.println(consumer.getTimesForCrossTotal(3));
    }
    public void nat(){
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Random ran = new Random();
        for(int i = 0; i<10000; i++)
        {
            if(ran.nextInt(2) > 0 ) {
                queue.add(producer.produce());
            }else {
                try {
                    consumer.consume(queue.remove());
                } catch (NoSuchElementException ignored) {

                }
            }
        }
    }
}
