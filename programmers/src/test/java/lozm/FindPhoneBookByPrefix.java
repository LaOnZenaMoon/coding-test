package lozm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
//
//        List<HashMap<String, Integer>> phoneBookList = new ArrayList<>();
//        for (String phoneNumber : phone_book) {
//            HashMap<String, Integer> map = new HashMap<>();
//            map.put(phoneNumber, 0);
//            phoneBookList.add(map);
//        }

        int index = 0;
        for (int i = 0; i < phone_book.length; i++) {
            if (index == i) continue;

            if (phone_book[i].contains(phone_book[index])) {
                answer = false;
                break;
            }
        }

        return answer;
    }

}
