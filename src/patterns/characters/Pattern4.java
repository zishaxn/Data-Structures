package patterns.characters;

public class Pattern4 {
    public static void main(String[] args) {
        print(4);
    }
    public static void print(int n){
        for (int i = n; i >0 ; i--) {
            char ch = (char) ('A'+i-1);
            for (int j = 1; j <=n-i+1 ; j++) {
                System.out.print(ch+" ");
                ch++;
            }
            System.out.println();
        }
    }
}
