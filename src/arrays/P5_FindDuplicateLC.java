package arrays;


import java.util.HashMap;

// 287. Find the Duplicate Number
// different thant normal duplicate array, coz here array contains {1,n} and total no of elements n+1;
public class P5_FindDuplicateLC {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,1};
//        System.out.println(findDuplicate1(arr));
        System.out.println(findDuplicate2(arr));
    }



// Floyd's Tortoise and Hare algorithm  ==> O(n) & O(1)
    private static int findDuplicate2(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];
        do{
            slow=arr[slow];
            fast=arr[arr[fast]];
            System.out.print(slow+" ");
            System.out.println(fast);
        }while(slow!=fast);
        fast=arr[0];
        while(slow!=fast){
            slow=arr[slow];
            fast=arr[fast];

        }
        return slow;
    }


//    Using Hashmaps ==> O(n) and O(n)
    private static int findDuplicate1(int[] arr) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i : arr){
            if(map.containsKey(i)){
                return i;
            }
            else{
                map.put(i,1);
            }
        }
        return -1;
    }
}
