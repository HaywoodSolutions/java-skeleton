package answers;

import java.util.Map;
import java.util.HashMap;

public class Question5 {
    public static int shareExchange(int[] allowedAllocations, int totalValue) {
        Map<Integer, Integer> map = new HashMap<>();
        return findMin(totalValue, allowedAllocations, map);
    }
    
    public static int findMin(int total, int coins[], Map<Integer, Integer> map) {
        if (total == 0)
            return 0;

        if (map.containsKey(total))
            return map.get(total);

        int min = Integer.MAX_VALUE;
        for (int i=0; i < coins.length; i++) {
            if(coins[i] > total)
                continue;
            int val = findMin(total - coins[i], coins, map);
            if( val < min )
                min = val;
        }

        min =  (min == Integer.MAX_VALUE ? min : min + 1);
        map.put(total, min);
        return min;
    }
}
