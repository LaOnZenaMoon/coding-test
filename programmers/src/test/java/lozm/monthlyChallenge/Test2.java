package lozm.monthlyChallenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.util.stream.Collectors.joining;

public class Test2 {

    @Test
    public void testCase1() {
        // Given
        String s = "[](){}";

        // When
        int solution = solution(s);

        // Then
        Assertions.assertEquals(3, solution);
    }

    @Test
    public void testCase2() {
        // Given
        String s = "}]()[{";

        // When
        int solution = solution(s);

        // Then
        Assertions.assertEquals(2, solution);
    }

    @Test
    public void testCase3() {
        // Given
        String s = "[)(]";

        // When
        int solution = solution(s);

        // Then
        Assertions.assertEquals(0, solution);
    }

    @Test
    public void testCase4() {
        // Given
        String s = "}}}";

        // When
        int solution = solution(s);

        // Then
        Assertions.assertEquals(0, solution);
    }

    @Test
    public void testCase5() {
        // Given
        String s = "}";

        // When
        int solution = solution(s);

        // Then
        Assertions.assertEquals(0, solution);
    }

    @Test
    public void testCase6() {
        // Given
        String s = "({})";

        // When
        int solution = solution(s);

        // Then
        Assertions.assertEquals(0, solution);
    }

    /**
     * 다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
     *
     * (), [], {} 는 모두 올바른 괄호 문자열입니다.
     * 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
     * 만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다. 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
     * 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * s의 길이는 1 이상 1,000 이하입니다.
     * 입출력 예
     * s	result
     * "[](){}"	3
     * "}]()[{"	2
     * "[)(]"	0
     * "}}}"	0
     * 입출력 예 설명
     * 입출력 예 #1
     *
     * 다음 표는 "[](){}" 를 회전시킨 모습을 나타낸 것입니다.
     * x	s를 왼쪽으로 x칸만큼 회전	올바른 괄호 문자열?
     * 0	"[](){}"	O
     * 1	"](){}["	X
     * 2	"(){}[]"	O
     * 3	"){}[]("	X
     * 4	"{}[]()"	O
     * 5	"}[](){"	X
     * 올바른 괄호 문자열이 되는 x가 3개이므로, 3을 return 해야 합니다.
     * 입출력 예 #2
     *
     * 다음 표는 "}]()[{" 를 회전시킨 모습을 나타낸 것입니다.
     * x	s를 왼쪽으로 x칸만큼 회전	올바른 괄호 문자열?
     * 0	"}]()[{"	X
     * 1	"]()[{}"	X
     * 2	"()[{}]"	O
     * 3	")[{}]("	X
     * 4	"[{}]()"	O
     * 5	"{}]()["	X
     * 올바른 괄호 문자열이 되는 x가 2개이므로, 2를 return 해야 합니다.
     * 입출력 예 #3
     *
     * s를 어떻게 회전하더라도 올바른 괄호 문자열을 만들 수 없으므로, 0을 return 해야 합니다.
     * 입출력 예 #4
     *
     * s를 어떻게 회전하더라도 올바른 괄호 문자열을 만들 수 없으므로, 0을 return 해야 합니다.
     */

    /**
     * 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다.
     * 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때
     * s가 올바른 괄호 문자열이 되게 하는
     * x의 개수를 return 하도록 solution 함수를 완성해주세요.
     */
    public int solution(String param) {
        if (param.length() <= 1) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        String[] split = param.split("");
        for (int i = 0; i < param.length(); i++) {
            queue.add(split[i]);
        }

        int answer = 0;

        for (int i = 0; i < param.length(); i++) {
            if (check(queue.stream().collect(joining()))) {
                answer++;
            }
            queue.add(queue.poll());
        }


        return answer;
    }

    private boolean check(String source) {
        if(source.length()%2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i =0; i<source.length(); i++) {
            switch(source.charAt(i)) {
                //닫힌것은 비교하여 뺀다
                case ')':
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '(') stack.pop();
                    break;
                case '}':
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '{') stack.pop();
                    break;
                case ']':
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '[') stack.pop();
                    break;
                //열린것은 담고
                default :
                    stack.push(source.charAt(i));
                    break;
            }
        }
        return stack.empty();
    }


}
