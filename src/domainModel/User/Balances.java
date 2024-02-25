package domainModel.User;

public class Balances {
    Double totalAmount;
    User user;

    public Balances() {}

    public Balances(Double totalAmount, User user) {
        this.totalAmount = totalAmount;
        this.user = user;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
