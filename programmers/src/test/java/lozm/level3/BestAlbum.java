package lozm.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BestAlbum {

    @Test
    public void testCase1() {
        // Given
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        // When
        int[] solution = solution(genres, plays);

        // Then
        int[] answer = {4, 1, 3, 0};
        Assertions.assertArrayEquals(answer, solution);
    }

    @Test
    public void testCase2() {
        // Given
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 1000, 150, 800, 1000};

        // When
        int[] solution = solution(genres, plays);

        // Then
        int[] answer = {1, 4, 3, 0};
        Assertions.assertArrayEquals(answer, solution);
    }

    @Test
    public void testCase3() {
        // Given
        String[] genres = {"classic", "classic", "classic", "pop"};
        int[] plays = {500, 150, 800, 1000};

        // When
        int[] solution = solution(genres, plays);

        // Then
        int[] answer = {2, 0, 3};
        Assertions.assertArrayEquals(answer, solution);
    }

    /**
     * 해시 > 베스트앨범
     * https://programmers.co.kr/learn/courses/30/lessons/42579
     * <p>
     * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
     * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
     * 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
     * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는, 고유 번호가 낮은 노래를 먼저 수록합니다.
     * <p>
     * 노래의 장르를 나타내는 문자열 배열 genres
     * 노래별 재생 횟수를 나타내는 정수 배열 plays
     * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return
     */
    public int[] solution(String[] genres, int[] plays) {

        // 장르별 Map, 장르별 수록곡 Map 세팅
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, HashMap<Integer, Integer>> playMapByGenre = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            String genre = genres[i];
            int play = plays[i];

            Integer genrePlay = genreMap.getOrDefault(genre, 0);
            genreMap.put(genre, genrePlay + play);

            HashMap<Integer, Integer> playMapByGenreOrDefault = playMapByGenre.getOrDefault(genre, new HashMap<>());
            int totalPlay = play;
            if (playMapByGenreOrDefault.containsKey(i)) {
                totalPlay += playMapByGenreOrDefault.get(i);
            }
            playMapByGenreOrDefault.put(i, totalPlay);
            playMapByGenre.put(genre, playMapByGenreOrDefault);
        }

        List<Integer> answerList = new ArrayList<>();

        // 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        List<Map.Entry<String, Integer>> descSortedGenreList = getSortDescListByHashMap1(genreMap);

        for (Map.Entry<String, Integer> entry : descSortedGenreList) {

            String genre = entry.getKey();
            HashMap<Integer, Integer> playMap = playMapByGenre.get(genre);

            // 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
            List<Map.Entry<Integer, Integer>> descSortedPlayList = getSortDescListByHashMap2(playMap);

            for (int i = 0; i < descSortedPlayList.size() && i < 2; i++) {
                answerList.add(descSortedPlayList.get(i).getKey());
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    private <K> List<Map.Entry<K, Integer>> getSortDescListByHashMap1(Map<K, Integer> paramMap) {
        List<Map.Entry<K, Integer>> entryList = new LinkedList<>(paramMap.entrySet());
        Collections.sort(entryList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return entryList;
    }


    private List<Map.Entry<Integer, Integer>> getSortDescListByHashMap2(Map<Integer, Integer> paramMap) {
        // 3. 장르 내에서 재생 횟수가 같은 노래 중에서는, 고유 번호가 낮은 노래를 먼저 수록합니다.
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(paramMap.entrySet());
        Collections.sort(entryList, (o1, o2) -> {
            int answer = o2.getValue().compareTo(o1.getValue());
            if (answer == 0) {
                answer = o1.getKey().compareTo(o2.getKey());
            }
            return answer;
        });
        return entryList;
    }


    public class Music implements Comparable<Music>{

        private int played;
        private int id;
        private String genre;

        public Music(String genre, int played, int id) {
            this.genre = genre;
            this.played = played;
            this.id = id;
        }

        @Override
        public int compareTo(Music other) {
            if(this.played == other.played) return this.id - other.id;
            return other.played - this.played;
        }

        public String getGenre() {return genre;}
    }

    public int[] bestSolution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Music(genres[i], plays[i], i))
                .collect(Collectors.groupingBy(Music::getGenre))
                .entrySet().stream()
                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
                .flatMap(x->x.getValue().stream().sorted().limit(2))
                .mapToInt(x->x.id).toArray();
    }

    private int sum(List<Music> value) {
        int answer = 0;
        for (Music music : value) {
            answer+=music.played;
        }
        return answer;
    }

}
