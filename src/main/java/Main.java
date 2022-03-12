
import java.util.Map;
import java.util.Objects;


public class Main {

    static boolean withdraw(int amount, Map<Integer, Integer> billsFromATM) {
        int result;
        boolean isEmpty = true;
        if (amount > 0) {
            int quantity = 0;
            for (Integer nominal : billsFromATM.keySet()) {
                quantity = billsFromATM.get(nominal);
                int diff = amount - nominal;
                if (diff >= 0) {
                    while (quantity > 0 && amount > 0 && isEmpty) {
                        result = amount - nominal;
                        quantity--;
                        billsFromATM.replace(nominal, quantity);
                        amount = result;
                        isEmpty = withdraw(amount, billsFromATM);
                    }
                    if (isEmpty) {
                        billsFromATM.entrySet().stream()
                                .filter(x -> Objects.equals(x.getKey(), nominal))
                                .map(billsFromATM::remove);
                    }
                }
            }
        }
        System.out.println(billsFromATM);
        return false;
    }

    public static void main(String[] args) {

        ATMState atmState =  new ATMState();
        atmState.setBillsInATM();
        Map<Integer, Integer> bills = atmState.getBillsInATM();
        int toWithdraw = 380;
        withdraw(toWithdraw, bills);
    }
}
