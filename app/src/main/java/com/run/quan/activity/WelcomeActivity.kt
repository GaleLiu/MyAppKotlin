package com.run.quan.activity.home

import android.content.Intent
import android.os.Handler
import com.run.quan.R
import com.run.quan.activity.HomeActivity
import com.run.quan.base.BaseActivity


/**
 * @Description 这里用一句话描述
 * @Author GaleLiu
 * @Time 2021/05/17
 */
class WelcomeActivity : BaseActivity(){

    override fun getLayoutId():Int {
        return R.layout.activity_welcome
    }

    override fun onResume() {
        super.onResume()

        Handler().postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        },3000)
    }
}