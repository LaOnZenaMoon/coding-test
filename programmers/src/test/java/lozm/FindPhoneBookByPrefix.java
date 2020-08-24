package lozm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindPhoneBookByPrefix {

    @Test
    void test1() {
        String[] testData = {"123", "456", "789"};

        boolean solution = solution(testData);

        assertThat(solution).isEqualTo(true);
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for (int i = 0; i <phone_book.length ; i++) {
            for (int j = 1; j <phone_book.length ; j++) {
                if(i == j) continue;

                if(phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }

        return answer;
    }

}
