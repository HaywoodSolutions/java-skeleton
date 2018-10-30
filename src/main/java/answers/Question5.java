package answers;

import java.util.Arrays;

public class Question5 {
  
    public static int shareExchange(int[] allowedAllocations, int totalValue) {
        if (allowedAllocations == null || allowedAllocations.length == 0)
            return 0;
        allowedAllocations = Arrays.stream(allowedAllocations).distinct().toArray();
        int[] changeCollector = new int[totalValue + 1];
        
        int max = Integer.MAX_VALUE / 2;
        Arrays.fill(changeCollector, max);
        changeCollector[0] = 0;
            
        for (int i = 0; i <= allowedAllocations.length - 1; i++)
            for (int k = 1; k <= totalValue; k++)
                if (allowedAllocations[i] <= k)
                    if ((changeCollector[k - allowedAllocations[i]] + 1) < changeCollector[k])
                        changeCollector[k] = changeCollector[k - allowedAllocations[i]] + 1;
      
        return (changeCollector[totalValue] != max) ? changeCollector[totalValue] : 0;
    }
  
}
