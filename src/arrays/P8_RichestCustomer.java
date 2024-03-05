package arrays;

//https://leetcode.com/problems/richest-customer-wealth/
//1672. Richest Customer Wealth
public class P8_RichestCustomer {
    public static void main(String[] args) {
        int[][]accounts = {{1,5},{7,3},{3,5},{8,9}};
        System.out.println(maxWealth1(accounts));
    }

    private static int maxWealth1(int[][] accounts) {
        int maxSum = 0;
        for(int[]account:accounts){
            int currSum = findSum(account);
            maxSum=Math.max(maxSum,currSum);
        }
        return maxSum;
    }

    private static int findSum(int[] account) {
        int sum =0;
        for (int j : account) {
            sum = sum + j;
        }
        return sum;
    }

    private static int maxWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] account : accounts) {
            int currwealth = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                currwealth += account[j];
            }
            maxWealth = Math.max(maxWealth, currwealth);
        }
        return maxWealth;
    }
}
