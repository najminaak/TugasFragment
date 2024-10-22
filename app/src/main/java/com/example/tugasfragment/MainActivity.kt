package com.example.tugasfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager : ViewPager2 = findViewById(R.id.viewPager)
        viewPager.adapter = sectionsPagerAdapter

        val tabs : TabLayout = findViewById(R.id.tabLayout)
        TabLayoutMediator(tabs, viewPager) {
                tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])}.attach()

        val tabIndex = if (intent.getBooleanExtra("FIRST_RUN", true)) {
            1
        } else {
            intent.getIntExtra("EXTRA_TAB", 0) // Get tab index from intent
        }
        viewPager.setCurrentItem(tabIndex, false)
    }

}
