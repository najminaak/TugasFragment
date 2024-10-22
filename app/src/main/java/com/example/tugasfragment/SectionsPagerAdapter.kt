package com.example.tugasfragment

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 2  // Two tabs: Register and Login
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LoginFragment()  // First tab: Register
            1 -> RegisterFragment()     // Second tab: Login
            else -> throw IllegalStateException("Invalid fragment position")
        }
    }
}
