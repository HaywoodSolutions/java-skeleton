package answers;

import java.util.LinkedList;
import java.util.Arrays;

public class Question6 {
    public static int shortestServerRoute(int numServers, int targetServer, int[][] times) {
        int startID = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(startID);
        
        int[] distances = new int[numServers];
        Arrays.fill(distances, -1);
        distances[startID] = 0;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighborID = 0; neighborID < times[node].length; neighborID++) {
                if (distances[neighborID] == -1 || distances[node] + times[node][neighborID] < distances[neighborID]) {
                    distances[neighborID] = distances[node] + times[node][neighborID];
                    queue.add(neighborID);
                }
            }
        }
        
        return distances[targetServer];
    }
}
