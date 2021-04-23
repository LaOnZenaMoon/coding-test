package lozm.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class TruckPassingTheBridge {

    @Test
    public void testCase1() {
        // Given
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        // When
        int solution = solution(bridge_length, weight, truck_weights);

        // Then
        Assertions.assertEquals(8, solution);
    }

    @Test
    public void testCase2() {
        // Given
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};

        // When
        int solution = solution(bridge_length, weight, truck_weights);

        // Then
        Assertions.assertEquals(101, solution);
    }

    @Test
    public void testCase3() {
        // Given
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        // When
        int solution = solution(bridge_length, weight, truck_weights);

        // Then
        Assertions.assertEquals(110, solution);
    }

    /**
     * 다리를 지나는 트럭
     * https://programmers.co.kr/learn/courses/30/lessons/42583
     */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        LinkedList<Truck> waitingQueue = new LinkedList<>();
        for (int truck_weight : truck_weights) {
            waitingQueue.add(new Truck(truck_weight));
        }

        LinkedList<Truck> onTheBridgeQueue = new LinkedList<>();
        onTheBridgeQueue.add(waitingQueue.poll());

        while (!onTheBridgeQueue.isEmpty()) {
            for (int i = 0; i < onTheBridgeQueue.size(); i++) {
                if (onTheBridgeQueue.get(i).second >= bridge_length) {
                    onTheBridgeQueue.remove(i);
                }
            }

            // check Truck Weight on The bridge
            int truckWeightSum = 0;
            for (Truck truck : onTheBridgeQueue) {
                truckWeightSum += truck.weight;
            }

            // add truck
            if (!waitingQueue.isEmpty() && truckWeightSum + waitingQueue.peek().weight <= weight) {
                Truck polledTruck = waitingQueue.poll();
                onTheBridgeQueue.add(polledTruck);
                truckWeightSum += polledTruck.weight;
            }

            // add truck second
            for (Truck truck : onTheBridgeQueue) {
                truck.second += 1;
            }
            answer++;
        }

        return answer;
    }

    class Truck {
        int weight;
        int second;

        public Truck(Integer weight) {
            this.weight = weight;
            this.second = 0;
        }
    }

}
