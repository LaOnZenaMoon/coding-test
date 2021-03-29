package lozm.level1;

import java.util.*;
import java.util.stream.Collectors;

public class PracticeTest {

    public static void main(String[] args) {
//        int[] answers = {1, 2, 3, 4, 5};
//        int[] answers = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 5};
        int[] answers = {1,3,2,4,2};

        int[] solution = solution(answers);
        System.out.println("solution = " + solution);
    }

    /**
     * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers
     * 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
     * 수포자 1번: 1, 2, 3, 4, 5...
     * 수포자 2번: 2, 1, 2, 3, 2, 4, 2, 5...
     * 수포자 3번: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5...
     * <p>
     * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
     */

    static class Person implements Comparable<Person> {
        private int number;
        private int point = 0;
        private int[] personAnswerCase;
        private int[] personAnswer;

        public Person(int number, int[] personAnswerCase, int answerLength) {
            this.number = number;
            this.personAnswerCase = personAnswerCase;
            this.personAnswer = fillPersonFullAnswer(answerLength, this.personAnswerCase);
        }

        @Override
        public int compareTo(Person o) {
            return this.point - o.point;
        }

    }

    private static int[] fillPersonFullAnswer(int answerLength, int[] personAnswers) {
        int personAnswerCycle = personAnswers.length;
        int[] personFullAnswer = new int[answerLength];


        for (int i = 0; i < answerLength; i++) {
            int index = i;

            if (i >= personAnswerCycle) {
                index = i % personAnswerCycle;
            }

            personFullAnswer[i] = personAnswers[index];
        }
        return personFullAnswer;
    }

    public static int[] solution(int[] answers) {
        int answerLength = answers.length;
        List<Person> personList = new ArrayList<>();

        // 1. 사람 객체 세팅
        Person person1 = new Person(1, new int[]{1, 2, 3, 4, 5}, answerLength);
        personList.add(person1);

        Person person2 = new Person(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5}, answerLength);
        personList.add(person2);

        Person person3 = new Person(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}, answerLength);
        personList.add(person3);
        // 2. 사람별 점수 세팅
        for (int i = 0; i < answers.length; i++) {
            int index = i;

            personList.forEach(person -> {
                if (person.personAnswer[index] == answers[index]) {
                    person.point += 1;
                }
            });
        }

        // 3. 등수 세팅
//        Collections.sort(personList);
        int highestPoint = personList.stream()
                .mapToInt(person -> person.point)
                .max()
                .orElse(0);

        List<Integer> personNumberList = personList.stream()
                .filter(person -> person.point >= highestPoint)
                .map(person -> person.number)
                .sorted()
                .collect(Collectors.toList());

        Integer[] toArray = personNumberList.toArray(new Integer[personNumberList.size()]);
        return Arrays.stream(toArray)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] bestSolution(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
