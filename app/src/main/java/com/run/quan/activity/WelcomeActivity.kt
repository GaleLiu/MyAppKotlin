package com.run.quan.activity.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.run.quan.R
import com.run.quan.activity.HomeActivity

/**
 * @Description 这里用一句话描述
 * @Author GaleLiu
 * @Time 2021/05/17
 */
class WelcomeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_welcome)
    }

    override fun onResume() {
        super.onResume()

        Handler().postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        },3000)
    }

    fun fullScreen(enable:Boolean){
        val lp:WindowManager.LayoutParams = window.attributes
        if(enable){//显示
            lp.flags = WindowManager.LayoutParams.FLAG_FULLSCREEN
        }else{//隐藏
            lp.flags = WindowManager.LayoutParams.FLAG_FULLSCREEN
        }

        window.attributes = lp
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)


    }
}