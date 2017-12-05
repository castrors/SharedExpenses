package com.castrodev.sharedexpenses.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.castrodev.sharedexpenses.R
import com.castrodev.sharedexpenses.persistence.Expense
import kotlinx.android.synthetic.main.expense_item.view.*

class ExpenseAdapter(private val expenses: List<Expense>,
                     private val context: Context) : RecyclerView.Adapter<ExpenseAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val expense = expenses[position]
        holder?.bindView(expense)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.expense_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return expenses.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(expense: Expense) {
            val title = itemView.title
            val contact = itemView.contact
            val value = itemView.value

            title.text = expense.title
            contact.text = expense.contact
            value.text = expense.value.toString()
        }


    }
}

