import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ATMState {

    Map<Integer, Integer> billsInATM = new TreeMap<>(Collections.reverseOrder());

    int balance;

    public Map<Integer, Integer> getBillsInATM() {
        return billsInATM;
    }

    public void setBillsInATM(Map<Integer, Integer> billsInATM) {
        this.billsInATM = billsInATM;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public void setBillsInATM() {
        this.billsInATM.put(5, 20);
        this.billsInATM.put(10, 30);
        this.billsInATM.put(20, 30);
        this.billsInATM.put(50, 10);
    }
}
