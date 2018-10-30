package answers;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Question4 {
    public static int selectionFailedTradedesks(String[][] rows, int numberMachines) {
        int total = Integer.MAX_VALUE;
        int subTotal = 0;
        List<String> array;
        int arraySum;
        for (int row = 0; row < rows.length; row++) {
            array = Arrays.asList(rows[row]);
            int index = 0;
            while (index < array.size() - numberMachines) {
                if (!array.subList(index, index + numberMachines).contains("X")) { // has to index pf -2
                    arraySum = sum(array.subList(index, index + numberMachines));
                    if (arraySum < total)
                        total = arraySum;
                } else index += array.subList(index, index + numberMachines).lastIndexOf("X");
                index++;
            }
        }
        
        return (total == Integer.MAX_VALUE) ? 0 : total;
    }
    
    public static int sum(List<String> list) {
         int sum = 0; 
         for (String i : list)
             sum = sum + Integer.parseInt(i);    
         return sum;
    }
}