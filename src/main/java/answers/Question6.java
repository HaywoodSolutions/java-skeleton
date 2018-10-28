package answers;

import java.util.LinkedList;
import java.util.Arrays;

public class Question6 {
    public static int shortestServerRoute(int numServers, int targetServer, int[][] times) {
        int[] pathsLengths = shortestReach(numServers, times);
        if (pathsLengths[targetServer] >= 0)
            return pathsLengths[targetServer];
        return -1;
    }
    
    public static int[] shortestReach(int numServers, int[][] times) {
        int startID = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(startID);
        
        int[] distances = new int[numServers];
        Arrays.fill(distances, -1);
        distances[startID] = 0;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighborID = 0; neighborID < times[node].length; neighborID++) {
                int distance = distances[node] + times[node][neighborID];
                if (distances[neighborID] == -1 || distance < distances[neighborID]) {
                    distances[neighborID] = distances[node] + times[node][neighborID];
                    queue.add(neighborID);
                }
            }
        }
        
        return distances;
    }
}
