package answers;
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.List;

public class Question1 {
    public static int bestMergedPortfolio(int[] portfolios) {
        int [][] processedPortfolio = processPortfolios(portfolios);
        List<Integer> binaryList = new ArrayList();
        List<Integer> finalList = new ArrayList();
        for (int z = 0; z <= portfolios.length - 1; z++)
            for (int y = portfolios.length - 1; y >= 0; y--) {
                finalList.addAll(mergePortfolios(processedPortfolio[z], processedPortfolio[y], binaryList));
                binaryList.clear();
            }
        int indexMerge = (int) Math.sqrt(portfolios.length - 1);
        int [] finalOutput = cleanUpResult(indexMerge, finalList);
        Arrays.sort(finalOutput);
        return finalOutput[indexMerge - 1];
    }
    
    public static int[][] processPortfolios(int[] portfolios) {
        int [][] processedPortfolio = new int [portfolios.length][16];
        for (int x = 0; x <= portfolios.length - 1; x++) {
            int index = 32768;
            for (int i = 15; i >= 0; i--) {
                if ((portfolios[x] - index) >= 0) {
                    portfolios[x] = portfolios[x] - index;
                    processedPortfolio[x][i] = 1;
                }
                index = index / 2;
            }
        }
        return processedPortfolio;
    }
    
    public static List<Integer>  mergePortfolios(int[] portfolioA, int[] portfolioB, List<Integer> binaryList) {
        for (int i = 0; i <= 15 ; i++)
            if ((portfolioA[i] == portfolioB[i])){ //&& ((processedPortfolio[z][i] == 1) | (processedPortfolio[y][i] == 0))){
                binaryList.add(0);
            } else binaryList.add(1);
        return binaryList;
    }
    
    public static int[]  cleanUpResult(int indexMerge, List<Integer> finalList) {
        int [] finalOutput = new int [indexMerge];
        for (int x = 0; x <= indexMerge - 1; x ++) {
            int index = 1;
            for (int i = 15; i >= 0; i--) {
                try {
                    if (finalList.get(0) == 1)
                        finalOutput[x] = finalOutput[x] + index;
                } catch (Exception e) {}
                finalList.remove(0);    
                index = index * 2;
            }
        }
        return finalOutput;
    }
}