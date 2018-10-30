package answers;

public class Question4 {
    public static int selectionFailedTradedesks(String[][] rows, int numberMachines) {
        int time = Integer.MAX_VALUE;

        if (numberMachines == 1) {
            for (int r = 0; r < rows.length; r++)
                for (int i = 0; i < rows[r].length; i++)
                    if (!rows[r][i].equals("X"))
                        time = Math.min(time, Integer.valueOf(rows[r][i]));
            return time;
        }
        
        for (int r = 0; r < rows.length; r++) {
            int index = 0;
            int sum = 0;
            int count = 0;

            breakFor: {
                for (int i = 0; i < rows[r].length; i++)
                    if (rows[r][i].equals("X")) {
                        if ((rows[r].length - (i+1)) < numberMachines)
                            break breakFor;
                        
                        sum = 0;
                        index = 0;
                        count = 0;
                    } else if (count == 0) {
                        sum = Integer.valueOf(rows[r][i]);
                        index = i;
                        count++;
                    } else if (count + 1 == numberMachines) {
                        sum += Integer.valueOf(rows[r][i]);
                        time = Math.min(time, sum);
                        sum -= Integer.valueOf(rows[r][index]);
                        index++;
                    } else {
                        sum += Integer.valueOf(rows[r][i]);
                        count++;
                    }
            }
        }
        
        if (time == Integer.MAX_VALUE)
            time = 0;
            
        return time;
    }
}