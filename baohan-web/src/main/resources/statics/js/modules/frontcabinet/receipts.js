
var rece=new Vue({
    el: '#rece',
    data: {
        cusCode: '',
        userCode: '',
        cusName: '',
        cargoSource: '',
        cargoState: '',
        cargoNum: '',
        confirmRemark: '',

    },
    methods: {
        greet: function(){
            var cuscode='';
            if(rece.cusCode!=""){
                cuscode=rece.cusCode;
                var url="../../frontcabinet/receipts/getName";
                $.ajax({
                    type: "get",
                    url: url,
                    data: {
                        cuscode:cuscode
                    },
                    dataType: 'json',
                    contentType: "application/json; charset=utf-8",
                    success: function (data) {
                        console.log(data);
                        rece.userCode=data.userCode;
                        rece.cusName=data.cusName;
                    }
                });
            }else{
                layer.msg('唛头不能为空');
            }
        },
        receiptsAdd: function () {
            var url=  "../../frontcabinet/receipts/addManifest";
            console.log(rece.cargoState)
            manifest= {
                cusCode:rece.cusCode,
                userCode:rece.userCode,
                cusName:rece.cusName,
                cargoSource:rece.cargoSource,
                cargoState:rece.cargoState,
                cargoNum:rece.cargoNum,
                confirmRemark:rece.confirmRemark,
            }
            $.ajax({
                type:"post",
                url:url,
                contentType: "application/json",
                data:JSON.stringify(manifest),
                success: function (data) {
                }
            });
        },

    },
});


