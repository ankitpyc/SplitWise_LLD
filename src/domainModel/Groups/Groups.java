package domainModel.Groups;

import domainModel.User.User;

import java.util.List;

public class Groups {
    private String groupId;
    private String groupName;
    private List<Expense> expenseList;
    private List<User> members;

    public Groups(String groupId, String groupName, List<Expense> expenseList, List<User> members) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.expenseList = expenseList;
        this.members = members;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

}
