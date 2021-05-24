package com.run.quan.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.run.quan.R

/**
 * @Description 这里用一句话描述
 * @Author GaleLiu
 * @Time 2021/05/24
 */
abstract class BaseActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val window = window
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = Color.TRANSPARENT
        }
        setContentView(getLayoutId())
    }


    /**
     * 设置布局
     */
    abstract fun getLayoutId():Int
}