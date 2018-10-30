package answers;

import java.util.Arrays;

public class Question1 {
  
   public static int bestMergedPortfolio(int[] portfolios) {
         int currentTotal = 0;
        int total;
        //String binaryTotal = "0000000000000000";
        //String binary;
        for (int z = 0; z < portfolios.length ; z++)
            for (int y = z; y < portfolios.length; y++) {
                total = portfolios[z] ^ portfolios[y];
                total = total % 65536;
                
                
                //binary = String.format("%16s", Integer.toString(total, 2).toString()).replace(' ', '0');
                //if (binary.length() > 16)
                //    binary.substring(binary.length() - 1 - 16, binary.length());
                if (total > currentTotal) {
                    currentTotal = total;
                    //binaryTotal = binary;
                }
            }
        return currentTotal;
    }
  
}