package lozm.algotest5;

public class Test {
    public static void main(String[] args) {
        String test = "Abisdnflasf";

//        char[] test1 = new char[test.length()];
//
//        for (int i = 0; i < test.length(); i++) {
//            test1[i] = test.charAt(i);
//        }

//        for (int i = test.length()-1; i >= 0; i--) {
//            System.out.print(test.charAt(i));
//        }
        
        print(test);
    }

    private static void print(String test) {
        if(test.length() == 0) return;
        print(test.substring(1));
        System.out.print(test.charAt(0));
    }
}
