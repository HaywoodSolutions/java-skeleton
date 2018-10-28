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
        System.out.println(changeList);
        do {
            pass++;
            for (int n = 0; n < nodes.size(); n++)
                for (int c = 0; c < changeList.size(); c++) {
                    total = nodes.get(n) + changeList.get(c);
                    System.out.println(nodes.get(n) + " " + changeList.get(c) + " " + total +" "+ totalValue + " " + nodes.size());
                    if (total == totalValue) {
                        System.out.println("EQUALS");
                        return pass;
                    } else if (total < totalValue) {
                        System.out.println("LESS");
                        nodes.add(total);
                    } else  {
                        System.out.println("END NODE");
                    }
                
                    nodes.remove(n);
                }
        } while (nodes.size() > 0);
        return -1;
	}

}
