package com.castrodev.sharedexpenses.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.castrodev.sharedexpenses.addeditexpense.ExpenseFormFragment
import com.castrodev.sharedexpenses.expenses.ExpenseListFragment

class CustomFragmentStatePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(index: Int): Fragment {
        return when (index) {
            0 -> ExpenseListFragment()
            1 -> ExpenseFormFragment()
            else ->
                throw RuntimeException("Unexpected index")
        }
    }

    override fun getCount(): Int {
        return 2
    }
}
