package lozm;

public class SumBetweenTwoIntegers {

    public long solution(int a, int b) {
        int smallerNumber = Math.min(a, b);
        int biggerNumber = Math.max(a, b);

        Long result = 0L;
        for (int i = smallerNumber; i <= biggerNumber; i++) {
            result += i;
        }

        return result;
    }

    public long bestSolution(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(b, a));
    }

    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }

}
