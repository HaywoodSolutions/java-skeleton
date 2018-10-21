package answers;
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.List;

public class Question1 {
    
    public static int bestMergedPortfolio(int[] portfolios) {
        int [][] finalPortfolio = toBinary(portfolios);
        
        // Merge all the portfolios with another
        List<Integer> binaryList = new ArrayList();
        List<Integer> finalList = new ArrayList();
        for (int z = 0; z <= portfolios.length - 1; z++) {
            for (int y = portfolios.length - 1; y >= 0; y--) {
                finalList.addAll(mergePortfolios(finalPortfolio[z], finalPortfolio[y], binaryList));
                binaryList.clear();
            }
        }
        int indexMerge = (int) Math.sqrt(portfolios.length - 1);
        
        // Modify the finalList to return every value as 16 bit binary and display the value in final output
        int [] finalOutput = new int [indexMerge];
        for (int x = 0; x <= indexMerge - 1; x ++) {
            int conversionIndex = 1;
            for (int i = 15; i >= 0; i--) {
                try {
                    if (finalList.get(0) == 1) {
                        finalOutput[x] = finalOutput[x] + conversionIndex;
                    }
                } catch (Exception e) {}
                finalList.remove(0);    
                conversionIndex = conversionIndex * 2;
            }
        }
        
        //Get the largest merged protfolio
        Arrays.sort(finalOutput);
        return finalOutput[indexMerge - 1];
    }
    
    public static int[][] toBinary(int[] portfolios) {
        int [][] finalPortfolio = new int [portfolios.length][16];
        for (int x = 0; x <= portfolios.length - 1; x++) {
            int conversionIndex = 32768;
            for (int i = 15; i >= 0; i--) {
                if ((portfolios[x] - conversionIndex) >= 0) {
                    portfolios[x] = portfolios[x] - conversionIndex;
                    finalPortfolio[x][i] = 1;
                }
                conversionIndex = conversionIndex / 2;
            }
        }
        
        return finalPortfolio;
    }
    
    public static List<Integer>  mergePortfolios(int[] portfolioA, int[] portfolioB, List<Integer> binaryList) {
        for (int i = 0; i <= 15 ; i++) {
            if ((portfolioA[i] == portfolioB[i]) && ((portfolioA[i] == 1) | (portfolioB[i] == 0))){
                binaryList.add(0);
            } else {
                binaryList.add(1);
            }
        }
        return binaryList;
    }
}