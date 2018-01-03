package com.castrodev.sharedexpenses.expenses

import com.castrodev.sharedexpenses.BasePresenter
import com.castrodev.sharedexpenses.BaseView
import com.castrodev.sharedexpenses.data.Expense

interface ExpensesContract {

    interface View : BaseView<Presenter> {

        var isActive: Boolean

        fun setLoadingIndicator(active: Boolean)

        fun showExpenses(expenses: List<Expense>)

        fun showAddExpense()

        fun showExpenseDetailsUi(expenseId: String)

        fun showLoadingExpensesError()

        fun showNoExpenses()

        fun showActiveFilterLabel()
    }

    interface Presenter : BasePresenter {

        fun result(requestCode: Int, resultCode: Int)

        fun loadExpenses(forceUpdate: Boolean)

        fun loadExpenses(forceUpdate: Boolean, showLoadingUI: Boolean)

        fun addNewExpense()

        fun openExpenseDetails(openExpenseDetails: Expense)

        fun activateExpense(activeExpense: Expense)

        fun clearCompletedExpenses()
    }
}