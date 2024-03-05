package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//https://www.codingninjas.com/studio/problems/intersection-of-2-arrays_1082149

//We need to find intesection {1,2,2,3,4,5,6,7} and {2,2,4,4,5} ans==>> [2, 2, 4, 5]

/*

APPROACH-3--> BRUTE : TWO FOR LOOPS AND WHEN WE FOUND SET THE SECOND ELEMENT NULL.

APPROACH-2--> OPTIMIZED : HASHMAP

APPROACH-1--> BEST : TWO POINTERS



* */
public class P12_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        // Example arrays
        int[] arr1 = {1,2,2,3,4,5,6,7};
        int[] arr2 = {2,2,4,4,5};

        // Convert arrays to ArrayLists
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(Arrays.stream(arr1).boxed().toArray(Integer[]::new)));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(Arrays.stream(arr2).boxed().toArray(Integer[]::new)));
        System.out.println("First  : "+findArrayIntersection1(list1,list1.size(),list2,list2.size()));
        System.out.println("second : "+findArrayIntersection2(list1,list1.size(),list2,list2.size()));
        System.out.println("Third  : "+findArrayIntersection3(list1,list1.size(),list2,list2.size()));
//        System.out.println(findArrayIntersection2(list1,list1.size(),list2,list2.size()));
//        System.out.println(Arrays.toString(intersection(arr1,arr2)));
    }

//    Best : O(n) && o(1)
    private static ArrayList<Integer> findArrayIntersection1(ArrayList<Integer> list1, int size, ArrayList<Integer> list2, int size1) {
        ArrayList<Integer>ans = new ArrayList<>();
        int l1=0;
        int l2=0;
        while(l1<list1.size() && l2<list2.size()){
            if(list1.get(l1)>list2.get(l2)){
                l2++;
            }
            else if(list1.get(l1)<list2.get(l2)){
                l1++;
            }
            else{
                ans.add(list1.get(l1));
                l1++;
                l2++;
            }
        }
        return ans;

    }


//    optimized o(2n) && O(n)
    private static ArrayList<Integer> findArrayIntersection2(ArrayList<Integer> list1, int size, ArrayList<Integer> list2, int size1) {
        ArrayList<Integer>ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i :list1){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i : list2){
            if (map.containsKey(i) && map.get(i)>0){
                ans.add(i);
                map.put(i,map.getOrDefault(i,0)-1);
            }
        }
        return ans;
    }

//    Brute force 0(n2) => O(n*m) && O(1)
    public static ArrayList<Integer> findArrayIntersection3(ArrayList<Integer> nums1, int n, ArrayList<Integer> nums2, int m){
        ArrayList<Integer>ans = new ArrayList<>();
        for (int k : nums1) {
            for (int j = 0; j < nums2.size(); j++) {
                if (k == nums2.get(j)) {
                    nums2.set(j, Integer.MIN_VALUE);
                    ans.add(k);
                    break;
                }
                if(k<nums2.get(j)){
                    break;
                }
            }
        }
       return ans;
    }

    public static int[] findArrayIntersection3(int[] nums1, int[] nums2) {
        ArrayList<Integer>ans = new ArrayList<>();
        for (int k : nums1) {
            for (int j = 0; j < nums2.length; j++) {
                if (k == nums2[j]) {
                    nums2[j] = Integer.MIN_VALUE;
                    ans.add(k);
                    break;
                }
            }
        }
        int[]ansArray = new int[ans.size()];
        for (int i = 0; i < ansArray.length; i++) {
            ansArray[i]= ans.get(i);
        }
        return ansArray;
    }
}
