package answers;

public class Question1 {
  
   public static int bestMergedPortfolio(int[] portfolios) {
        if(portfolios.length < 2) {
            return portfolios[0];
        } else {
            int n = (portfolios.length - 1);
            int total;
            int max = 0;
            for (int i=0; i<n; i++)
                for (int j=i+1; j<=n; j++) {
                    total = (int) (portfolios[i] ^ portfolios[j]);              
                    if (max<total) max = total;
                }
            return max;
        }
    }
  
}