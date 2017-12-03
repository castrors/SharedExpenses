package com.castrodev.sharedexpenses.viewmodel

import android.arch.lifecycle.ViewModel
import com.castrodev.sharedexpenses.persistence.Expense
import com.castrodev.sharedexpenses.persistence.ExpenseDao

class ExpenseFormViewModel(private val expenseDao: ExpenseDao) : ViewModel() {

    fun saveExpense(expense: Expense) {
        if (expense.id == 0L) {
            expenseDao.insertExpense(expense)
        } else {
            expenseDao.updateExpense(expense)
        }
    }

    fun deleteExpense(expense: Expense) {
        expenseDao.deleteExpense(expense)
    }
}