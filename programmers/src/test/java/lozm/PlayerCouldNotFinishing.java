package lozm;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerCouldNotFinishing {

    @Test
    void test() {
        //Given
        //Set the participants
        List<String> participantArray = new ArrayList<>();

        int participantSize = ThreadLocalRandom.current().nextInt(1, 100000);
        for (int i = 0; i < participantSize; i++) {
            participantArray.add(getRandomName());
        }
        String[] participant = (String[]) participantArray.toArray();

        //Set the completions
        int randomInt = ThreadLocalRandom.current().nextInt(1, participantSize);
        participantArray.remove(randomInt);
        String[] completion = (String[]) participantArray.toArray();

        //When
        String uncompletion = solution(participant, completion);

        //Then
        assertThat(participant.length-1).isEqualTo(completion.length);
    }

    public String getRandomName() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int nameLength = ThreadLocalRandom.current().nextInt(1, 20);
        StringBuilder randomName = new StringBuilder();

        for (int i = 0; i < nameLength; i++) {
            int randomAlphabet = ThreadLocalRandom.current().nextInt(0, alphabet.length);
            randomName.append(alphabet[randomAlphabet]);
        }

        return getRandomName();
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        return answer;
    }

}
