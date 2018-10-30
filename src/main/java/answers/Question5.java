package answers;

public class Question5 {
    public static int[][] change_making(int[] set_of_coins, int total) {
      //line 6 has negative index
        int[][] m = new int[set_of_coins.length + 1][total + 1];
        for (int i=0; i < total + 1; i++)
            m[0][i] = i;
        return m;
    }

    public static int shareExchange(int[] coins, int total) {
        int[][] m = change_making(coins, total);
        for (int c=1; c< coins.length + 1; c++)
            for (int r=1; r<total + 1; r++)
                if (coins[c - 1] == r) {
                    m[c][r] = 1;
                } else if (coins[c - 1] > r) {
                    m[c][r] = m[c - 1][r];
                } else
                    m[c][r] = Math.min(m[c - 1][r], 1 + m[c][r - coins[c - 1]]);
        return m[m.length - 1][m[m.length - 1].length - 1];
    }
}
