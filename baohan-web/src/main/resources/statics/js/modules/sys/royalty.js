var xa = new Vue({
    el: '#xa',
    data: {
        showEdit: false,
        dealType: '',
        royaltyList: "",
        royaltyCodeTmp: '',
        royaltyCode: '',
        postionName: '',
        deptId: '',
        royaltyId:0,
        postionNameForSec:'',
        thresholdForSec:null,
        stepOneForSec:null,
        stepTwoForSec:null,
        getIndex:0,
        pageCount:10,
        threshold:'',
        stepOne:'',
        stepTwo:'',
        isProbation:''
    },
    created: function () {
        /**初始化获取第一页数据*/
        var url = "../../sys/royalty/getPageData";
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
                xa.royaltyList = data;
                console.log(xa.royaltyList);
            }
        });
    },
    methods: {
        getPageData: function (pageIndex,limit) {
            if(xa.getIndex == 1){
                console.log(xa.royaltyList);
                return;
            }
            var url = "../../sys/royalty/getPageData";
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
                    xa.royaltyList = data;
                }
            });
        },
        royaltyAdd: function () {
            xa.showEdit = true;
            xa.dealType = 'add';
            $('#editPanel').css('display','block');
        },
        royaltyEdit: function (royaltyCode,royaltyId) {
            xa.showEdit = true;
            xa.dealType = 'edit';
            xa.royaltyCodeTmp = royaltyCode;
            xa.royaltyId = royaltyId;
            $('#editPanel').css('display','block');
        },
        royaltyDel: function (royaltyName, id) {
            console.log(id);
            var showVal = '是否确认删除【' + royaltyName + '】？';
            layer.confirm(showVal, {
                btn: ['取消', '确认']
            }, function () {
                layer.msg('操作取消！', {icon: 1});
            }, function () {
                xa.doDel(id);
            });
        },
        xaBck: function () {
            xa.showEdit = false;
            xa.dealType = '';
            $('#editPanel').css('display','none');
        },
        doDel: function (id) {
            var url = "sys/royalty/royaltyDelById";
            $.ajax({
                type: "get",
                url: '../../' + url,
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                data: {
                    royaltyId: id
                },
                success: function (r) {
                    if (r.code === 0) {
                        layer.msg('数据删除成功！', {icon: 1});
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
                    isProbation: xa.isProbation,
                    postionName: xa.postionName,
                    threshold: xa.threshold,
                    stepOne:xa.stepOne,
                    stepTwo:xa.stepTwo,
                    isProbation:$('#isProbation').val()
                };
                url = "sys/royalty/royaltyAdd";
            }else{
                royalty = {
                    id:xa.royaltyId,
                    isProbation: xa.isProbation,
                    postionName: xa.postionName,
                    threshold: xa.threshold,
                    stepOne:xa.stepOne,
                    stepTwo:xa.stepTwo,
                    isProbation:$('#isProbation').val()
                };
                url = "sys/royalty/royaltyEdit";

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
            var postionName = null,threshold = 0,stepOne = 0,stepTwo = 0;
            if(xa.postionNameForSec != null){
                postionName = xa.postionNameForSec;
            }
            if(xa.thresholdForSec != null){
                console.log('sadf');
                threshold = xa.thresholdForSec;
            }
            if(xa.stepOneForSec != null){
                stepOne = xa.stepOneForSec;
            }
            if(xa.stepTwoForSec != null){
                stepTwo = xa.stepTwoForSec;
            }
            var url = "../../sys/royalty/royaltySec";
            $.ajax({
                type: "get",
                url: url,
                data: {
                    postionName: postionName,
                    threshold: parseFloat(threshold),
                    stepOne: parseFloat(stepOne),
                    stepTwo:parseFloat(stepTwo)
                },
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    xa.royaltyList = data;
                }
            });
        },
        editPanelHandel:function(){
            // v-if="showEdit && (dealType == 'add' || dealType == 'edit')"
            if(xa.showEdit && (dealType == 'add' || dealType == 'edit')){
                $('#editPanel').css('display','block');
            }
        }
    }
});