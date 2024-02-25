package rest.services;

import domainModel.Groups.Expense;
import domainModel.Groups.Groups;
import memoryStore.GroupInMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    GroupInMemoryStore groupInMemoryStore;

    @Autowired
    ExpenseService expenseService;


    public void createGroup(Groups groups) {
        groupInMemoryStore.addGroup(groups);
    }

    public void addExpenseToGroup(String groupId, Expense expense) {
        Groups groups = groupInMemoryStore.getGroup(groupId);
        expense.setSplitBetween(groups.getMembers());
        expenseService.calculateAndUpdateExpense(expense);
    }
}
