package Strings;

import java.util.HashMap;
import java.util.Map;

public class P13_IsSubString {
    public static void main(String[] args) {
        String str1  = "Helpello";
        String str2 = "ell";
        System.out.println(isSubstring(str1,str2));


    }

    private static boolean isSubstring(String str1, String str2) {
        int s1=0;
        int s2 = 0;
        while(s1<str1.length() && s2<str2.length()){
            if(str1.charAt(s1)==str2.charAt(s2)){
                s1++;
                s2++;
            }
            else{
                s1++;
                s2=0;
            }
        }
        return s2 == str2.length();
    }

}
