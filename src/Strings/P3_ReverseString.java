package Strings;

public class P3_ReverseString {
    public static void main(String[] args) {
        String str = "Zishan";
        System.out.println(reverse1(str));
    }




    private static String reverse1(String str) {
        int length = str.length();
        StringBuilder ans = new StringBuilder();
        for (int i = length-1; i >=0 ; i--) {
            ans.append(str.charAt(i));
        }
        return ans.toString();
    }


    private static String reverse(String str) {
        int start = 0;
        int end = str.length()-1;
//        while(start<end){
//            char temp =str.charAt(start);
//            str.charAt(start) = str.charAt(end);
//            str.charAt(end)= temp;
//            start++;
//            end--;
//        }
        return str;
    }
}
