package com.castrodev.sharedexpenses.ui

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.castrodev.sharedexpenses.Injection
import com.castrodev.sharedexpenses.R
import com.castrodev.sharedexpenses.persistence.Expense
import com.castrodev.sharedexpenses.viewmodel.ExpenseListViewModel

class ExpenseListFragment : Fragment() {

    lateinit var expenses: List<Expense>
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: ExpenseListViewModel

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        viewModelFactory = Injection.provideViewModelFactory(getContext())
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ExpenseListViewModel::class.java)
        expenses = viewModel.getExpenses()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_expense_list, container, false)

        val expenseList = rootView.findViewById<RecyclerView>(R.id.expense_list)
        subscribeUi(expenseList, context)

        return rootView
    }


    private fun subscribeUi(expenseList: RecyclerView, context: Context) {
        expenseList.adapter = ExpenseAdapter(expenses, context)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        expenseList.layoutManager = layoutManager
    }
}