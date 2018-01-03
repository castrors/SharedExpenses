package com.castrodev.sharedexpenses.expenses

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.castrodev.sharedexpenses.Injection
import com.castrodev.sharedexpenses.R
import com.castrodev.sharedexpenses.addeditexpense.ExpenseFormFragment
import com.castrodev.sharedexpenses.data.Expense
import com.castrodev.sharedexpenses.main.ViewModelFactory
import com.castrodev.sharedexpenses.viewmodel.ExpenseListViewModel


class ExpenseListFragment : Fragment(), ExpensesContract.View {

    override lateinit var presenter: ExpensesContract.Presenter
    override var isActive: Boolean = false
        get() = isAdded


    lateinit var expenses: List<Expense>
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: ExpenseListViewModel
    private lateinit var listAdapter: ExpenseAdapter

    private lateinit var noExpenseFound: TextView
    private lateinit var expenseList: RecyclerView

    internal var itemListener: ExpenseItemListener = object : ExpenseItemListener {
        override fun onOpenExpenseDetailClick(openExpenseDetails: Expense) {
            presenter.openExpenseDetails(openExpenseDetails)
        }

        override fun onActivateExpenseClick(activeExpense: Expense) {
            presenter.activateExpense(activeExpense)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        viewModelFactory = Injection.provideViewModelFactory(getContext())
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ExpenseListViewModel::class.java)
        listAdapter = ExpenseAdapter(ArrayList(0), context, itemListener)
        presenter = ExpensesPresenter(viewModel, this)
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_expense_list, container, false)

        expenseList = rootView.findViewById<RecyclerView>(R.id.expense_list)
        noExpenseFound = rootView.findViewById<TextView>(R.id.no_expense_found)

        rootView.findViewById<FloatingActionButton>(R.id.add_expense).apply {
            setOnClickListener {
                showExpenseForm()
            }
        }

        rootView.findViewById<SwipeRefreshLayout>(R.id.refresh_layout).apply {
            setOnRefreshListener { presenter.loadExpenses(false) }
        }

        expenseList.adapter = listAdapter

        return rootView
    }

    private fun showExpenseForm() {
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = fragmentManager.findFragmentByTag("dialog")
        if (fragment != null) {
            fragmentTransaction.remove(fragment)
        }
        fragmentTransaction.addToBackStack(null)

        val expenseFormFragment = ExpenseFormFragment.newInstance(Expense())
        expenseFormFragment.show(fragmentTransaction, "dialog")
    }

    override fun setLoadingIndicator(active: Boolean) {
        val root = view ?: return
        with(root.findViewById<SwipeRefreshLayout>(R.id.refresh_layout)) {
            // Make sure setRefreshing() is called after the layout is done with everything else.
            post { isRefreshing = active }
        }
    }

    override fun showExpenses(expenses: List<Expense>) {
        listAdapter.expenses = expenses
        expenseList.visibility = View.VISIBLE
        noExpenseFound.visibility = View.GONE
    }

    override fun showAddExpense() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showExpenseDetailsUi(expenseId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoadingExpensesError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNoExpenses() {
        expenseList.visibility = View.GONE
        noExpenseFound.visibility = View.VISIBLE
    }

    override fun showActiveFilterLabel() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    interface ExpenseItemListener {

        fun onOpenExpenseDetailClick(openExpenseDetails: Expense)

        fun onActivateExpenseClick(activeExpense: Expense)

    }
}