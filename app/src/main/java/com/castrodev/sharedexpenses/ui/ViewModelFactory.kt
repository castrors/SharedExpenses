package com.castrodev.sharedexpenses.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.castrodev.sharedexpenses.persistence.ExpenseDao
import com.castrodev.sharedexpenses.viewmodel.ExpenseFormViewModel

class ViewModelFactory(private val dataSource: ExpenseDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExpenseFormViewModel::class.java)) {
            return ExpenseFormViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}