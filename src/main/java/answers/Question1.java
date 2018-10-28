package answers;

public class Question1 {
    
   public static int bestMergedPortfolio(int[] portfolios) {
        String[] binaryPortfolios = new String[portfolios.length];
        for (int z = 0; z < portfolios.length ; z++)
            binaryPortfolios[z] = String.format("%016d", Integer.toString(portfolios[z], 2));

        int currentTotal = Integer.MAX_VALUE;
        int total;
        for (int z = 0; z < binaryPortfolios.length ; z++) {
            for (int y = z; y < binaryPortfolios.length; y++) {
                total = 0;
                for (int i = 0; i < 16; i++) {
                    if (binaryPortfolios[z].charAt(i) != binaryPortfolios[y].charAt(i))
                        total += (16 - i) * (16 - i);
                }
                if (total > currentTotal)
                    currentTotal = total;
            }
        }
        return currentTotal;
    }
}