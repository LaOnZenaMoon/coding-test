package lozm.level1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

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
            String uncompletion = solution1(participant, completion);

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

    //Using list
    public String solution1(String[] participant, String[] completion) {
        String answer = "";

        for (int i = 0; i < participant.length ; i++) {
            boolean answerFlag = true;

            for (int j = 0; j < completion.length ; j++) {
                if(participant[i].equals(completion[j])) {
                    completion[j] = null;
                    answerFlag = false;
                    break;
                }
            }

            if(answerFlag) {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }

    //Using HashMap
    public String solution2(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> participantMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            int value = 1;
            if(participantMap.containsKey(participant[i])) {
                value = participantMap.get(participant[i]) + 1;
            }

            participantMap.put(participant[i], value);
        }

        for (int i = 0; i < completion.length; i++) {
            if(participantMap.containsKey(completion[i])) {
                int value = participantMap.get(completion[i]) - 1;
                participantMap.put(completion[i], value);
            }
        }

        for (String key : participantMap.keySet()) {
            if(participantMap.get(key) > 0) answer += key;
        }

        return answer;
    }

    //Using Sorting - not perfect
    public String solution3(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        int index = 0;
        for (index = 0; index < completion.length; index++) {
            if(!participant[index].equals(completion[index])) return participant[index];
        }

        return answer;
    }

}
