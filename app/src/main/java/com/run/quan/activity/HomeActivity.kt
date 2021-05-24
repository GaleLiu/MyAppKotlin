package com.run.quan.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import com.run.quan.R
import com.run.quan.adapter.HomeTabAdapter
import com.run.quan.base.BaseActivity

/**
 * @Description 这里用一句话描述
 * @Author GaleLiu
 * @Time 2021/05/17
 */
class HomeActivity : BaseActivity(), OnTabSelectedListener {

    private var tabs:TabLayout? = null
    private var vp2:ViewPager2? = null

    private val tabNames = arrayOf("HOME","PIC","USER")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    private fun init() {
        tabs = findViewById(R.id.tabs)
        vp2 = findViewById(R.id.vp2)

        vp2?.adapter = HomeTabAdapter(this, tabNames.size)

        TabLayoutMediator(tabs!!, vp2!!, true) { tab, position -> tab.text = tabNames[position] }.attach()

        tabs?.addOnTabSelectedListener(this)
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

}