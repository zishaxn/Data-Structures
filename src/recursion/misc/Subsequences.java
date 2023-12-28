package recursion.misc;

public class Subsequences {
    public static void main(String[] args) {
        String input = "ABC";
        printSubsequences(input,"");
        //String[] output = subsequences(input);
//        for (int i = output.length-1;i>=0;i--) {
//            System.out.println(output[i]);
//        }
    }


    /* We have been given a String and, we have to return an Array of Strings with all possible subsequences
     E.g. ABC --> " EMPTY " A,B,C,AB,AC,BC,ABC
     */
    private static String[] subsequences(String input) {
        if (input.length() == 0) {
            String[] output = new String[1];
            output[0] = "";
            return output;
        }
        String[] smallOutput = subsequences(input.substring(1));
        String[] output = new String[2 * smallOutput.length];
        for (int i = 0; i < smallOutput.length; i++) {
            output[i] = smallOutput[i];
        }
        for (int i = 0; i < smallOutput.length; i++) {
            output[smallOutput.length + i] = input.charAt(0) + smallOutput[i];
        }
        return output;
    }

    public static void printSubsequences(String input ,String prevString){
        if(input.length()==0){
            System.out.println(prevString);
            return;
        }
        String small = input.substring(1);
        printSubsequences(small,prevString);
        printSubsequences(small,prevString+input.charAt(0));

    }

}
