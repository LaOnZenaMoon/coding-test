package lozm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerCouldNotFinishing {

    @Test
    void test() {
        try {
            //Given
            //Set the participants
            List<String> participantArray = new ArrayList<>();

            int participantSize = ThreadLocalRandom.current().nextInt(1, 100000);
            for (int i = 0; i < participantSize; i++) {
                participantArray.add(getRandomName());
            }
            String[] participant = participantArray.toArray(new String[participantArray.size()]);

            //Set the completions
            int randomInt = ThreadLocalRandom.current().nextInt(1, participantSize);
            participantArray.remove(randomInt);
            String[] completion = participantArray.toArray(new String[participantArray.size()]);

            //When
            String uncompletion = solution(participant, completion);

            //Then
            assertThat(participant.length-1).isEqualTo(completion.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getRandomName() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int nameLength = ThreadLocalRandom.current().nextInt(1, 20);
        StringBuffer randomName = new StringBuffer();

        for (int i = 0; i < nameLength; i++) {
            int randomAlphabet = ThreadLocalRandom.current().nextInt(0, alphabet.length);
            randomName.append(alphabet[randomAlphabet]);
        }

        return randomName.toString();
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        return answer;
    }

}
