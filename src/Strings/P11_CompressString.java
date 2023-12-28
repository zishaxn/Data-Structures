package Strings;

/*Q: In this problem we have to compress the string if there are same chars consecutively.
    Eg: string : "aaabbcddeeeee" , compressed String :  a3b2cd2e5
*/

/* Approach : what we gonna do is that we will have outut string and a count for chars and we will iterate over the strimg.
   we will iterate and increse the counter until we find that next char is not same as previous so we will add that particular
   char to our output string and append it with count and the again set the count to 1 and continue iteration. finally return the output.
* */

public class P11_CompressString {
    public static void main(String[] args) {
        String s = "aaabbcddeeeee";
        System.out.println(compressString(s));
    }

    private static String compressString(String s) {
        int n = s.length() - 1;
        String output = " ";
        int count = 1;
        int i;
        for (i = 0; i < n; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                if (count != 1) {
                    output = output + s.charAt(i) + count;
                } else {
                    output = output + s.charAt(i);
                }
                count = 1;
            }
        }
        if (count != 1) {
            output = output + s.charAt(i) + count;
        } else {
            output = output + s.charAt(i);
        }

        return output;
    }
}
