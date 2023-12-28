package recursion.searchingalgorithms;

import java.util.Arrays;

public class MergeSortRecursion1 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr){
        if(arr.length==1){
            return;
        }
        int mid = arr.length/2;
        int [] left = Arrays.copyOfRange(arr,0,mid);
        int [] right = Arrays.copyOfRange(arr,mid,arr.length);

        mergeSort(left);
        mergeSort(right);


        merge(left,right,arr);

    }
    public static void merge(int[] left,int[]right,int[]arr){
        int i = 0,j = 0,k=0;
        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                arr[k]=left[i];
                i++;
            }
            else{
                arr[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<left.length){
            arr[k]=left[i];
            i++;
            k++;
        }
        while(j<right.length){
            arr[k]=right[j];
            j++;
            k++;
        }

    }
}
