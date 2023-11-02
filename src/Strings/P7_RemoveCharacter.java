package Strings;

public class P7_RemoveCharacter {
    public static void main(String[] args) {
        String s = "xxyyzxx";
        System.out.println(removeChar(s,'y'));
    }

    private static String removeChar(String s, char ch) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=ch){
                output.append(s.charAt(i));
            }
        }
        return output.toString();
    }
}
