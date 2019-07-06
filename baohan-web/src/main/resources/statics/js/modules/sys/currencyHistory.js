var xa = new Vue({
    el: '#xa',
    data: {
        showEdit: false,
        dealType: '',
        currencyList: "",
        getIndex:0,
        pageCount:10,
        currencyNameForSec:null,
        currencyNameEnForSec:null,
        currencyName:'',
        currencyMonth:'',
        currencyNameEn:'',
        effectDate:'',
        rmbExchangeRate:'',
        usdExchangeRate:'',
        hkdExchangeRate:'',
        currencyNameTmp:'',
        currencyIdTmp:''
    },
    created: function () {
        /**初始化获取第一页数据*/
        var url = "../../sys/currencyHistory/getPageData";
        $.ajax({
            type: "get",
            url: url,
            data: {
                pageIndex: 0,
                limit: 10000000
            },
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                console.log(data);
                xa.currencyList = data;
                console.log(xa.currencyList);
            }
        });
    },
    methods: {
        getPageData: function (pageIndex,limit) {
            if(xa.getIndex == 1){
                console.log(xa.currencyList);
                return;
            }
            var url = "../../sys/currencyHistory/getPageData";
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
                    xa.currencyList = data;
                }
            });
        },
        currencySearchForHistory:function(){
            var url = "../../sys/currencyHistory/currencySecForHistyor";
            $.ajax({
                type: "get",
                url: url,
                data: {
                    name: xa.currencyNameForSec,
                    nameEn: xa.currencyNameEnForSec,
                    startDate:$('#startDate').val(),
                    endDate:$('#endDate').val()
                },
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    xa.currencyList = data;
                }
            });
        }
    }
});