package lozm;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerCouldNotFinishing {

    @Test
    void test() {
        //Given
        Faker faker = new Faker();

        //Set the participants
        List<String> participantArray = new ArrayList<>();

        int participantSize = ThreadLocalRandom.current().nextInt(1, 100000);
        for (int i = 0; i < participantSize; i++) {
            participantArray.add(faker.name().username());
        }
        String[] participant = (String[]) participantArray.toArray();

        //Set the completions
        String[] completion = {};
        int randomInt = ThreadLocalRandom.current().nextInt(1, participantSize);


        //When
        String uncompletion = solution(participant, completion);

        //Then
        assertThat(uncompletion).isEqualTo("");
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        return answer;
    }

}
