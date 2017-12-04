package com.castrodev.sharedexpenses.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.castrodev.sharedexpenses.R
import com.castrodev.sharedexpenses.util.bindView


class MainActivity : AppCompatActivity() {

    private var adapter: CustomFragmentStatePagerAdapter? = null

    private val bottomNavigationView: BottomNavigationView by bindView(R.id.bottom_navigation)

    var pager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CustomFragmentStatePagerAdapter(supportFragmentManager)
        pager = findViewById(R.id.pager)
        pager?.adapter = adapter

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            pager?.currentItem = when (item.itemId) {
                R.id.action_favorites -> 0
                R.id.action_schedules -> 1
                R.id.action_music -> 2
                else -> throw RuntimeException("Unexpected index")
            }
            item.isChecked = true
            false
        }

    }
}
