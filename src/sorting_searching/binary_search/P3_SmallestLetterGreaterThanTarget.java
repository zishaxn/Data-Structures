package sorting_searching.binary_search;


// in this question we have to return the element that is greater than the target alphabet and if there is no alphabet
// greater than we need to return the first character.
public class P3_SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] arr = {'c','e','f', 'j'};
        char target = 'e';
        System.out.println(nextGreatestLetter(arr, target));
    }

    public static char nextGreatestLetter(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
//        we could have simply resulted the start, but we need to make sure that we return the first char if no char is
//        bigger than the chars in array.
        return arr[start%arr.length];
    }
}

//Approach :
/*
* we know BS so , we will follow that only.
* we know that the moment start becomes greater that the target element we have got out answer,
* because that means we have found our element or reached the end of the array, so in first case suppose we found
* smallest than we return the start, be */