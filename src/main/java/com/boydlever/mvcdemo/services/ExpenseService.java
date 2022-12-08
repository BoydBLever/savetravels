package com.boydlever.mvcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.boydlever.mvcdemo.models.Expense;
import com.boydlever.mvcdemo.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	//option 1.
	//instantiate repository
	private final ExpenseRepository expenseRepo;
	
	//option 2.
	//@Autowired
	//private ExpenseRepository expenseRepo;
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	//1. get all expenses
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	//2. create expense
	public Expense addExpense(Expense newExpense) {
		return expenseRepo.save(newExpense);
		//save automatically does the insert for us
	}
	//3. find one expense
	public Expense oneExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		}else {
			return null;
		}
	}
	//4. update 
	public Expense updateExpense(Expense foundExpense) {
		return expenseRepo.save(foundExpense);
	}
	//5. delete
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
	
	public List<Expense> testQuery(String keyword){
		return expenseRepo.findByVendor(keyword);
	}
}
