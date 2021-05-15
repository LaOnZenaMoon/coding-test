package lozm.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

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

    /**
     * 디스크 컨트롤러
     * https://programmers.co.kr/learn/courses/30/lessons/42627
     *
     * 각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수
     * 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return
     *
     *
     */
    public int solution(int[][] jobs) {
        Queue<JobController> jobControllerQueue = new PriorityQueue<>();
        for (int[] job : jobs) {
            jobControllerQueue.add(new JobController(job[0], job[1]));
        }

        int answer = getAnswer(jobControllerQueue);

        return answer / jobs.length;
    }

    private int getAnswer(Queue<JobController> jobControllerQueue) {
        int answer = 0;
        int currentTime = 0;

        while (!jobControllerQueue.isEmpty()) {
            if (jobControllerQueue.peek().arrivalTime <= currentTime) {
                final JobController jobController = jobControllerQueue.poll();
                answer += jobController.getResponseTime(currentTime);
                currentTime += jobController.burstTime;
                continue;
            }

            currentTime++;
        }

        return answer;
    }

    class JobController implements Comparable {
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

        @Override
        public int compareTo(Object o) {
            final JobController target = (JobController) o;

            return arrivalTime >= target.arrivalTime ? 1 : -1;
        }
    }

}
