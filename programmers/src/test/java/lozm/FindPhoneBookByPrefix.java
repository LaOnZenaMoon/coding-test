package lozm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FindPhoneBookByPrefix {

    @Test
    void test1() {
        String[] testData = {"123", "456", "789"};

        boolean solution = solution1(testData);

        assertThat(solution).isEqualTo(true);
    }

    public boolean solution1(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i <phone_book.length ; i++) {
            for (int j = 1; j <phone_book.length ; j++) {
                if(i == j) continue;

                if(phone_book[i].length() > phone_book[j].length()) continue;

                if(phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }

        return answer;
    }

    public boolean solution2(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }

}
