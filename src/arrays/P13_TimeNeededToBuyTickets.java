package arrays;

public class P13_TimeNeededToBuyTickets {
    //2073. Time Needed to Buy Tickets
    public static void main(String[] args) {
        int[] arr = {2, 3,5, 2, 4, 6, 1};
        int[]arr1 ={4,2,3,1};
        System.out.println(timeToBuy(arr, 2));

//        2 3 5 2 4 6 1 --initial
//        3 5 2 4 6 1 1
//        5 2 4 6 1 1 2
//        2 4 6 1 1 2 4
//        4 6 1 1 2 4 1
//        6 1 1 2 4 1 3
//        1 1 2 4 1 3 5
//        1 2 4 1 3 5 0
//        2 4 1 3 5 0
//        4 1 3 5 1
//        1 3 5 1 3
//        3 5 1 3 0

    }

    public static int timeToBuy(int[] tickets, int k) {
       int pers = tickets[k];
       int time = 0;
        for (int i = 0; i <tickets.length ; i++) {
            if(i<=k){
                time+=Math.min(pers,tickets[i]);
            }
            else {
                time += Math.min(pers - 1, tickets[i]);
            }
        }
        return time;
    }
}
