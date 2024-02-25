package domainModel.User;


import domainModel.Groups.Groups;

import java.util.List;

public class User {

    private String userId;
    private String name;
    private List<User> friends;

    private List<String> groups;

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    private BalanceSheet balanceSheet;

    public User(String userId) {
        this.userId = userId;
    }

    public BalanceSheet getBalanceSheet() {
        return this.balanceSheet;
    }

    private void setBalanceSheet(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    private String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<User> getFriends() {
        return this.friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
