let vm = new Vue({
    el: '.main-content',
    data: {
        pageInfo: {
            pageNum: 1,
            pageSize: 5
        },//接受后台页对象
        type:''
    },
    methods: {
        selectPage: function (pageNum, pageSize) {
            //分页查询返回信息放入pageInfo
            //分页查询返回信息放入pageInfo
            axios({
                url:`manager/statute/selectPage/${pageNum}/${pageSize}`,
                params:{type:this.type}
            }).then(response=>{
                // console.log(response);
                this.pageInfo=response.data.obj;
            }).catch(error=>{
                layer.msg(error.message);
            })
        },
        toUpdate: function (obj) {
            //根据传入的app  弹出一个新的更新页面   传入app数据
            //绑定信息到父窗口index.html的layer对象中
            layer.obj = obj;
            layer.open({
                type: 2,    //弹出  frame 窗口
                // title: '更新app',
                area: ['80%', '80%'],  //宽,高   比例是占据父窗口的比例
                content: 'manager/statute/toUpdate',   //请求网页地址
                end: function () {//关闭弹出的子窗口后自动回调
                    console.log("关闭窗口");
                }
            })
        }
    },
    created: function () {
        this.selectPage(1, this.pageInfo.pageSize);
    }
});