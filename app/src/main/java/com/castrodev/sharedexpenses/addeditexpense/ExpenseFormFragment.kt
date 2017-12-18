package com.castrodev.sharedexpenses.addeditexpense

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.castrodev.sharedexpenses.Injection
import com.castrodev.sharedexpenses.R
import com.castrodev.sharedexpenses.main.ViewModelFactory
import com.castrodev.sharedexpenses.data.Expense
import com.castrodev.sharedexpenses.viewmodel.ExpenseFormViewModel

class ExpenseFormFragment : DialogFragment() {

    lateinit var expense: Expense
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: ExpenseFormViewModel

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        viewModelFactory = Injection.provideViewModelFactory(getContext())
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ExpenseFormViewModel::class.java)
//        expense = arguments?.getSerializable(EXTRA_EXPENSE) as Expense ?: Expense()
        expense = Expense()
    }

    private var titleLayout: TextInputLayout? = null

    private var contactLayout: TextInputLayout? = null

    private var expensesLayout: TextInputLayout? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_expense_form, container, false)

        titleLayout = rootView.findViewById<TextInputLayout>(R.id.title_layout)
        contactLayout = rootView.findViewById<TextInputLayout>(R.id.contact_layout)
        expensesLayout = rootView.findViewById<TextInputLayout>(R.id.expenses_layout)
        val cancelAction = rootView.findViewById<Button>(R.id.cancel)
        val saveAction = rootView.findViewById<Button>(R.id.save)

        saveAction.setOnClickListener {
            saveExpense()
        }

        cancelAction.setOnClickListener {
            dialog.dismiss()
        }

        return rootView
    }

    private fun saveExpense() {
        expense.title = titleLayout?.editText?.text.toString()
        expense.contact = contactLayout?.editText?.text.toString()
        expense.value = expensesLayout?.editText?.text.toString().toDouble()
        viewModel.saveExpense(expense)
    }

    companion object {
        val EXTRA_EXPENSE = "expense"

        fun newInstance(expense: Expense): ExpenseFormFragment {
            val args = Bundle()
            args.putSerializable(EXTRA_EXPENSE, expense)

            val f = ExpenseFormFragment()
            f.arguments = args
            return f
        }
    }
}