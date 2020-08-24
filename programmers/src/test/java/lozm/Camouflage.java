package lozm;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.Collectors.*;

public class Camouflage {

    @Test
    void test() {
        //Given
//        int numOfClothesType = ThreadLocalRandom.current().nextInt(1, 30);
//        String[] typeOfClothes = new String[numOfClothesType];
//        for (int i = 0; i < numOfClothesType; i++) {
//            typeOfClothes[i] = getRandomName();
//        }
//
//
//        int numOfClothesName = ThreadLocalRandom.current().nextInt(1, 30);
//        String[][] spyHasClohtes = new String[numOfClothesName][2];
//        for (int i = 0; i < numOfClothesName ; i++) {
//            int randomClothesType = ThreadLocalRandom.current().nextInt(1, numOfClothesType);
//            spyHasClohtes[i][0] = getRandomName();
//            spyHasClohtes[i][1] = typeOfClothes[randomClothesType];
//        }
        String[][] spyHasClohtes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        //When
        solution1(spyHasClohtes);

        //Then

    }

    /**
     * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한사항
     * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
     * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
     * 같은 이름을 가진 의상은 존재하지 않습니다.
     * clothes의 모든 원소는 문자열로 이루어져 있습니다.
     * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
     * 스파이는 하루에 최소 한 개의 의상은 입습니다.
     * @param clothes
     * @return(동일부위1 의상 개수 + 1) * (동일부위2 의상 개수+1) *.... -1
     */

    public int solution1(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> numOfClothesType = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String clothesType = clothes[i][1];
            int value = 1;
            if(numOfClothesType.containsKey(clothesType)) {
                value += numOfClothesType.get(clothesType);
            }
            numOfClothesType.put(clothesType, value);
        }

        for (String clothesType : numOfClothesType.keySet()) {
            answer = answer * (numOfClothesType.get(clothesType) + 1);
        }

        return answer - 1;
    }

    public int solution2(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
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

}
