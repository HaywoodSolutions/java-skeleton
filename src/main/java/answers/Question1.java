package answers;
import java.util.Collections;
import java.util.ArrayList;

public class Question1 {
    
    public static int bestMergedPortfolio(int[] portfolios) {
        ArrayList<Integer> FinalPortfolio = new ArrayList<Integer>();
        for(int p1=0; p1<portfolios.length; p1++) {
           for(int p2=p1+1; p2<portfolios.length; p1++) {
               FinalPortfolio.add(portfolios[p1]^portfolios[p2]);
           }
        }
        return Collections.max(FinalPortfolio);
    }
}