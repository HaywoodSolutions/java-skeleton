package answers;

import java.lang.Math;
import java.util.ArrayList;

public class Question2 {

	public static int equallyBalancedCashFlow(int[] cashflowIn, int[] cashflowOut) {
        ArrayList<Integer> cashIn = subArraySums(cashflowIn);
        ArrayList<Integer> cashOut = subArraySums(cashflowOut);
        int cashInNo = cashIn.size();
        int cashOutNo = cashOut.size();

        int leastDiff = Math.min(cashIn.get(1), cashOut.get(1));

        int diff;
        for (int i = 1; i < cashInNo; i++)
            for (int j = 1; j < cashOutNo; j++) {
                diff = Math.abs(cashIn.get(i) - cashOut.get(j));
                if (diff < leastDiff)
                    leastDiff = diff;
            }

        return leastDiff;
    }
    
    public static ArrayList<Integer> subArraySums(int[] cashFlow) {        
        int cashFlowNo = cashFlow.length;
        int subSumArr[];
        
        int sum = 0;
        for (int value : cashFlow)
            sum += value;

        ArrayList<Integer> sumList = new ArrayList<Integer>();
        int[] list = new int[sum + 1];
        list[0] = 1;

        for (int i = 0; i < cashFlowNo; i++)
            for (int j = sum; j >= cashFlow[i]; j--)
                list[j] += list[j - cashFlow[i]];

        for (int i = 0; i <= sum; i++)
            if (list[i] > 0)
                sumList.add(i);

        return sumList;
    }

}


