package answers;

import helpers.Edge;

public class Question3 {

	public static int lowestExposureToExchanges(int numNodes, Edge[] edgeList) {
		int[] legs = new int[numNodes];
        for (int e=0; e<edgeList.length; e++) {
            legs[edgeList[e].getEdgeA()]++;
            legs[edgeList[e].getEdgeB()]++;
        }
        
        int total = 0;
        for (int l=0; l<legs.length; l++) {
            if (legs[l] == numNodes - 1) {
                total += 1;
            } else total -= 1;
        }
          
		return -1;
	}

}
