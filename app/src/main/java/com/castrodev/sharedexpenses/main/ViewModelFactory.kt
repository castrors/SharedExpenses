package com.castrodev.sharedexpenses.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.castrodev.sharedexpenses.data.ExpenseDao
import com.castrodev.sharedexpenses.viewmodel.ExpenseFormViewModel
import com.castrodev.sharedexpenses.viewmodel.ExpenseListViewModel

class ViewModelFactory(private val dataSource: ExpenseDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExpenseFormViewModel::class.java)) {
            return ExpenseFormViewModel(dataSource) as T
        } else if (modelClass.isAssignableFrom(ExpenseListViewModel::class.java)) {
            return ExpenseListViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}