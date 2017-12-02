package com.castrodev.sharedexpenses.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.castrodev.sharedexpenses.R

class ExpensesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_expenses, container, false)
        val args = arguments
        (rootView.findViewById<TextView>(android.R.id.text1)).text = getString(R.string.dummy_section_text, args.getInt(ARG_SECTION_NUMBER))
        return rootView
    }

    companion object {

        val ARG_SECTION_NUMBER = "section_number"
    }
}