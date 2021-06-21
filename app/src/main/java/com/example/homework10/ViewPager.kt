package com.example.homework10

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homework10.fragments.EditDataFragment
import com.example.homework10.fragments.UserDataFragment

class ViewPager(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount() = 2

    private val fragments = listOf(
        UserDataFragment(),
        EditDataFragment()
    )

    override fun createFragment(position: Int): Fragment = fragments[position]

}