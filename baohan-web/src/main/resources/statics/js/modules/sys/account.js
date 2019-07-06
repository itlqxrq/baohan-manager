var xa = new Vue({
    el: '#xa',
    data: {
        accountList: "",
        accountNameForSec:'',
        dealType:"add",
        accountCode:'',
        accountName:'',
        parentName:'',
        parendId:null,
        accountId:null
    },
    created: function () {
        /**初始化获取会计科目数据*/
        var url = "../../sys/account/getPageData";
        $.ajax({
            type: "get",
            url: url,
            data: {},
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                var accountList = [];
                for(var index = 0;index < data.length;index++){
                    var dataTmp = data[index];
                    var idTmp = dataTmp.id,nameTmp = dataTmp.name,parentIdTmp = dataTmp.parentId;
                    if(parentIdTmp == null){
                        var firNode = {};
                        firNode['title'] = nameTmp;
                        firNode['id'] = idTmp;
                        firNode['children'] = [];
                        accountList.push(firNode);
                    }else{
                        for(var i = 0;i<accountList.length;i++){
                            if(parentIdTmp == accountList[i].id){
                                var chileRenNode = {};
                                chileRenNode['title'] = nameTmp;
                                chileRenNode['id'] = idTmp;
                                chileRenNode['children'] = [];
                                accountList[i].children.push(chileRenNode);
                            }else{
                                for(var j=0;j<accountList[i].children.length;j++){
                                    if(accountList[i].children[j].id == parentIdTmp){
                                        var thiChileRenNode = {};
                                        thiChileRenNode['title'] = nameTmp;
                                        thiChileRenNode['id'] = idTmp;
                                        thiChileRenNode['children'] = [];
                                        accountList[i].children[j].children.push(thiChileRenNode);
                                    }
                                }
                            }
                        }
                    }
                }
                xa.accountList = accountList;
            }
        });
    },
    methods: {
        accountSearch:function(){
            xa.dealType = 'edit';
            var url = "../../sys/account/accountSec";
            $.ajax({
                type: "get",
                url: url,
                data: {
                    name: xa.accountNameForSec
                },
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    xa.accountId = data[0].id;
                    xa.accountCode = data[0].code;
                    xa.accountName = data[0].name;
                    xa.parentId = data[0].parendId;
                    xa.parentName = data[0].parentName;
                    //下拉框赋值
                    if(data[0].isOpen == '1'){
                        var select = 'dd[lay-value=' + 1 + ']';
                        $('#isOpenPanel').siblings("div.layui-form-select").find('dl').find(select).click();
                    }else{
                        var select = 'dd[lay-value=' + 0 + ']';
                        $('#isOpenPanel').siblings("div.layui-form-select").find('dl').find(select).click();
                    }
                    if(data[0].isInProfit == '1'){
                        var select = 'dd[lay-value=' + 1 + ']';
                        $('#isInProfitPanel').siblings("div.layui-form-select").find('dl').find(select).click();
                    }else{
                        var select = 'dd[lay-value=' + 0 + ']';
                        $('#isInProfitPanel').siblings("div.layui-form-select").find('dl').find(select).click();
                    }
                }
            });
        },
        accountAdd:function(){
            xa.dealType = 'add';
            xa.accountCode = '';
            xa.accountName = '';
            xa.accountId = '';
            var select = 'dd[lay-value=' + 0 + ']';
            $('#isOpenPanel').siblings("div.layui-form-select").find('dl').find(select).click();
            var select = 'dd[lay-value=' + 0 + ']';
            $('#isInProfitPanel').siblings("div.layui-form-select").find('dl').find(select).click();
        },
        addAndSave:function(){
            var account = {
                code:xa.accountCode,
                name:xa.accountName,
                parentId:$('#parentPanel').val(),
                isOpen:$('#isOpenPanel').val(),
                isInProfit:$('#isInProfitPanel').val()
            };
            var url = "sys/account/accountAdd";
            $.ajax({
                type: "POST",
                url: '../../' + url,
                contentType: "application/json",
                data: JSON.stringify(account),
                success: function (r) {
                    if (r.code === 0) {
                        layer.msg('数据写入成功！', {icon: 1});
                    } else {
                        layer.msg(r.msg(), {icon: 1});
                    }
                }
            });
        },
        editAndSave:function(){
            console.log($('#parentPanel').val());
            var account = {
                id:xa.accountId,
                code:xa.accountCode,
                name:xa.accountName,
                parentId:$('#parentPanel').val(),
                isOpen:$('#isOpenPanel').val(),
                isInProfit:$('#isInProfitPanel').val()
            };
            var url = "sys/account/accountEdit";
            $.ajax({
                type: "POST",
                url: '../../' + url,
                contentType: "application/json",
                data: JSON.stringify(account),
                success: function (r) {
                    if (r.code === 0) {
                        layer.msg('数据写入成功！', {icon: 1});
                    } else {
                        layer.msg(r.msg(), {icon: 1});
                    }
                }
            });
        }
    }
});