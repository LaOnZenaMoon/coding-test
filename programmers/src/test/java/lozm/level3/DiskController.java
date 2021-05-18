package lozm.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class DiskController {

    @Test
    public void testCase1() {
        // Given
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        // When
        final int solution = solution(jobs);

        // Then
        Assertions.assertEquals(9, solution);
    }

    @Test
    public void testCase2() {
        // Given
        int[][] jobs = {{1, 9}, {0, 3}, {2, 6}};

        // When
        final int solution = solution(jobs);

        // Then
        Assertions.assertEquals(9, solution);
    }

    @Test
    public void testCase3() {
        // Given
        int[][] jobs = {{1, 5}, {6, 3}, {5, 6}, {5, 7}};

        // When
        final int solution = solution(jobs);

        // Then
        Assertions.assertEquals(8, solution);
    }

    /**
     * 디스크 컨트롤러
     * https://programmers.co.kr/learn/courses/30/lessons/42627
     * <p>
     * 각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수
     * 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return
     */
    //TODO 최적의 순서를 찾는 법
    //JobController 의 burstTime 도 영향을 미침
    //1. 현재 작업이 가능
    //currentTime >= arrivalTime
    //2. 그 중 작업 소요시간이 가장 작은 것
    //2가지의 우선순위큐를 활용
    public int solution(int[][] jobs) {

        PriorityQueue<JobController> workableQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.arrivalTime >= o2.arrivalTime) {
                return 1;
            } else {
                return -1;
            }
        });
        PriorityQueue<JobController> lowestBurstTimeQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.burstTime >= o2.burstTime) {
                return 1;
            } else {
                return -1;
            }
        });

        for (int[] job : jobs) {
            workableQueue.add(new JobController(job[0], job[1]));
        }

        int answer = 0;
        int currentTime = 0;

        while (!workableQueue.isEmpty()) {
            // 현재 시간을 기준으로 작업이 가능한 대상을 모두 꺼낸다
            lowestBurstTimeQueue.clear();
            while (!workableQueue.isEmpty() && workableQueue.peek().arrivalTime <= currentTime) {
                lowestBurstTimeQueue.add(workableQueue.poll());
            }

            if (!lowestBurstTimeQueue.isEmpty()) {
                final JobController jobController = lowestBurstTimeQueue.poll();
                answer += jobController.getResponseTime(currentTime);
                currentTime += jobController.burstTime;

                while (!lowestBurstTimeQueue.isEmpty()) {
                    workableQueue.add(lowestBurstTimeQueue.poll());
                }
                continue;
            }

            currentTime++;
        }

        return answer / jobs.length;
    }

    class JobController {
        private Integer arrivalTime;
        private Integer burstTime;


        public JobController(Integer arrivalTime, Integer burstTime) {
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
        }


        public int getResponseTime(int currentTime) {
            if (currentTime < arrivalTime) {
                return -1;
            }

            // 현재시간 - 작업요청시간 + 작업 소요시간
            return currentTime - arrivalTime + burstTime;
        }
    }

}
