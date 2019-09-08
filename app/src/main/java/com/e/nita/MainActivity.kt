package com.e.nita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.e.nita.Home.Homefragment
import com.e.nita.Home.Searchfragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    private lateinit var mPager: ViewPager2
    val MUM_PAGES = 3
    var name_tab = arrayOf("Home, Search")

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContentView(R.layout.activity_main)

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter

        val tabLayoutMediator = TabLayoutMediator(tab, viewPager, true,
            TabLayoutMediator.OnConfigureTabCallback { tab, position ->

            })
        tabLayoutMediator.attach();

        for (i in 0..2) {
            tab.getTabAt(i)!!.setText(name_tab.get(i));
        }
    }


    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = mPager.currentItem - 1
        }
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {


        override fun createFragment(position: Int): Fragment {
            if (position == 0) {
                return Homefragment()
            } else {
                return Searchfragment()
            }

        }
        override fun getItemCount(): Int = 3

    }
}
