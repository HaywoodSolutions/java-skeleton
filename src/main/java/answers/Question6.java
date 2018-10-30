package answers;

import java.util.LinkedList;
import java.util.Arrays;

public class Question6 {
  
    public static int shortestServerRoute(int numServers, int targetServer, int[][] times) {
        int noServers = numServers;
        int node = 0;
        int[] result = new int[noServers];
        
        for (int i=1; i<noServers; i++) {
            int dijk_node = 0;
            int minTime = -1;
            for (int j=0; j<noServers; j++)
                if (times[node][j] != -1 && node != j)
                    if (minTime == -1) {
                        minTime = times[node][j];
                        dijk_node = j;
                    } else if (minTime > times[node][j]) {
                        minTime = times[node][j];
                        dijk_node = j;
                    }
            
            result[dijk_node] = minTime;
            
            if(dijk_node == targetServer)
                break;
                
            times[node][dijk_node] = -1;
            
            for (int j=0; j<noServers; j++)
                if (node != j && times[node][j] != -1)
                    if (minTime + times[dijk_node][j] < times[node][j])
                        times[node][j] = minTime + times[dijk_node][j];
        }
        return result[targetServer];
    }
  
}
