package com.castrodev.sharedexpenses.ui

import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.castrodev.sharedexpenses.R
import com.castrodev.sharedexpenses.persistence.Expense
import com.castrodev.sharedexpenses.persistence.SharedExpensesDatabase

class NewExpenseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_new_expense, container, false)

        val titleLayout = rootView.findViewById<TextInputLayout>(R.id.title_layout)
        val contactLayout = rootView.findViewById<TextInputLayout>(R.id.contact_layout)
        val expensesLayout = rootView.findViewById<TextInputLayout>(R.id.expenses_layout)
        val clearFormButton = rootView.findViewById<Button>(R.id.clear_form)
        val saveFormButton = rootView.findViewById<Button>(R.id.save)

        saveFormButton.setOnClickListener {
            val database = SharedExpensesDatabase.getInstance(activity)
            val dao = database.expenseDao()
            val newExpense = Expense(title = titleLayout.editText?.text.toString(),
                    contact = contactLayout.editText?.text.toString(),
                    value = expensesLayout.editText?.text.toString().toDouble())
            dao.insertExpense(newExpense)
        }

        clearFormButton.setOnClickListener {
            val database = SharedExpensesDatabase.getInstance(activity)
            val dao = database.expenseDao()
            val expenses = dao.getAllExpenses()
        }


        return rootView
    }
}