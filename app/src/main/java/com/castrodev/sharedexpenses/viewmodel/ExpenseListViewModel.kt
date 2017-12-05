package com.castrodev.sharedexpenses.viewmodel

import android.arch.lifecycle.ViewModel
import com.castrodev.sharedexpenses.persistence.Expense
import com.castrodev.sharedexpenses.persistence.ExpenseDao

class ExpenseListViewModel(private val expenseDao: ExpenseDao) : ViewModel() {

    fun getExpenses(): List<Expense> {
        return expenseDao.getAllExpenses()

    }
}