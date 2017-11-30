package com.castrodev.sharedexpenses

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class CustomFragmentStatePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(i: Int): Fragment {
        val fragment = ExpensesFragment()
        val args = Bundle()
        args.putInt(ExpensesFragment.ARG_SECTION_NUMBER, i + 1)
        fragment.arguments = args
        return fragment
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "Section " + (position + 1)
    }
}
