package answers;

public class Question1 {
  
   public static int bestMergedPortfolio(int[] portfolios) {
        int max = 0;
        int total;
        int n = portfolios.length;

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) {
                total = portfolios[i] ^ portfolios[j];
                if (total > max)
                  max = total;
            }
     
        return max;
    }
  
}