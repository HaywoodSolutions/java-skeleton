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
                    int total = ((int) port + currentPort) % 65535;
                    if (max < total)
                        max = total;
                }
            }
            portfoliosList.add(currentPort);
        }
        return max > 0 ? max : -1;
    }
}
