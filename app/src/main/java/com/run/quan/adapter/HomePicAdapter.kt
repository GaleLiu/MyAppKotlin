package com.run.quan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.run.quan.R
import com.run.quan.http.bean.PicBean

/**
 * @Description 这里用一句话描述
 * @Author GaleLiu
 * @Time 2021/05/22
 */
class HomePicAdapter(private var pic:ArrayList<PicBean.PicData>): RecyclerView.Adapter<HomePicAdapter.PicHolder>() {
    private var click:OnItemClick?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicHolder {
        return PicHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pic, parent, false))
    }

    override fun onBindViewHolder(holder: PicHolder, position: Int) {
        holder.img?.let { Glide.with(holder.itemView)
            .asBitmap()
            .override(Target.SIZE_ORIGINAL)
            .load(pic[position].thumbs?.large)
//            .load(pic[position].path)
            .into(it)}

        holder.img?.setOnClickListener { click?.itemClick(pic[position], position) }
    }

    override fun getItemCount(): Int {
        return pic.size
    }

    fun setDatas(pics:ArrayList<PicBean.PicData>){
        if(pics.size <= 0){
            return
        }
        pic.clear()
        pic.addAll(pics)
        notifyDataSetChanged()
    }

    fun setOnItemClick(onItemClick: OnItemClick){
        click = onItemClick
    }

    class PicHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img:ImageView?=null

        init {
            img = itemView.findViewById(R.id.img)
        }
    }

    interface OnItemClick{
        fun itemClick(mPic:PicBean.PicData, position:Int)
    }
}