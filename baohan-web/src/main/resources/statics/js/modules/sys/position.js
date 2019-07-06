var xa = new Vue({
    el: '#xa',
    data: {
        showEdit: false,
        dealType: '',
        postionList: "",
        postionCodeTmp: '',
        postionCode: '',
        postionName: '',
        deptId: '',
        postionId:0,
        postionNameForSec:'',
        postionCodeForSec:'',
        deptIdForSec:'',
        getIndex:0,
        pageCount:10,
        deptList:''
    },
    created: function () {
        /**初始化获取第一页数据*/
        var url = "../../sys/position/getPostionPage";
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
                xa.postionList = data;
            }
        });
    },
    methods: {
        getPageData: function (pageIndex,limit) {
            if(xa.getIndex == 1){
                return;
            }
            var url = "../../sys/position/getPostionPage";
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
                    xa.postionList = data;
                }
            });
        },
        postionAdd: function () {
            xa.showEdit = true;
            xa.dealType = 'add';
            $('#editPanel').css('display','block');
        },
        postionEdit: function (postionCode,postionId) {
            xa.showEdit = true;
            xa.dealType = 'edit';
            xa.postionCodeTmp = postionCode;
            xa.postionId = postionId;
            $('#editPanel').css('display','block');
        },
        postionDel: function (postionName, id) {
            console.log(id);
            var showVal = '是否确认删除【' + postionName + '】？';
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
            var url = "sys/position/deletePostionById";
            $.ajax({
                type: "get",
                url: '../../' + url,
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                data: {
                    postionId: id
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
        postionSaveOrUpdate: function () {
            var url = "",postion = {};
            if(xa.dealType == 'add'){
                postion = {
                    code: xa.postionCode,
                    name: xa.postionName,
                    deptId: $('#deptPanel').val()
                };
                url = "sys/position/savePostion";
            }else{
                postion = {
                    id:xa.postionId,
                    code: xa.postionCodeTmp,
                    name: xa.postionName,
                    deptId: $('#deptPanel').val()
                };
                url = "sys/position/editPostion";

            }
            $.ajax({
                type: "POST",
                url: '../../' + url,
                contentType: "application/json",
                data: JSON.stringify(postion),
                success: function (r) {
                    console.log(r);
                    if (r.code === 0) {
                        layer.msg('数据写入成功！', {icon: 1});
                    } else {
                        layer.msg(r.msg(), {icon: 1});
                    }
                }
            });
        },
        postionSearch:function(){
            var code = '',name = '',deptName = null;
            if(xa.postionNameForSec != null){
                name = xa.postionNameForSec;
            }
            if(xa.postionCodeForSec != null){
                code = xa.postionCodeForSec;
            }
            if(xa.deptIdForSec != null){
                deptName = xa.deptIdForSec;
            }
            var url = "../../sys/position/postionSearch";
            $.ajax({
                type: "get",
                url: url,
                data: {
                    code: code,
                    name: name,
                    deptName: deptName
                },
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    xa.postionList = data;
                }
            });
        }
    }
});