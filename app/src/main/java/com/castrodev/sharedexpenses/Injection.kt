package com.castrodev.sharedexpenses

import android.content.Context
import com.castrodev.sharedexpenses.persistence.ExpenseDao
import com.castrodev.sharedexpenses.persistence.SharedExpensesDatabase
import com.castrodev.sharedexpenses.ui.ViewModelFactory

object Injection {

    fun provideExpenseDataSource(context: Context): ExpenseDao {
        val  database = SharedExpensesDatabase.getInstance(context)
        return database.expenseDao()
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val dataSource = provideExpenseDataSource(context)
        return ViewModelFactory(dataSource)
    }
}