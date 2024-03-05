package Strings;

import java.util.Objects;

public class    P1_CheckPalindrome {
    public static void main(String[] args) {
        String str = "AM";
        System.out.println(isPalindrome2(str));
        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome1(str));
    }

    private static boolean isPalindrome2(String str) {
        str = str.replaceAll("[^a-zA-z0-9]","").toLowerCase();
        int start = 0;
        int end = str.length()-1;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome1(String str) {
        int n = str.length()-1;
        boolean isPalindrome = true;
        for(int i =0; i<=n/2;i++){
            if (str.charAt(i) != str.charAt(n - i)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;

    }

    public static boolean isPalindrome(String str) {
        String[]s = str.split("");
        int start =0;
        int end = s.length-1;
        while(start<end){
            if(!Objects.equals(s[start], s[end])){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
