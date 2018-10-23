package answers;

import helpers.Edge;

public class Question3 {

	public static int lowestExposureToExchanges(int numNodes, Edge[] edgeList) {
		int chainId = 0;
        int[][] chains = new int[numNodes][3];
        boolean nodes[][] = new boolean[numNodes][numNodes];
        
        for (int e=0; e < edgeList.length; e++) {
            nodes[edgeList[e].getEdgeA() - 1][edgeList[e].getEdgeB() - 1] = true;
            nodes[edgeList[e].getEdgeB() - 1][edgeList[e].getEdgeA() - 1] = true;
        }
  
        boolean repeat;
        for (int nodeA = 1; nodeA <= numNodes; nodeA++)
            for (int nodeB=nodeA; nodeB <= numNodes; nodeB++) {
                do {
                    repeat = false;
                    if (!nodes[nodeA - 1][nodeB - 1]) {
                        if (chains[chainId][2] == 0) {
                            chains[chainId][0] = nodeA;
                            chains[chainId][1] = nodeB;
                            chains[chainId][2] += 2;
                        } else if (nodeA == chains[chainId][0] || nodeB == chains[chainId][0]) {
                            chains[chainId][0] = (nodeA == chains[chainId][0]) ? nodeB: nodeA;
                            chains[chainId][2]++;
                        } else if (nodeA == chains[chainId][1] || nodeB == chains[chainId][1]) {
                            chains[chainId][1] = (nodeA == chains[chainId][1]) ? nodeB: nodeA;
                            chains[chainId][2]++;
                        } else {
                            repeat = true;
                            chainId++;
                        }
                    }
                } while (repeat);
                chainId = 0;
                repeat = false;
            }
        
        int X = 0;
        for (int e=0; e < chains.length; e++)
            if (chains[e][2] > X)
                X = chains[e][2];
                
        X = X / 2;
        return X + X - numNodes;
	}

  
}

