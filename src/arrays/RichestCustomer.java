package arrays;

//1672. Richest Customer Wealth
public class RichestCustomer {
    public static void main(String[] args) {
        int[][]accounts = {{1,5},{7,3},{3,5}};
        System.out.println(maxWealth(accounts));
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
