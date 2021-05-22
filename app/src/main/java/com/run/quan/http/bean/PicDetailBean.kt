package com.run.quan.http.bean

/**
 * @Description 这里用一句话描述
 * @Author GaleLiu
 * @Time 2021/05/22
 */
class PicDetailBean {

    var data:PicDetail?= null

    class PicDetail{
        var id:String?=null
        var url:String?=null
        var short_url:String?=null

        var uploader:PicUpload?=null

        var views:Int?=null
        var favorites:Int?=null

        var source:String?=null
        var purity:String?=null
        var category:String?=null

        var dimension_x:Int?=null
        var dimension_y:Int?=null

        var resolution:String?=null
        var ratio:String?=null

        var file_size:Int?=null

        var file_type:String?=null
        var created_at:String?=null

        var colors = emptyArray<String>()

        var path:String?=null

        var thumbs:PicThumbs?=null
        var tags: ArrayList<PicTag>?=null
    }

    class PicTag{
        var id:Int?=null

        var name:String?=null
        var alias:String?=null
        var category_id:Int?=null
        var category:String?=null
        var purity:String?=null
        var created_at:String?=null
    }
}