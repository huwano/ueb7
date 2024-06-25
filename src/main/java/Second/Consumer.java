package Second;

import java.util.*;

public class Consumer {
    private Map<Integer, List<Long>> sumMap;
    public Consumer() {
        this.sumMap = new HashMap<>();
    }
    public void consume(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        long time = System.currentTimeMillis();
        List<Long> times = sumMap.get(sum);
        if (times == null) {
            // Wenn keine Liste existiert, erstellen wir eine neue
            times = new ArrayList<>();
            sumMap.put(sum, times);
        }
        // Fügen Sie der Liste 'times' das Element 'time' hinzu
        times.add(time);
    }
    public int numberOfDifferentResults() {
        return sumMap.size();
    }
    public int numberOfResults(int sum) {
        List<Long> times = sumMap.get(sum);
        if (times == null) {
            return 0;
        }
        return times.size();
    }
    public PriorityQueue<Integer> getCrossTotalsAscending(){
        PriorityQueue<Integer> crossTotals = new PriorityQueue<>();
        crossTotals.addAll(sumMap.keySet());
        return crossTotals;

    }
    public PriorityQueue<Integer> getCrossTotalsDescending(){

        //TODO: figure this out
        PriorityQueue<Integer> crossTotals = new PriorityQueue<>(Collections.reverseOrder());
        crossTotals.addAll(sumMap.keySet());
        return crossTotals;
    }
    public List<Long> getTimestampsForResult(int sum){
        return sumMap.get(sum);
    }
}
