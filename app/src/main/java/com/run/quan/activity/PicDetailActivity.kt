package com.run.quan.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.run.quan.R
import com.run.quan.base.BaseActivity
import com.run.quan.http.GetRequest_Interface
import com.run.quan.http.RetrofitHelper
import com.run.quan.http.bean.PicDetailBean
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @Description 这里用一句话描述
 * @Author GaleLiu
 * @Time 2021/05/22
 */
class PicDetailActivity:BaseActivity() {

    var img:ImageView?=null
    var btn_like:ImageView?=null

    var picId:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        img = findViewById(R.id.img)
        btn_like = findViewById(R.id.btn_like)

        picId = intent.getStringExtra("picId")
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_pic_detail
    }

    override fun onResume() {
        super.onResume()

        val request = RetrofitHelper.getInstance().helperGet(GetRequest_Interface::class.java)

        val call = picId?.let { request.getPicDetailCall(it) }
        if (call != null) {
            call.enqueue(object : Callback<PicDetailBean> {
                override fun onResponse(call: Call<PicDetailBean>, response: Response<PicDetailBean>) {
                    img?.let {
                        Glide.with(this@PicDetailActivity).asBitmap()
                            .load(response.body()?.data?.path)
                            .into(it)
                    }
                }

                override fun onFailure(call: Call<PicDetailBean>, t: Throwable) {
                    Log.e("sss","-- onFailure-- -->>  " + t.message)
                }
            })
        }
    }

    fun btnLike(v:View){
//        if(v.id == R.id.btn_like){
//            if(btn_like != null){
//                btn_like.isSelected = !btn_like.isSelected
//            }
//        }
    }
}