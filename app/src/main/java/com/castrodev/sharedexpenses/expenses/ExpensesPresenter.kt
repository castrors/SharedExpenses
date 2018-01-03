package com.castrodev.sharedexpenses.expenses

import com.castrodev.sharedexpenses.data.Expense
import com.castrodev.sharedexpenses.viewmodel.ExpenseListViewModel

class ExpensesPresenter(val viewModel: ExpenseListViewModel, val expensesView: ExpensesContract.View) : ExpensesContract.Presenter {

    private var firstLoad = true

    override fun start() {
        loadExpenses(false)
    }

    override fun result(requestCode: Int, resultCode: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadExpenses(forceUpdate: Boolean) {
        loadExpenses(forceUpdate || firstLoad, true)
        firstLoad = false
    }

    override fun loadExpenses(forceUpdate: Boolean, showLoadingUI: Boolean) {
        if (showLoadingUI) {
            expensesView.setLoadingIndicator(true)
        }

        processExpenses(viewModel.getExpenses())

        if (showLoadingUI) {
            expensesView.setLoadingIndicator(false)
        }
    }

    private fun processExpenses(expenses: List<Expense>) {
        if (expenses.isEmpty()) {
            processEmptyExpenses()
        } else {
            expensesView.showExpenses(expenses)
        }
    }

    private fun processEmptyExpenses() {
        expensesView.showNoExpenses()
    }

    override fun addNewExpense() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openExpenseDetails(openExpenseDetails: Expense) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun activateExpense(activeExpense: Expense) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearCompletedExpenses() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}