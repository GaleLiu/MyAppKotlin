package com.run.quan.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.run.quan.R
import com.run.quan.activity.PicDetailActivity
import com.run.quan.adapter.HomePicAdapter
import com.run.quan.http.GetRequest_Interface
import com.run.quan.http.bean.PicBean
import com.run.quan.http.RetrofitHelper.Companion.getInstance
import com.run.quan.http.bean.PicDetailBean
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @Description 这里用一句话描述
 * @Author GaleLiu
 * @Time 2021/05/21
 */
class PicFragment : Fragment(), HomePicAdapter.OnItemClick {

    private var rv_pic:RecyclerView ?= null
    private var picAdapter:HomePicAdapter?=null

    private var isFirst:Boolean=true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pic, null)
        initView(view)
        return view
    }

    override fun onResume() {
        super.onResume()
        Log.d("sss",">>>  onResume  >>>")

        if(!isFirst)return
        isFirst = false

        val request = getInstance().helperGet(GetRequest_Interface::class.java)

        val call = request.getSearchCall()
        call.enqueue(object:Callback<PicBean>{
            override fun onResponse(call: Call<PicBean>, response: Response<PicBean>) {
                Log.i("sss",">>>>>>>  getPicUrl  >>>>>>>>  " + response.body()?.data?.get(0)?.short_url)

                response.body()?.data?.let { picAdapter?.setDatas(it)}
            }

            override fun onFailure(call: Call<PicBean>, t: Throwable) {
                Log.e("sss","-- onFailure-- -->>  " + t.message)
            }
        })
    }

    private fun initView(view: View?) {
        rv_pic = view?.findViewById(R.id.rv_pic)
//        val myLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
//        myLayoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
//        rv_pic?.layoutManager = myLayoutManager

        rv_pic?.layoutManager = GridLayoutManager(context, 2)

        picAdapter = HomePicAdapter(arrayListOf())
        picAdapter?.setOnItemClick(this)
        rv_pic?.adapter = picAdapter
    }

    override fun itemClick(mPic:PicBean.PicData, position: Int) {
        var intent = Intent(activity, PicDetailActivity::class.java)
        intent.putExtra("picId", mPic.id)
        startActivity(intent)
    }
}