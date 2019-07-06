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
        var url = "../../sys/currency/getPageData";
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
            var url = "../../sys/currency/getPageData";
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
        royaltyAdd: function () {
            xa.showEdit = true;
            xa.dealType = 'add';
            $('#editPanel').css('display','block');
        },
        currencyEdit: function (currencyName,currencyId,month,nameEn) {
            xa.showEdit = true;
            xa.dealType = 'edit';
            xa.currencyNameTmp = currencyName;
            xa.currencyId = currencyId;
            //写入部分数据
            xa.currencyMonth = month;
            xa.currencyName = currencyName;
            xa.currencyNameEn = nameEn;
            $('#editPanel').css('display','block');
        },
        currencyDel: function (currencyName,currencyId) {
            var showVal = '是否确认删除【' + currencyName + '】？';
            layer.confirm(showVal, {
                btn: ['取消', '确认']
            }, function () {
                layer.msg('操作取消！', {icon: 1});
            }, function () {
                xa.doDel(currencyId);
            });
        },
        xaBck: function () {
            xa.showEdit = false;
            xa.dealType = '';
            $('#editPanel').css('display','none');
        },
        doDel: function (currencyId) {
            var url = "sys/currency/currencyDelById";
            $.ajax({
                type: "get",
                url: '../../' + url,
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                data: {
                    currencyId: currencyId
                },
                success: function (r) {
                    if (r.code === 0) {
                        layer.msg('数据删除成功！', {icon: 1});
                        xa.getIndex = 0;
                        xa.getPageData(0,10);
                    } else {
                        layer.msg(r, {icon: 1});
                    }
                }
            });
        },
        royaltySaveOrUpdate: function () {
            var url = "",royalty = {};
            if(xa.dealType == 'add'){
                royalty = {
                    month: xa.currencyMonth,
                    name: xa.currencyName,
                    nameEn: xa.currencyNameEn,
                    rmbExchangeRate:xa.rmbExchangeRate,
                    usdExchangeRate:xa.usdExchangeRate,
                    hkdExchangeRate:xa.hkdExchangeRate,
                    effectDate:$('#effectDate').val()
                };
                url = "sys/currency/currencyAdd";
            }else{
                royalty = {
                    id:xa.currencyId,
                    month: xa.currencyMonth,
                    name: xa.currencyName,
                    nameEn: xa.currencyNameEn,
                    rmbExchangeRate:xa.rmbExchangeRate,
                    usdExchangeRate:xa.usdExchangeRate,
                    hkdExchangeRate:xa.hkdExchangeRate,
                    effectDate:$('#effectDate').val()
                };
                url = "sys/currency/currencyEdit";

            }
            $.ajax({
                type: "POST",
                url: '../../' + url,
                contentType: "application/json",
                data: JSON.stringify(royalty),
                success: function (r) {
                    console.log(r);
                    if (r.code === 0) {
                        layer.msg('数据写入成功！', {icon: 1});
                        xa.getPageData(0,10);
                    } else {
                        layer.msg(r.msg(), {icon: 1});
                    }
                }
            });
        },
        royaltySearch:function(){
            var url = "../../sys/currency/currencySec";
            $.ajax({
                type: "get",
                url: url,
                data: {
                    name: xa.currencyNameForSec,
                    nameEn: xa.currencyNameEnForSec
                },
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    xa.currencyList = data;
                }
            });
        },
        editPanelHandel:function(){
            // v-if="showEdit && (dealType == 'add' || dealType == 'edit')"
            if(xa.showEdit && (dealType == 'add' || dealType == 'edit')){
                $('#editPanel').css('display','block');
            }
        },
        currencySearchForHistory:function(){
            var url = "../../sys/currency/currencySecForHistyor";
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