package com.run.quan.fragment

import androidx.fragment.app.Fragment
import com.run.quan.R

/**
 * @Description 这里用一句话描述
 * @Author GaleLiu
 * @Time 2021/05/21
 */
class HomeTabFragment {

    companion object {
        fun getInstance(position: Int):Fragment{
            return when(position){
                0 -> HomeFragment(R.layout.fragment_home)

                1 -> PicFragment()

                2 -> HomeFragment(R.layout.fragment_user)

                else -> HomeFragment(R.layout.fragment_home)
            }
        }
    }
}