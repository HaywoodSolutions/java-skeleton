package answers;

import java.util.ArrayList;
import java.util.Collections;

public class Question5 {

	public static int shareExchange(int[] allowedAllocations, int totalValue) {
		ArrayList<Integer> changeList = new ArrayList<Integer>();
        for (int change : allowedAllocations) {
            if (change == totalValue) {
                return 1;
            } else if (totalValue > change)
                changeList.add(change);
        }
        changeList.sort(Collections.reverseOrder());
        
        ArrayList<Integer> nodes = new ArrayList(changeList);
        int pass = 1;
        int total;
        do {
            pass++;
            for (int n = 0; n < nodes.size(); n++)
                for (int c = 0; c < changeList.size(); c++) {
                    total = nodes.get(n) + changeList.get(c);
                    if (total == totalValue) {
                        return pass;
                    } else if (total < totalValue) {
                        nodes.add(total);
                    }                
                    nodes.remove(n);
                }
        } while (nodes.size() > 0);
        return -1;
	}

}
