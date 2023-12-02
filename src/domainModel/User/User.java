package domainModel.User;


import java.util.List;

public class User {
    private String userId;
    private String name;
    private List<User> friends;
    private BalanceSheet balanceSheet;

    private BalanceSheet getBalanceSheet(){
        return this.balanceSheet;
    }

    private String getName(){
        return this.name;
    }

    private List<User> getFriends(){
        return this.friends;
    }

    private void setBalanceSheet(BalanceSheet balanceSheet){
        this.balanceSheet = balanceSheet;
    }
}
