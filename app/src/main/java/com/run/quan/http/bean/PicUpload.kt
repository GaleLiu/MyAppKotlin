package com.run.quan.http.bean

import com.google.gson.annotations.SerializedName

/**
 * @Description 这里用一句话描述
 * @Author GaleLiu
 * @Time 2021/05/22
 */
class PicUpload {
    var username:String?=null
    var group:String?=null
    var avatar:PicAvatar?=null

    class PicAvatar {
        @SerializedName("200px")
        var px200: String?=null
        @SerializedName("128px")
        var px128:String?=null
        @SerializedName("32px")
        var px32:String?=null
        @SerializedName("20px")
        var px20:String?=null
    }
}