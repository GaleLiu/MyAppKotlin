package com.run.quan.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.run.quan.R
import com.run.quan.activity.PicDetailActivity
import com.run.quan.adapter.HomePicAdapter
import com.run.quan.http.GetRequest_Interface
import com.run.quan.http.bean.PicBean
import com.run.quan.http.RetrofitHelper.Companion.getInstance
import com.run.quan.http.bean.PicDetailBean
import com.run.quan.widget.DividerGridItemDecoration
import com.run.quan.widget.RecycleViewDivider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @Description 这里用一句话描述
 * @Author GaleLiu
 * @Time 2021/05/21
 */
class PicFragment : Fragment(), HomePicAdapter.OnItemClick {

    private var sr_pic:SwipeRefreshLayout ?= null
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
        sr_pic = view?.findViewById(R.id.sr_pic)
        rv_pic = view?.findViewById(R.id.rv_pic)
        val myLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        myLayoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        rv_pic?.layoutManager = myLayoutManager

        picAdapter = HomePicAdapter(arrayListOf())
        picAdapter?.setOnItemClick(this)

        sr_pic?.setColorSchemeResources(R.color.design_default_color_primary,R.color.design_default_color_secondary,R.color.design_default_color_error)
        sr_pic?.setOnRefreshListener {
            //onRefresh 一般从顶部下拉刷新时会调用此方法，在此方法设置刷新数据具体逻辑以及设置下拉进度条消失等一些工作
        }

//        rv_pic?.layoutManager = GridLayoutManager(context, 2)
        rv_pic?.addItemDecoration(DividerGridItemDecoration(context))

        rv_pic?.adapter = picAdapter
    }

    override fun itemClick(mPic:PicBean.PicData, position: Int) {
        var intent = Intent(activity, PicDetailActivity::class.java)
        intent.putExtra("picId", mPic.id)
        startActivity(intent)
    }
}