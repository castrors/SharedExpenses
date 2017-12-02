package com.castrodev.sharedexpenses.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.castrodev.sharedexpenses.R


class MainActivity : AppCompatActivity() {

    private var adapter: CustomFragmentStatePagerAdapter? = null

    var pager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CustomFragmentStatePagerAdapter(supportFragmentManager)
        pager = findViewById(R.id.pager)
        pager?.adapter = adapter

        val bottomNavigationView = findViewById<View>(R.id.bottom_navigation) as BottomNavigationView

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_favorites -> {
                    pager?.currentItem = 0
                }
                R.id.action_schedules -> {
                    pager?.currentItem = 1
                }
                R.id.action_music -> {
                    pager?.currentItem = 2
                }
            }
            item.isChecked = true
            false
        }

    }
}
