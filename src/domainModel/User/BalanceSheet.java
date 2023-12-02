package domainModel.User;

import java.util.List;

public class BalanceSheet {
    private Double totalDue;
    private User user;
    private Double totalOwed;
    private List<Balances> balances;

    public Double getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(Double totalDue) {
        this.totalDue = totalDue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotalOwed() {
        return totalOwed;
    }

    public void setTotalOwed(Double totalOwed) {
        this.totalOwed = totalOwed;
    }

    public List<Balances> getBalances() {
        return balances;
    }

    public void setBalances(List<Balances> balances) {
        this.balances = balances;
    }
}
