package domainModel;

import domainModel.User.User;

import java.util.Map;

public class ExpenseData {
    User userPaidBy;
    Map<String,Double> userBalances;

    public ExpenseData(){}
    public ExpenseData(User userpaidBy, Map<String, Double> userBalances) {
        this.userPaidBy = userpaidBy;
        this.userBalances = userBalances;
    }

    public User getUserpaidBy() {
        return userPaidBy;
    }

    public void setUserpaidBy(User userpaidBy) {
        this.userPaidBy = userpaidBy;
    }

    public Map<String, Double> getUserBalances() {
        return userBalances;
    }

    public void setUserBalances(Map<String, Double> userBalances) {
        this.userBalances = userBalances;
    }
}
