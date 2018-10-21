package answers;
import java.util.ArrayList;

public class Question2 {

	public static int equallyBalancedCashFlow(int[] cashflowIn, int[] cashflowOut) {
		ArrayList<Integer> cashInSet= new ArrayList<Integer>();
        ArrayList<Integer> cashOutSet= new ArrayList<Integer>();
        int total=0;
        int diff= 999999999;
        int n = cashflowIn.length;
        // Helped by https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
        for (int i = 0; i < (1 << n); i++) { // loop tough all 2^n subsets one by one 
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) > 0)
                    total += cashflowIn[j];
            cashInSet.add(total);
            total=0;
        }
        total=0;
        n = cashflowOut.length;
        for (int p = 0; p < (1 << n); p++) {  // loop tough all 2^n subsets one by one 
            for (int j = 0; j < n; j++) 
                if ((p & (1 << j)) > 0)
                   total += cashflowOut[j];
            cashOutSet.add(total);
            total=0;
        } 
        cashInSet.remove(0);  //Remove the empty set
        cashOutSet.remove(0); //Remove the empty set
        for(int i=0; i<cashInSet.size(); i++) //loop though all sets
            for(int j=0; j<cashOutSet.size(); j++)
                if(cashInSet.get(i) >= cashOutSet.get(j) && diff > (cashInSet.get(i) - cashOutSet.get(j))) //check if cash in is less than out as that wouldnt make sence plus check if diffrence is smaller than any found before
                    diff = cashInSet.get(i) - cashOutSet.get(j);
        return diff;
	}

}


