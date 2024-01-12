package Strings;

//https://classroom.codingninjas.com/app/classroom/me/19330/content/384870/offering/5459304/problem/349
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class P8_StringPermutation {
    public static void main(String[] args) {
        String s1 = "abcge";
        String s2 = "eabgc";
        System.out.println(checkPermutation2(s1,s2));
    }

    private static boolean checkPermutation2(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < string1.length(); i++) {
            map.put(string1.charAt(i),map.getOrDefault(string1.charAt(i),0)+1);
        }

        for (int i = 0; i < string2.length(); i++) {
            if(!map.containsKey(string2.charAt(i)) || map.get(string2.charAt(i))==0){
                return false;
            }
            map.put(string2.charAt(i),map.get(string2.charAt(i))-1);
        }
        return true;

    }

    private static boolean checkPermutation1(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        char[]a1 = s1.toCharArray();
        char[]a2 = s1.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);

        for (int i = 0; i <a1.length ; i++) {
            if(a1[i]!=a2[i]){
                return false;
            }
        }
        return true;
    }

    private static boolean checkPermutation(String s1, String s2) {
        String[]a1 = s1.split("");
        String[]a2 = s2.split("");
        Arrays.sort(a1);
        Arrays.sort(a2);
        if(s1.length()!=s2.length()){
            return false;
        }
        for (int i = 0; i <s1.length() ; i++) {
            if(!Objects.equals(a1[i], a2[i])){
                return false;
            }
        }
        return true;
    }

}
