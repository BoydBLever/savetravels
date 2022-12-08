package com.boydlever.mvcdemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boydlever.mvcdemo.models.Expense;
import com.boydlever.mvcdemo.services.ExpenseService;

@RestController
@RequestMapping("/api")
public class APIController {
	
	private final ExpenseService expenseService;

	public APIController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	// route to get all expenses
	@GetMapping("/expenses")
	public List<Expense>getAllExpenses(){
		return expenseService.allExpenses();
	}
	
	// route to create expenses
	@PostMapping("/expenses")
	public Expense createExpense(
		@RequestParam("expenseName") String expenseName,
		@RequestParam("vendor") String vendor,
		@RequestParam("amount") Integer amount,
		@RequestParam("description") String description
		) {
		System.out.println(amount);
		Expense newExpense = new Expense(expenseName, vendor, amount, description);
		return expenseService.addExpense(newExpense);
	}
	// get one expense
	@GetMapping("/expenses/{id}")
	public Expense getOneExpense(@PathVariable("id")Long id) {
		return expenseService.oneExpense(id);
	}
	// update  -- findOne & create
	@PutMapping("/expenses/{id}")
	public Expense editExpenseProcess(
		@PathVariable("id")Long id,
		@RequestParam("expenseName") String expenseName,
		@RequestParam("vendor") String vendor,
		@RequestParam("amount") Integer amount,
		@RequestParam("description") String description
		){
		Expense foundExpense = expenseService.oneExpense(id);
		foundExpense.setExpenseName(expenseName);
		foundExpense.setDescription(description);
		foundExpense.setVendor(vendor);
		foundExpense.setAmount(amount);
		return expenseService.updateExpense(foundExpense);
	}
	@DeleteMapping("/expenses/{id}")
	public void deleteExpense(@PathVariable("id")Long id) {
		expenseService.deleteExpense(id);
	}
}
