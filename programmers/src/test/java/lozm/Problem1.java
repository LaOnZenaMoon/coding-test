package lozm;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Problem1 {

    @Test
    void mainTest() {
        String s = "world";
        String c = "abcde";

        solution(s, c);
    }


    public boolean solution(String s, String cipher) {
        boolean answer = false;

        if(s.length() != cipher.length()) return false;

        String plain1 = s.toLowerCase();
        StringBuffer plain2 = new StringBuffer();
        String cipher1 = cipher.toLowerCase();

        HashMap<String, String> cryptogram = makeCryptogram();

        for (int i = 0; i < plain1.length() ; i++) {
            plain2.append(cryptogram.get(String.valueOf(plain1.charAt(i))));
        }

        if(plain2.toString().equals(cipher1)) answer = true;

        return answer;
    }

    private HashMap<String, String> makeCryptogram() {
        HashMap<String, String> cryptogram = new HashMap<>();
        cryptogram.put("a", "z");
        cryptogram.put("b", "i");
        cryptogram.put("c", "a");
        cryptogram.put("d", "y");
        cryptogram.put("e", "b");
        cryptogram.put("f", "d");
        cryptogram.put("g", "j");
        cryptogram.put("h", "c");
        cryptogram.put("i", "x");
        cryptogram.put("j", "e");
        cryptogram.put("k", "w");
        cryptogram.put("l", "v");
        cryptogram.put("m", "g");
        cryptogram.put("n", "f");
        cryptogram.put("o", "u");
        cryptogram.put("p", "t");
        cryptogram.put("q", "s");
        cryptogram.put("r", "h");
        cryptogram.put("s", "m");
        cryptogram.put("t", "n");
        cryptogram.put("u", "k");
        cryptogram.put("v", "q");
        cryptogram.put("w", "r");
        cryptogram.put("x", "l");
        cryptogram.put("y", "o");
        cryptogram.put("z", "p");

        return cryptogram;
    }

}
