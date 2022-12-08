package com.boydlever.mvcdemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.boydlever.mvcdemo.models.Expense;
import com.boydlever.mvcdemo.services.ExpenseService;

@Controller
public class HomeController {
	//1
	@Autowired
	private ExpenseService expenseService;
	//2
	@GetMapping("/expenses")
	public String dashboardPage(Model model, @ModelAttribute("newExpense") Expense expense ) {
		List<Expense>allExpenses = expenseService.allExpenses();
		model.addAttribute("expenseList", allExpenses);
		return "main.jsp";
	}
	//Heidi's recommendation for adding validations to Add Expense
	@PostMapping("/expenses")
	public String processMainCreateForm(
			@Valid @ModelAttribute("newExpense") Expense expense,
			BindingResult result, Model model){
				if (result.hasErrors()) {
					//if validation fails
					List<Expense>allExpenses = expenseService.allExpenses();
					model.addAttribute("expenseList", allExpenses);
					return "main.jsp";
				}else {
					expenseService.addExpense(expense);
				}
				return "redirect:/expenses";
			}
	//3
	@GetMapping("/expenses/{id}")
	public String oneExpense(@PathVariable("id")Long id, Model model) {
		Expense expense = expenseService.oneExpense(id);
		model.addAttribute("expense", expense);
		return "oneExpense.jsp";
	}
	//4. CREATE (DATA BINDING)
	//Display the form
	@GetMapping("/expenses/new")
	public String displayNewExpenseForm(@ModelAttribute("newExpense") Expense expense) {
	return "newExpenseForm.jsp";
	}
	
	
	//5. Process the form
	@PostMapping("/expenses/new")
	public String processCreateForm(
			@Valid @ModelAttribute("newExpense") Expense expense,
			BindingResult result){
				if (result.hasErrors()) {
					//if validation fails
					return "newExpenseForm.jsp";
				}else {
					expenseService.addExpense(expense);
				}
				return "redirect:/expenses";
			}
	//6. EDIT form
	//Display the form
	@GetMapping("/expenses/edit/{id}")
	public String displayUpdateForm(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.oneExpense(id);
		model.addAttribute("expense", expense);
		return "editExpenseForm.jsp";
	}
	
	//7. process the form
	@PutMapping("/expenses/edit/{id}")
	public String processUpdate(@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {
		System.out.println("hello");
		if(result.hasErrors()) {
			return "editExpenseForm.jsp";
		}else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses/{id}";
		}
	}
	//8. DELETE --> localhost:8080/expenses/delete/3 --> security concern
	@DeleteMapping("/expenses/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
		}
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("expenseList", expenseService.allExpenses());
		model.addAttribute("newExpense", new Expense());
		return "dashboard.jsp";
	}
	
	@PostMapping("/process")
	public String processMainForm(
			@Valid @ModelAttribute("newExpense") Expense expense,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "main.jsp"; //notice we are rightly breaking a cardinal rule
		} else {
			expenseService.addExpense(expense);
			return "redirect:/";
		}
	}
	
	@GetMapping("/testing")
	public String testingQueries(Model model) {
		List<Expense> expenseList = expenseService.allExpenses();
		model.addAttribute("expenseList", expenseList);
		return "dashboard.jsp";
	}
	
}
	//CREATE (JUST FOR REFERENCE) DO NOT USE - RequestParam
	//Display the form
//	@GetMapping("/expenses2/new")
//	public String displayOldCreateForm() {
//		return "newExpenseToAmend.jsp";
//	}
	
	//Process the new expense form
//	@PostMapping("/expenses2/new")
//	public String processOldCreateForm(
//			@RequestParam("expenseName") String expenseName,
//			@RequestParam("amount") Integer amount,
//			@RequestParam("vendor") String vendor,
//			@RequestParam("description") String description
//			) {
//		Expense newExpense = new Expense(); //instantiate a expense
//		newExpense.setExpenseName(expenseName);
//		newExpense.setAmount(amount);
//		newExpense.setVendor(vendor);
//		newExpense.setDescription(description);
//		
//		expenseService.addExpense(newExpense);
//		
//		return "redirect:/expenses";
//	}
	

