package com.example.homework10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerFragmentAdapter: ViewPager

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerFragmentAdapter = ViewPager(this)

        viewPager = findViewById(R.id.viewpager)
        tabLayout = findViewById(R.id.tabLayout)

        viewPager.adapter = viewPagerFragmentAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = if (position == 0) "User data" else "Edit user data"
        }.attach()

    }

}