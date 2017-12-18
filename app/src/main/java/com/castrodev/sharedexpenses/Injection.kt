package com.castrodev.sharedexpenses

import android.content.Context
import com.castrodev.sharedexpenses.data.ExpenseDao
import com.castrodev.sharedexpenses.data.SharedExpensesDatabase
import com.castrodev.sharedexpenses.main.ViewModelFactory

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