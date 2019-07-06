var goods=new Vue({
   el:'#goods',
   data:{
       showEdit: false,
       cusCode:'',
       userCode:'',
       goodsList:'',
       getIndex:0,
       pageCount:10,
   },
    created: function () {
        /**初始化获取第一页数据*/
       var url="../../frontcabinet/Goods/getGoodsPage";
        $.ajax({
            type: "get",
            url: url,
            data: {
                pageIndex: 0,
                limit: 10000000,
            },
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                console.log(data);
                goods.goodsList = data;
                console.log(goods.goodsList);
            }
        });
    },
    methods: {
        getGoodsPage: function (pageIndex,limit) {
            if(goods.getIndex == 1){
                console.log(goods.goodsList);
                return;
            }
            var url = "../../frontcabinet/Goods/getGoodsPage";
            $.ajax({
                type: "get",
                url: url,
                data: {
                    pageIndex: pageIndex,
                    limit:limit
                },
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    goods.goodsList = data;
                }
            });
        },

    }

});