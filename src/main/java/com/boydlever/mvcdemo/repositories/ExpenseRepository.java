package com.boydlever.mvcdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boydlever.mvcdemo.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense,Long> {
	//the return type is Iterable
	//CrudRepository - save(), deleteById(..), don't need to specify return type
	List<Expense> findAll(); //this is all we need for this course
	List<Expense> findByVendor(String keyword);
	List<Expense> findByExpenseNameContaining(String keyword);
	List<Expense> findByExpenseNameContainingOrderByAmount(String keyword);
	List<Expense> findAllByOrderByExpenseName();
	List<Expense> findAllByOrderByAmountDesc();
}
