package answers;

public class Question1 {
  
   public static int bestMergedPortfolio(int[] portfolios) {
        int max = 0;
        int total;

        for (int i = 0; i < portfolios.length - 1; i++)
            for (int j = i + 1; j < portfolios.length; j++) {
                total = portfolios[i] ^ portfolios[j];
                if (total > max)
                    max = total;
            }
     
        return max;
    }
  
}