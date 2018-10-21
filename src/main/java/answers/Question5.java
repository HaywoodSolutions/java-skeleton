package answers;

public class Question5 {

	public static int shareExchange(int[] allowedAllocations, int totalValue) {
		int[] nodes = new int[allowedAllocations.length];
        int[] newNodes;
        int newNodesLength = allowedAllocations.length;
        int pass = 1;
        
        for (int i=0; i<allowedAllocations.length; i++) {
            if (totalValue == allowedAllocations[i]) {
                return pass;
            } else if (allowedAllocations[i] < totalValue) 
                nodes[i] = allowedAllocations[i];
        }
        while (nodes.length > 0) {
            newNodes = new int[(newNodesLength * allowedAllocations.length)];
            newNodesLength = 0;
            for (int a=0; a<nodes.length; a++) {
                for (int b=0; b<allowedAllocations.length; b++) {
                    int total = nodes[a] + allowedAllocations[b];
                    if (total == totalValue) {
                        return pass + 1;
                    } else if (total < totalValue) {
                        newNodes[newNodesLength] = nodes[a] + allowedAllocations[b];
                        newNodesLength++;
                    }
                }
            }
            nodes = newNodes;
            pass++;
        }
        return -1;
	}

}
