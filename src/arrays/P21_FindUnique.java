package arrays;

import java.util.Arrays;

//Approach 1: simple sort, and then a loop --> O(nlogn)
//Approach 2: using XOR , we know 1^5^5 = 1 , therefor 1^5^1^6^3^5^6  = 3. --> o(n)
public class FindUnique {
    public static void main(String[] args) {
        int[]arr = {1,5,1,6,3,5,6};  //Expected output: 3
        System.out.println(uniqueNumber1(arr));
    }

    private static int uniqueNumber1(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i+=2) {
            if(arr[i]!=arr[i+1]){
                return arr[i];
            }
        }
        return -1;
    }

    private static int uniqueNumber(int[] arr) {
        int result = 0;
        for(int i:arr){
            result^=i;
        }
        return result;
    }
}
