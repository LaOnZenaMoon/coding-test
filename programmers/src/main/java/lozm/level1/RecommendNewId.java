package lozm.level1;


public class RecommendNewId {

    public static void main(String[] args) {
//        String testCase = "...!@BaT#*..y.abcdefghijklm";
//        String testCase = "z-+.^.";
        String testCase = "=.=";
//        String testCase = "123_.def";
//        String testCase = "abcdefghijklmn.p";

        String solution = solution(testCase);
        System.out.println("solution = " + solution);
    }

    /**
     * 1. 아이디의 길이는 3자 이상 15자 이하여야 합니다.
     * 2. 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
     * 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
     *
     * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
     * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
     * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
     * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
     * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
     * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     *      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
     * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
     *
     * 제한사항
     * 1. new_id는 길이 1 이상 1,000 이하인 문자열입니다.
     * 2. new_id는 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성되어 있습니다.
     * 3. new_id에 나타날 수 있는 특수문자는 -_.~!@#$%^&*()=+[{]}:?,<>/ 로 한정됩니다.
     */

    public static String solution(String new_id) {
        String answer = "";

        // 1단계
        answer = new_id.toLowerCase();

        // 2단계
        String secondPattern = "[^a-z0-9-_.]";
        answer = answer.replaceAll(secondPattern, "");

        // 3단계
        String thirdPattern = "[.]{2,}";
        answer = answer.replaceAll(thirdPattern, ".");

        // 4단계
        String fourthPattern = "^[.]|[.]$";
        answer = answer.replaceAll(fourthPattern, "");

        // 5단계
        answer = answer.length() == 0 ? "a" : answer;

        // 6단계
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll(fourthPattern, "");
        }

        // 7단계
        while (answer.length() <= 2) {
            char answerLastChar = answer.charAt(answer.length()-1);
            answer = answer.concat(String.valueOf(answerLastChar));
        }

        return answer;
    }

}
