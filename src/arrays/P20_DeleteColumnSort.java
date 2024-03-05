package arrays;
public class P20_DeleteColumnSort {
    public static void main(String[] args) {
        String[]arr = {"cba","daf","ghi"};
        System.out.println(missingNums(arr));
    }

    private static int missingNums(String[] s) {
        int count = 0;
        for (int i = 0; i <s[0].length() ; i++) {
            for (int j = 0; j <s.length-1 ; j++) {
                if(s[j].charAt(i)>s[j+1].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
