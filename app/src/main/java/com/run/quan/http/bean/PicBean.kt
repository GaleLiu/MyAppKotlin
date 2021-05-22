package com.run.quan.http.bean

/**
 * @Description 这里用一句话描述
 * @Author GaleLiu
 * @Time 2021/05/21
 */
class PicBean {

    var data:ArrayList<PicData>?=null

    var meta: PicMeta?=null

    class PicData{
        var id:String?=null
        var url:String?=null
        var short_url:String?=null

        var views:Int?=0
        var favorites:Int?=0

        var source:String?=null
        var purity:String?=null
        var category:String?=null

        var dimension_x:Int?=0
        var dimension_y:Int?=0

        var resolution:String?=null
        var ratio:String?=null

        var file_size:Int?=0

        var file_type:String?=null
        var created_at:String?=null

        var colors = emptyArray<String>()
        var thumbs: PicThumbs?=null

        var path:String?=null
    }

    class PicMeta{
        var current_page:Int?=0
        var last_page:Int?=0
        var per_page:Int?=0
        var total:Int?=0
        var query:Int?=null
        var seed:Int?=null
    }
}