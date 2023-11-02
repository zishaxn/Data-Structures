package Strings;

//https://classroom.codingninjas.com/app/classroom/me/19330/content/384870/offering/5459304/problem/59
public class P9_Remove_Consecutive {
    public static void main(String[] args) {
        String str = "aabbcdde";
        System.out.println(remove(str));
    }

    private static String remove(String str) {
        String output = "";
        output+=str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i)!=str.charAt(i-1)){
                output+=str.charAt(i);
            }
        }
        return output;
    }
}
