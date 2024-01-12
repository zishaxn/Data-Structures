package Strings;

public class P12_LargestSubStringBetwnEqualChars {
    public static void main(String[] args) {
        String s = "mgntdygtxrvxjnwksqhxuxtrv";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }
    public static int maxLengthBetweenEqualCharacters(String s) {
        char[]str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            int start = i ;
            int end = str.length-1;
            while(start<end){
                if(str[start]==str[end]){
                    return end-start-1;
                }
                end--;
            }
        }
        return -1;
    }
}
