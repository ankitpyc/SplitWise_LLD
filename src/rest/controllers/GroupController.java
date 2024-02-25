package rest.controllers;


import domainModel.Groups.Expense;
import domainModel.Groups.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.services.GroupService;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping("/create")
    public ResponseEntity<GroupResponse> createGroup(@RequestBody Groups createGroupRequest) {
        groupService.createGroup(createGroupRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PostMapping("/addExpense")
    public ResponseEntity<GroupResponse> addExpense(String groupId, Expense expense) {
        groupService.addExpenseToGroup(groupId, expense);
        return ResponseEntity.ok().body(null);
    }
}
