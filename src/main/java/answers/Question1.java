package answers;
import java.util.Collections;
import java.util.ArrayList;

public class Question1 {
    
    public static int bestMergedPortfolio(int[] portfolios) {
        ArrayList<Integer> finalPortfolio = new ArrayList<Integer>();
        for(int p1=0; p1<portfolios.length; p1++) {
           for(int p2=p1+1; p2<portfolios.length; p1++) {
               finalPortfolio.add(portfolios[p1]^portfolios[p2]);
           }
        }
        
        List<Integer> binaryList = new ArrayList();
        List<Integer> finalList = new ArrayList();
        for (int z = 0; z <= portfolios.length - 1; z++) {
            for (int y = portfolios.length - 1; y >= 0; y--) {
                for (int i = 0; i <= 15 ; i++) {
                    if ((finalPortfolio[z][i] == finalPortfolio[y][i]) && ((finalPortfolio[z][i] == 1) || (finalPortfolio[y][i] == 0))){
                        binaryList.add(0);
                    } else {
                        binaryList.add(1);
                    }
                }
                binaryList.clear();
            }
        }
        int indexMerge = (int) Math.sqrt(portfolios.length - 1);
        
        int findingLargest = 0;
        int largest = 0;
        for (int x = 0; x <= indexMerge - 1; x ++) {
            int conversionIndex = 1;
            for (int i = 15; i >= 0; i--) {
                try {
                    if (finalList.get(0) == 1) {
                        findingLargest += conversionIndex;
                    }
                } catch (Exception e) {}
                finalList.remove(0);    
                conversionIndex = conversionIndex * 2;
            }
            if (findingLargest > largest)
              largest = findingLargest;
            findingLargest = 0;
        }
      
        return largest;
    }
}