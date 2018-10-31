package answers;

import helpers.Edge;
import java.util.Arrays;

public class Question3 {

	public static int minestExposureToExchanges(int numNodes, Edge[] edgeList) {
        if (edgeList == null || edgeList.length == 0)
            return 0;
            
        int[] nodeEdges = new int[numNodes + 1];
        int noOfArcs = nodeEdges.length;

        for (Edge e: edgeList) {
            nodeEdges[e.getEdgeA()]++;
            nodeEdges[e.getEdgeB()]++;
        }
        
        Arrays.sort(nodeEdges);
        
        return ((nodeEdges[1] == nodeEdges[numNodes]) && nodeEdges[numNodes] == 1) ? numNodes : 
            count(nodeEdges, nodeEdges[1], noOfArcs) - count(nodeEdges, nodeEdges[numNodes], noOfArcs);
    }

    static int count(int[] arr, int x, int n) {
        int i = first(arr, 0, n-1, x, n);
        return (i == -1) ? -1 : last(arr, i, n-1, x, n) - i + 1;
    }

    static int first(int[] arr, int min, int max, int x, int n) {
        if(max >= min) {
            int middle = (min + max) / 2;
            return ((middle == 0 || x > arr[middle - 1]) && arr[middle] == x) ? middle : 
                (x > arr[middle]) ? first(arr, (middle + 1), max, x, n) : 
                    first(arr, min, (middle - 1), x, n);
        } else
            return -1;
    }

    static int last(int[] arr, int min, int max, int x, int n) {
        if(max >= min) {
            int middle = (min + max) / 2;
            return ((middle == n - 1 || x < arr[middle + 1]) && arr[middle] == x ) ? middle :
                (x < arr[middle]) ? last(arr, min, (middle - 1), x, n) :
                    last(arr, (middle + 1), max, x, n);
        } else
            return -1;
    }
  
}