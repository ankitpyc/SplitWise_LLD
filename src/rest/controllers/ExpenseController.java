package rest.controllers;

import domainModel.Groups.Expense;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @PostMapping("/addExpense")
    public void addExpense(@RequestBody Expense expense){

    }

}
