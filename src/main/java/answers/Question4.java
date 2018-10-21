package answers;

public class Question4 {

	public static int selectionFailedTradedesks(String[][] rows, int numberMachines) {
        int total = 200000000;
        int subTotal = 0;
        for (int row = 0; row < rows.length; row++)
            for (int sub = 0; sub < rows[row].length - numberMachines; sub++) {
                subloop :
                for (int m = sub; m < sub + numberMachines; m++) {
                    if (rows[row][m] != "X") {
                        subTotal += Integer.parseInt(rows[row][m]);
                    } else {
                        subTotal = -1;
                        break subloop;
                    }
                }       
                if (subTotal < total && subTotal != -1) 
                    total = subTotal;
                subTotal = 0;
            }
        return total != 200000000 ? total : 0;
    }
}