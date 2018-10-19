package answers;
import java.util.ArrayList;

public class Question1 {
    public static int bestMergedPortfolio(int[] portfolios) {
        ArrayList portfoliosList = new ArrayList<Integer>(100);
        int BitMaxInt = (int) Math.pow(2, 16) - 1;
        int max = 0;
        for (int i=0; i < portfolios.length; i++) {
            int currentPort = portfolios[i];
            if (currentPort <= BitMaxInt && !portfoliosList.contains(currentPort)) {
                for(Object port : portfoliosList) {
                    int total = addWOverflow(((int) port), currentPort);
                    if (max < total) {
                        max = total;
                    }
                }
            }
            portfoliosList.add(currentPort);
        }
        return max > 0 ? max : -1;
    }
    
    public static String toBinary(Integer portfolioInt) {
      return Integer.toString(portfolioInt, 2);
    }
    
    public static int addWOverflow(int i1, int i2) {
        int sum = (i1 + i2) % 65535;
        return sum;
    }
}
