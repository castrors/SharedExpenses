package com.castrodev.sharedexpenses.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class CustomFragmentStatePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(index: Int): Fragment {
        return when (index) {
            0 -> ExpenseListFragment()
            1 -> ExpenseFormFragment()
            2 -> ExpenseFormFragment()
            else ->
                throw RuntimeException("Unexpected index")
        }
    }

    override fun getCount(): Int {
        return 3
    }
}
