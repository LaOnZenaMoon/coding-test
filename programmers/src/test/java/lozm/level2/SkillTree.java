package lozm.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SkillTree {

    @Test
    public void testCase() {
        // Given
        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};

        // When
        int solution = solution(skill, skillTrees);

        // Then
        Assertions.assertEquals(2, solution);
    }

    /**
     * 스킬트리
     * https://programmers.co.kr/learn/courses/30/lessons/49993
     *
     * 1. 선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때,
     * 2. 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
     */
    public int solution(String skill, String[] skillTrees) {
        int answer = 0;

        for (int i = 0; i < skillTrees.length; i++) {
            String skillTree = skillTrees[i];
            String requiredSkill = skillTree.replaceAll("[^" + skill + "]", "");

            boolean flag = true;
            for (int j = 0; j < requiredSkill.length(); j++) {
                if (skill.charAt(j) != requiredSkill.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer += 1;
            }
        }


        return answer;
    }

    public int bestSolution(String skill, String[] skill_trees) {
        List<String> skillTrees = new ArrayList<>(Arrays.asList(skill_trees));
        Iterator<String> it = skillTrees.iterator();
        while (it.hasNext()) {
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        return skillTrees.size();
    }

}
