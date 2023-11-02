package Strings;

//Approach1: i first checked if the string is empty ,if then return 0. then what i did is initially i assumed the length
// string as 1 (after 1st check obio) and then iterated thorugh the whole string anf if encountered any space ' ' then increased the count
//indicating word break.


//Approach2: here i used the built-in method that converts the string into an array of strings and then simply retunrned the
//length of the array.


public class P2_CountWords {
    public static void main(String[] args) {
        String str = "All Lol";
        System.out.println(countWords1(str));
        System.out.println(countWords(str));
    }

    private static int countWords1(String str) {
        int n = str.length();
        if (n == 0) {
            return 0;
        }
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        return count;

    }

    private static int countWords(String str) {
        String[] st = str.split(" ");
        return st.length;
    }
}
