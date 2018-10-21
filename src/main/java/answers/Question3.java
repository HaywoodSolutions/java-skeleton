package answers;

import helpers.Edge;

public class Question3 {

	public static int lowestExposureToExchanges(int numNodes, Edge[] edgeList) {
		int[] nodes = new int[numNodes];
        for (int e=0; e < edgeList.length; e++) {
            nodes[edgeList[e].getEdgeA() - 1]++;
            nodes[edgeList[e].getEdgeB() - 1]++;
        }
        
        int[] legs = new int[numNodes];
        for (int n=0; n<nodes.length; n++) {
            legs[nodes[n]]++;
        }
        
        boolean first = true;
        int total = 0;
        for (int l= legs.length - 1; l >= 0; l--) {
            if (legs[l] > 0)  {
                System.out.println(legs[l]);
                if (first) {
                    total -= legs[l];
                    first = false;
                } else total += legs[l];
            }
        }
        return total;
	}

  
}
