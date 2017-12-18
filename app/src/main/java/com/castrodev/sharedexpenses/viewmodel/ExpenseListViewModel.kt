package com.castrodev.sharedexpenses.viewmodel

import android.arch.lifecycle.ViewModel
import com.castrodev.sharedexpenses.data.Expense
import com.castrodev.sharedexpenses.data.ExpenseDao

class ExpenseListViewModel(private val expenseDao: ExpenseDao) : ViewModel() {

    fun getExpenses(): List<Expense> {
        return expenseDao.getAllExpenses()

    }
}